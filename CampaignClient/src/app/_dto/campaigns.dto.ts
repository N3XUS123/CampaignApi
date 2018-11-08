export class CampaignsDto {
    id: number;
    nombre: string;
    unido: boolean;

    constructor(i: number, n: string, u: boolean) {
        this.id = i;
        this.nombre = n;
        this.unido = u;
    }
}