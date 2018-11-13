"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var environment_prod_1 = require("src/environments/environment.prod");
var core_1 = require("@angular/core");
var http_1 = require("@angular/common/http");
var aportacionUrl = environment_prod_1.environment.apiUrl + "/aportaciones";
var AportacionService = /** @class */ (function () {
    function AportacionService(http, authService) {
        this.http = http;
        this.authService = authService;
    }
    AportacionService.prototype.createAportacion = function (aportacionCreateDto) {
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http.post(aportacionUrl + "/nuevaAportacion", aportacionCreateDto, requestOptions);
    };
    AportacionService.prototype.getAllAportaciones = function () {
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http.get(aportacionUrl + "/listaAportaciones", requestOptions);
    };
    AportacionService.prototype.deleteAportacion = function (element) {
        console.log(element);
        var requestOptions = {
            headers: new http_1.HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + this.authService.getToken(),
                'Access-Control-Allow-Origin': '*'
            })
        };
        return this.http["delete"](aportacionUrl + "/remove/" + element.id, requestOptions);
    };
    AportacionService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], AportacionService);
    return AportacionService;
}());
exports.AportacionService = AportacionService;
