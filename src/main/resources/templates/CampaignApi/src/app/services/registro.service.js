"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var http_1 = require("@angular/common/http");
var environment_prod_1 = require("src/environments/environment.prod");
var registro_dto_1 = require("../dto/registro.dto");
var registroUrl = environment_prod_1.environment.apiUrl + "/mynotesapi/auth";
var requestOptions = {
    headers: new http_1.HttpHeaders({
        'Content-Type': 'application/json'
    })
};
var RegistroService = /** @class */ (function () {
    function RegistroService(http) {
        this.http = http;
    }
    RegistroService.prototype.registro = function (registroDto) {
        return this.http.post(registroUrl + "/login", registro_dto_1.RegistroDto, requestOptions);
    };
    RegistroService.prototype.setRegistroData = function (registroResponse) {
        localStorage.setItem('nombreUsuario', registroResponse.nombreUsuario);
        localStorage.setItem('email', registroResponse.email);
        localStorage.setItem('contrasenya', registroResponse.contrasenya);
        localStorage.setItem('grupo', registroResponse.grupo);
    };
    RegistroService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], RegistroService);
    return RegistroService;
}());
exports.RegistroService = RegistroService;
