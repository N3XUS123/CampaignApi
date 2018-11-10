export class CampaignsDto {
    id: number;
    nombreCampanya: string;
    codigo: string;

    constructor(i: number, n: string, c: string) {
        this.id = i;
        this.nombreCampanya = n;
        this.codigo = c;
    }
}