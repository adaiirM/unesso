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

// Función para resetear la validación de un campo específico
function resetFieldValidation(fieldName) {
    var validator = $("#formDependienteEconomico").validate();
    var field = $("[id='" + fieldName + "']");
    validator.resetElements(field);
    field.removeClass("error");
    field.parent().find("label.error").remove();
}

function obtenerMunicipiosDP(selectEstados, selectLocalidades, selectMunicipios, inputCodigoP){
	var select = document.getElementById(selectEstados);
	var selectLocalidad = document.getElementById(selectLocalidades);
	select.addEventListener('change',
	  function(){
	    //var selectedOption = this.options[select.selectedIndex];
	    selectIndex = select.selectedIndex;
	    $.ajax({
	        url: '/domicilio/obtenerMunicipiosPorEstado',
	        type: 'GET',
	        data: { estadoId: selectIndex},
	        success: function(data) {
	            actualizarSelectMunicipiosDP(data, selectMunicipios);
	            selectLocalidad.innerHTML = "";
	            actualizarInputCP("", inputCodigoP, selectMunicipios, selectLocalidades);
	            var option = document.createElement("option");
			        option.value = "";
			        option.text = "Elige una opción";
			        selectLocalidad.appendChild(option);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });
	  });
}

function actualizarSelectMunicipiosDP(municipios, selectMunicipios) {
    var selectMunicipio = document.getElementById(selectMunicipios);
    selectMunicipio.innerHTML = ""; // Limpiar la lista de municipios

	var option = document.createElement("option");
        option.value = "";
        option.text = "Elige una opción";
        selectMunicipio.appendChild(option);
	
	
    municipios.forEach(function(municipio) {
        var option = document.createElement("option");
        option.value = municipio.idCatMunicipio;
        option.text = municipio.nombreMunicipio;
        selectMunicipio.appendChild(option);
    });
}

function obtenerLocalidadDP(selectMunicipios, selectLocalidades, inputCodigoP){
	var select = document.getElementById(selectMunicipios);
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
	            actualizarInputCP("", inputCodigoP, selectMunicipios, selectLocalidades);
	            actualizarSelectLocalidadDP(data, selectLocalidades);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });
	  });
}

function actualizarSelectLocalidadDP(localidades, selectLocalidades) {
    var selectLocalidad = document.getElementById(selectLocalidades);
    selectLocalidad.innerHTML = ""; // Limpiar la lista de municipios
	
	var option = document.createElement("option");
        option.value = "";
        option.text = "Elige una opción";
        selectLocalidad.appendChild(option);
        
    localidades.forEach(function(localidad) {
        var option = document.createElement("option");
        option.value = localidad.idCatLocalidad;
        option.text = localidad.nombreLocalidad;
        selectLocalidad.appendChild(option);
    });
}

function obtenerCodigoPostal(selectMunicipios, selectLocalidades, inputCodigoP){
	var select = document.getElementById(selectLocalidades);
	//console.log(select.value);
	select.addEventListener('input',
	  function(){
	    //var selectedOption = this.options[select.selectedIndex];
	    selectIndex = select.value;
	    $.ajax({
	        url: '/domicilio/obtenerCodigoPostalPorLocalidad',
	        type: 'GET',
	        data: { localidadId: selectIndex},
	        success: function(data) {
	            actualizarInputCP(data.numeroCodigoPostal, inputCodigoP, selectMunicipios, selectLocalidades);
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });	
	  });
}

function actualizarInputCP(cp, inputCodigoP, selectMunicipios, selectLocalidades) {
    var inputCP = document.getElementById(inputCodigoP);
    var municipio = document.getElementById(selectMunicipios);
	var localidad = document.getElementById(selectLocalidades);

    if(municipio.value === "" && localidad.value === ""){
		inputCP.value = null;
	}
	
    inputCP.value = null;
	inputCP.value = cp;    
}



function generarPersonas() {
    // Obtén el valor ingresado por el usuario
    const numPersonas = parseInt(document.getElementById('numPersonasAportan').value);
	
    // Referencia al contenedor donde se agregarán los elementos
    const container = document.getElementById('containerPersonas');
    		container.innerHTML = '';


    // Limpia el contenedor antes de agregar nuevos elementos

	//if(numPersonas >= 0 && numPersonas <= 3){
		    container.innerHTML = '';

		for (let i = 0; i < numPersonas; i++) {
			let opcionesParentesco = '';
	        parentescos.forEach(catParentesco => {
	            opcionesParentesco += `<option value="${catParentesco.idCatParentesco}"  class="subtitulo" >${catParentesco.nombreParentesco}</option>`;
	        });
			var newElement = `
	        
	        <div class="rounded mb-4">
	            <div class="row">
	                <div class="col-sm-6 col-xl-4">
	                    <p class="textoInputs">Nombre completo</p>
	                    <input th:field="*{ingresoFamiliar[__${i}__].nombrePersona}" id="nombrePersona" name="ingresoFamiliar[${i}].nombrePersona" type="text" class="form-control estiloInputs rounded" style="width: 100%;" id="inputNombre" placeholder="">
	                </div>
	                <div class="col-sm-6 col-xl-4">
	                    <p class="textoInputs">Parentesco</p>
	                    <select name="ingresoFamiliar[${i}].catParentesco" class="form-select estiloInputs" style="width: 100%;" aria-label="Default select example">
	                        <option value="" class="subtitulo">Elige una opcion</option>
	                        ${opcionesParentesco}
	                    </select>
	                </div>
	                
	                <div class="col-sm-6 col-xl-4">
	                    <p class="textoInputs">Empresa o lugar de trabajo</p>
	                    <input name="ingresoFamiliar[${i}].lugarTrabajo" th:field="*{ingresoFamiliar[__${i}__].lugarTrabajo}" id="lugarTrabajo" 
	                    		type="text" class="form-control estiloInputs rounded" style="width: 100%;" id="inputNombre" placeholder="">
	                </div>
	                
	                <div class="col-sm-6 col-xl-4">
	                    <p class="textoInputs">Puesto o tipo de trabajo</p>
	                    <input name="ingresoFamiliar[${i}].puestoTrabajo" th:field="*{ingresoFamiliar[__${i}__].puestoTrabajo}" id="puestoTrabajo" 
	                    	 	type="text" class="form-control estiloInputs rounded" style="width: 100%;" placeholder="">
	                </div>
	            
	                <div class="col-sm-6 col-xl-4">
	                    <p>IMB <span style="color: #6C757D;">(Ingreso Mensual Bruto)</span></p>
	                    <input name="ingresoFamiliar[${i}].ingresoBruto" th:field="*{ingresoFamiliar[__${i}__].ingresoBruto}" id="ingresoBruto" type="text" class="form-control estiloInputs rounded" style="width: 100%;" id="inputNombre" placeholder="">
	                    </div>
	                
	                <div class="col-sm-6 col-xl-4">
	                    <p>IMN <span style="color: #6C757D;">(Ingreso Mensual Neto)</span></p>
	                    <input name="ingresoFamiliar[${i}].ingresoNeto" th:field="*{ingresoFamiliar[__${i}__].ingresoNeto}" type="text" class="form-control estiloInputs rounded" style="width: 100%;" id="inputNombre" placeholder="">
	                </div>
					<!--
	                <div class="col-sm-6 col-xl-4">
	                    <p>Ingreso Total: <span style="color: #6C757D;">$200.5</span></p>
	                </div>-->
	            </div>
	    	</div>
	        <hr>
	        `;
	        container.innerHTML += newElement;
	   	}
	/*} else {
		alert("Num persona");
		container.innerHTML = '';

	}*/

	
    
    fetch('/api/productos')
    .then(response => response.json())
    .then(data => {
        // Hacer algo con los datos obtenidos, por ejemplo, mostrarlos en la página web
        console.log(data);
    })
    .catch(error => {
        console.error('Error al obtener los datos de productos:', error);
    });
};

document.addEventListener('DOMContentLoaded', function() {
	  
	var selectLocalidad = document.getElementById('selectLocalidades');
	var selectMunicipio = document.getElementById('selectMunicipios');

	let idCatEstado = document.getElementById('idCatEstado').value;
	let idCatMunicipio = document.getElementById('idCatMunicipio').value;
	let idCatLocalidad = document.getElementById('idCatLocalidad').value;
	
	 $.ajax({
        url: '/domicilio/obtenerMunicipiosPorEstado',
        type: 'GET',
        data: { estadoId: idCatEstado},
        success: function(data) {
            actualizarSelectMunicipiosDP(data, 'selectMunicipios');
            selectMunicipio.value = idCatMunicipio;
            selectLocalidad.innerHTML = "";
            
            $.ajax({
		        url: '/domicilio/obtenerLocalidadesPorMunicipio',
		        type: 'GET',
		        data: { municipioId: idCatMunicipio},
		        success: function(data) {
		            actualizarSelectLocalidadDP(data, 'selectLocalidades');
		            selectLocalidad.value = idCatLocalidad;
		        },
		        error: function(xhr, status, error) {
		            console.error(error);
		        }
		    });
            
        },
        error: function(xhr, status, error) {
            console.log("Error" + error);
            console.error(error);
        }
	    });
});


///////////////////////////////////////////////

function obtenerMunicipios(estado){
		$.ajax({
                url: '/direccion/municipiosById/' + estado,
                type: 'GET',
                success: function(data) {
                    var municipioSelect = $('#catMunicipio');
                    municipioSelect.empty();
                    municipioSelect.append('<option class="subtitulo" value="">Elige una opción</option>');
                    $.each(data, function(index, municipio) {
                        municipioSelect.append('<option class="subtitulo" value="' + municipio.idCatMunicipio + '">' + municipio.nombreMunicipio + '</option>');
                    });
                }
            });
	}
	
	function obtenerLocalidadesDeMunicipio(municipio){
		 $.ajax({
            url: '/direccion/localidadesById/' + municipio,
            type: 'GET',
            success: function(data) {
                var municipioSelect = $('#catLocalidad');
                municipioSelect.empty();
                console.log(data);
                municipioSelect.append('<option value="">Elige una opción</option>');
                $.each(data, function(index, localidad) {
					console.log(data.idCatLocalidad);
                    municipioSelect.append('<option value="' + localidad.idCatLocalidad + '">' + localidad.nombreLocalidad  + '</option>');
                	
                });
            }
        });
	}
	
	function obtenerCPdeLocalidad(localidad){
		$.ajax({
            url: '/direccion/codigoPostalById/' + localidad,
            type: 'GET',
            success: function(data) {
	            // Se establece el valor del campo #codigoPostal con el valor obtenido
	            $('#codigoPostal').val(data.numeroCodigoPostal);
	        }
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


//Obtener municipio al que pertenece una localidad
async function fetchMunicipioByIdLocalidad(idLocalidad) {
    return $.ajax({
        url: `/direccion/municipioByIdLocalidad/${idLocalidad}`,
        type: 'GET'
    });
}

//Obtener el estado al que pertenece un municipio
async function fetchEstadoByIdMunicipio(idMunicipio) {
    return $.ajax({
        url: `/direccion/estadoByIdMunicipio/${idMunicipio}`,
        type: 'GET'
    });
}

//Obtener municipios de un estado
async function fetchMunicipiosByIdEstado(idEstado) {
    return $.ajax({
        url: `/direccion/municipiosById/${idEstado}`,
        type: 'GET'
    });
}

//Obtener localidades de un municipio
async function fetchLocalidadesByIdMunicipio(idMunicipio) {
    return $.ajax({
        url: `/direccion/localidadesById/${idMunicipio}`,
        type: 'GET'
    });
}

//Obtener CP de una localidad
async function fetchCodigoPostalByIdLocalidad(idLocalidad) {
    return $.ajax({
        url: `/direccion/codigoPostalById/${idLocalidad}`,
        type: 'GET'
    });
}



