// Funcion para hacer un preview de una imagen
function mostrarImagen(input) {

    if (input.files && input.files[0]) {

        const imagen = input.files[0];
        const maximo = 512 * 1024; // Se limita el tamaño a 512 KB

        if (imagen.size <= maximo) {

            const lector = new FileReader();

            lector.onload = function (e) {

                const preview = document.getElementById('blah');

                preview.src = e.target.result;
                preview.style.height = '200px';
                preview.style.display = 'block';
            };

            lector.readAsDataURL(imagen);

        } else {

            alert("La imagen seleccionada es muy grande... no debe superar los 512 Kb!");

            input.value = "";

            const preview = document.getElementById('blah');

            if (preview) {
                preview.src = "";
                preview.style.display = "none";
            }
        }
    }
}


// Para insertar información en el modal según el registro
document.addEventListener('DOMContentLoaded', function () {

    const confirmModal = document.getElementById('confirmModal');

    if (confirmModal) {

        confirmModal.addEventListener('show.bs.modal', function (event) {

            const button = event.relatedTarget;

            document.getElementById('modalId').value =
                    button.getAttribute('data-bs-id');

            document.getElementById('modalDescripcion').textContent =
                    button.getAttribute('data-bs-descripcion');
        });
    }
});


// Para quitar Toast después de 4 segundos
setTimeout(() => {

    document.querySelectorAll('.toast').forEach(t => {
        t.classList.remove('show');
    });

}, 4000);