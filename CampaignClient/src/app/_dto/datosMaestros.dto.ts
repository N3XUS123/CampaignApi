export class DatoCreateDto {
    tipo: string;
    campanya: string;

    constructor(t: string, c: string) {
        this.tipo = t;
        this.campanya = c;
    }
}