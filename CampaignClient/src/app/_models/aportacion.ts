export class Aportacion {
    id: number;
    dato: string;
    cantidad: number;
    fecha: string;

    constructor(d: string, c: number, f: string) {
        this.dato = d;
        this.cantidad = c;
        this.fecha = f;
    }
}