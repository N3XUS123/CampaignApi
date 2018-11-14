export class Aportacion {
    datosMaestros: string;
    id: number;
    dato: string;
    cantidad: number;
    fecha: string;

    constructor(dM: string, d: string, c: number, f: string) {
        this.datosMaestros = dM;
        this.dato = d;
        this.cantidad = c;
        this.fecha = f;
    }
}