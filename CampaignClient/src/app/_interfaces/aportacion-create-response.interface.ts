import { User } from "./user.interface";

export interface AportacionCreateResponse {
    user: User;
    dato: string;
    cantidad: number;
}