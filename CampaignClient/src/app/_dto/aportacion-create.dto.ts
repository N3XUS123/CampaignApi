export class AportacionCreateDto {
    dato: string;
    cantidad: number;
    idCampanya: number;
    idDatosMaestro: number;

    constructor(dato: string, cantidad: number, idCampanya: number, idDatosMaestro: number) {
        this.dato = dato;
        this.cantidad = cantidad;
        this.idCampanya = idCampanya;
        this.idDatosMaestro = idDatosMaestro;
    }
}