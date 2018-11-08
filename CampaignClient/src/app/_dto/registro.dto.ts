export class RegistroDto {
    username: string;
    email: string;
    password: string;
    grupo: string;

    constructor(u: string, e: string, c: string, g: string) {
        this.username = u;
        this.email = e;
        this.password = c;
        this.grupo = g;
    }
}