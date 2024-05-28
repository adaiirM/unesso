// Función para mostrar la ventana modal
function mostrarModal() {
    document.getElementById('modal').style.display = 'block';
}

// Función para cerrar la ventana modal
function cerrarModal() {
    document.getElementById('modal').style.display = 'none';
}

function misDatos() {
    document.getElementById('modal2').style.display = 'block';
}

function cerrarModal2() {
    document.getElementById('modal2').style.display = 'none';
}

 /*--------- SE AGREGA EL FOOTER ---------*/
 document.addEventListener("DOMContentLoaded", function () {
    const footerContainer = document.getElementById('footer');
    fetch("footer.html")
        .then(response => response.text())
        .then(html => {
            footerContainer.innerHTML = html;
        });
});

/*--------- SE AGREGA EL NAV DE ALUMNO---------*/
document.addEventListener("DOMContentLoaded", function () {
    const footerContainer = document.getElementById('nav');
    fetch("navAlumnos.html")
        .then(response => response.text())
        .then(html => {
            footerContainer.innerHTML = html;
        });
});

/*--------- SE AGREGA EL NAV DE REVISOR---------*/
document.addEventListener("DOMContentLoaded", function () {
    const footerContainer = document.getElementById('navRevisor');
    fetch("navRevisor.html")
        .then(response => response.text())
        .then(html => {
            footerContainer.innerHTML = html;
        });
});

/*--------- SE AGREGA EL NAV DE ADMINISTRADOR---------*/
document.addEventListener("DOMContentLoaded", function () {
    const footerContainer = document.getElementById('navAdministrador');
    fetch("navAdministrador.html")
        .then(response => response.text())
        .then(html => {
            footerContainer.innerHTML = html;
        });
});



function limitarLongitud(event) {
    const input = event.target;
    if (input.value.length > 10) {
        input.value = input.value.slice(0, 10);
    }
}

function obtenerMunicipios(){
	var select = document.getElementById('selectEstados');
	select.addEventListener('change',
	  function(){
	    //var selectedOption = this.options[select.selectedIndex];
	    selectIndex = select.selectedIndex;
	    $.ajax({
	        url: '/domicilio/obtenerMunicipiosPorEstado',
	        type: 'GET',
	        data: { estadoId: selectIndex},
	        success: function(data) {
	            actualizarSelectMunicipios(data);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });
	  });
}

function actualizarSelectMunicipios(municipios) {
    var selectMunicipios = document.getElementById("selectMunicipios");
    selectMunicipios.innerHTML = ""; // Limpiar la lista de municipios
	
    municipios.forEach(function(municipio) {
        var option = document.createElement("option");
        option.value = municipio.idCatMunicipio;
        option.text = municipio.nombreMunicipio;
        selectMunicipios.appendChild(option);
    });
}

function obtenerLocalidad(){
	var select = document.getElementById('selectMunicipios');
	//console.log(select.value);
	select.addEventListener('change',
	  function(){
	    //var selectedOption = this.options[select.selectedIndex];
	    selectIndex = select.value;
	    $.ajax({
	        url: '/domicilio/obtenerLocalidadesPorMunicipio',
	        type: 'GET',
	        data: { municipioId: selectIndex},
	        success: function(data) {
	            //console.log(data);
	            actualizarSelectLocalidad(data);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });
	  });
}

function actualizarSelectLocalidad(localidades) {
    var selectLocalidad = document.getElementById("selectLocalidades");
    selectLocalidad.innerHTML = ""; // Limpiar la lista de municipios
	
    localidades.forEach(function(localidad) {
        var option = document.createElement("option");
        option.value = localidad.idCatLocalidad;
        option.text = localidad.nombreLocalidad;
        selectLocalidad.appendChild(option);
    });
}

function obtenerCodigoPostal(){
	var select = document.getElementById('selectLocalidades');
	//console.log(select.value);
	select.addEventListener('change',
	  function(){
	    //var selectedOption = this.options[select.selectedIndex];
	    selectIndex = select.value;
	    $.ajax({
	        url: '/domicilio/obtenerCodigoPostalPorLocalidad',
	        type: 'GET',
	        data: { localidadId: selectIndex},
	        success: function(data) {
	            actualizarInputCP(data);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });	
	  });
}

function actualizarInputCP(cp) {
    var inputCP = document.getElementById('cp');
    console.log(cp.numeroCodigoPostal);
    inputCP.value = null;
	inputCP.value = cp.numeroCodigoPostal;
}



function generarPersonas() {
    // Obtén el valor ingresado por el usuario
    const numPersonas = parseInt(document.getElementById('numPersonasAportan').value);
	
    // Referencia al contenedor donde se agregarán los elementos
    const container = document.getElementById('containerPersonas');

    // Limpia el contenedor antes de agregar nuevos elementos
    container.innerHTML = '';

	for (let i = 0; i < numPersonas; i++) {
		let opcionesParentesco = '';
        parentescos.forEach(catParentesco => {
            opcionesParentesco += `<option value="${catParentesco.idCatParentesco}"  class="subtitulo" >${catParentesco.nombreParentesco}</option>`;
        });
		var newElement = `
        <div class="rounded" style="display:flex; border: 1px solid #6C757D; padding-bottom: 10px;">
            <div style="border-radius: 5px; border-color: black; margin: 6px;">
                <a class="textoInputs" style="text-decoration: none;">Nombre completo</a>
                <br><br>
                <input name="ingresoFamiliar[${i}].nombrePersona" type="text" th:field="*{ingresoFamiliar[__${i}__].nombrePersona}" id="nombrePersona" class="rounded estiloInputs" style="border-color: #6366F1; width: 260px; height: 40px;">
            	<p>${i}</p>
            </div>
            <div style="border-radius: 5px; border-color: black; margin: 6px;">
                <a class="textoInputs" style="text-decoration: none;">Parentesco</a><!-- colocar un combobox -->
                <br><br>
                <select name="ingresoFamiliar[${i}].catParenteso" class="form-select estiloInputs" style="width: 180px;height: 40px;" aria-label="Default select example">
                	 ${opcionesParentesco}
                </select>
            </div>
            
            <div style="border-radius: 5px; border-color: black; margin: 6px;">
                <a class="textoInputs" style="text-decoration: none;">Empresa o lugar de trabajo</a>
                <br><br>
                <input type="text" id="correoLogin" class="rounded estiloInputs" style="border-color: #6366F1; width: 250px; height: 40px;">
            </div>
            
            <div style="border-radius: 5px; border-color: black; margin: 6px;">
                <a class="textoInputs" style="text-decoration: none;">Puesto o tipo de trabajo</a>
                <br><br>
                <input type="text" id="correoLogin" class="rounded estiloInputs" style="border-color: #6366F1; width: 220px; height: 40px;">    
            </div>
        
            <div style="border-radius: 5px; border-color: black; margin: 6px;">
                <a class="textoInputs" style="text-decoration: none;">IMB</a>
                <br>
                <a style="color: #6C757D; font-size: 14px;">(Ingreso mensual bruto)</a>
                
                <input name="ingresoFamiliar[${i}].ingresoBruto" th:field="*{ingresoFamiliar[__${i}__].ingresoBruto}" type="text" id="ingresoBruto" class="rounded estiloInputs" style="border-color: #6366F1; width: 130px; height: 40px;">
            </div>
            
            <div style="border-radius: 5px; border-color: black; margin: 6px;"><!-- HACERLO LAS PEQUEÑO -->
                <a class="textoInputs" style="text-decoration: none;">IMN</a>
                <br>
                <a style="color: #6C757D; font-size: 14px;">(Ingreso mensual neto)</a>
                
                <input name="ingresoFamiliar[${i}].ingresoNeto" th:field="*{ingresoFamiliar[__${i}__].ingresoNeto}" type="text" id="correoLogin" class="rounded estiloInputs" style="border-color: #6366F1; width: 130px; height: 40px;">
            </div>
            
        </div>
        <br>
        `;
        container.innerHTML += newElement;
   	}
    
};