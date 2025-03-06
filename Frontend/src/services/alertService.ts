import Swal from 'sweetalert2';

export const alertService = {
    success: (message: string) => {
        return Swal.fire({
            title: '¡Éxito!',
            text: message,
            icon: 'success',
            confirmButtonText: 'Aceptar',
            confirmButtonColor: '#198754'
        });
    },

    error: (message: string) => {
        return Swal.fire({
            title: 'Error',
            text: message,
            icon: 'error',
            confirmButtonText: 'Aceptar',
            confirmButtonColor: '#dc3545'
        });
    },

    confirm: (message: string) => {
        return Swal.fire({
            title: '¿Estás seguro?',
            text: message,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#dc3545',
            cancelButtonColor: '#6c757d',
            confirmButtonText: 'Sí, eliminar',
            cancelButtonText: 'Cancelar'
        });
    }
}; 