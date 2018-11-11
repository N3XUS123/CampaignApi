export class DatoCreateDto {
    tipo: string;
    idCampanya: number;

    constructor(t: string, c: number) {
        this.tipo = t;
        this.idCampanya = c;
    }
}