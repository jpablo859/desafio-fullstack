export interface User {
    id: number;
    nombres: string;
    apellidos: string;
    rut: string;
    dv: string;
    fechaNacimiento: string;
    correoElectronico: string;
    contrasena: string;
}

export interface UserFormData {
    nombres: string;
    apellidos: string;
    rut: string;
    dv: string;
    fechaNacimiento: string;
    correoElectronico: string;
    contrasena: string;
} 