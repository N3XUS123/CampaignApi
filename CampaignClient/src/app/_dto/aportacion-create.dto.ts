export class AportacionCreateDto {
    dato: string;
    cantidad: number;

    constructor(dato: string, cantidad: number) {
        this.dato = dato;
        this.cantidad = cantidad;
    }
}