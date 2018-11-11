export class DatoMaestro {
    tipo: string;
    id_campanya: number;

    constructor(t: string, c: number) {
        this.tipo = t;
        this.id_campanya = c;
    }
}