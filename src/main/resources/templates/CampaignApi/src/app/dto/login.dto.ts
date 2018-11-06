export class LoginDto {
    username: string;
    password: string;

    constructor(e: string, p: string) {
        this.username = e;
        this.password = p;
    }
}