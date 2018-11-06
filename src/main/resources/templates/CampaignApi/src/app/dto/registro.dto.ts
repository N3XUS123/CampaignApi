export class RegistroDto {
    nombreUsuario: string;
    email: string;
    contrasenya: string;
    grupo: string;

    constructor(n: string, e: string, c: string, g: string) {
        this.nombreUsuario=n;
        this.email = e;
        this.contrasenya = c;
        this.grupo=g;
    }
}