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