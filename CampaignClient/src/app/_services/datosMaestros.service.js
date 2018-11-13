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
var datosUrl = environment_prod_1.environment.apiUrl + "/datosMaestros";
var DatosService = /** @class */ (function () {
    function DatosService(http, authService) {
        this.http = http;
        this.authService = authService;
    }
    DatosService.prototype.createDato = function (datoCreateDto) {
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http.post(datosUrl + "/add", datoCreateDto, requestOptions);
    };
    DatosService.prototype.editDato = function (datoEditadoDto) {
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http.post(datosUrl + "/edit", datoEditadoDto, requestOptions);
    };
    DatosService.prototype.deleteDato = function (element) {
        console.log(element);
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http["delete"](datosUrl + "/remove/" + element.id, requestOptions);
    };
    DatosService.prototype.getAllDatos = function () {
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http.get(datosUrl + "/list", requestOptions);
    };
    DatosService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], DatosService);
    return DatosService;
}());
exports.DatosService = DatosService;
