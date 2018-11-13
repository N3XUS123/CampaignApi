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
var authUrl = "http://localhost:9000";
var requestOptions = {
    headers: new http_1.HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    })
};
var AuthService = /** @class */ (function () {
    function AuthService(http) {
        this.http = http;
    }
    // login(param1, param2): tipoQueDevuelveElMetodo
    AuthService.prototype.login = function (loginDto) {
        return this.http.post(authUrl + "/auth", loginDto, requestOptions);
    };
    AuthService.prototype.setLoginData = function (loginResponse) {
        localStorage.setItem('token', loginResponse.token);
        localStorage.setItem('email', loginResponse.email);
        localStorage.setItem('username', loginResponse.username);
        var admin = 'false';
        if (loginResponse.admin)
            admin = 'true';
        localStorage.setItem('admin', admin);
    };
    AuthService.prototype.getToken = function () {
        return localStorage.getItem('token');
    };
    AuthService.prototype.removeLoginData = function () {
        localStorage.removeItem('token');
        localStorage.removeItem('email');
        localStorage.removeItem('username');
    };
    AuthService = __decorate([
        core_1.Injectable({
            providedIn: 'root'
        })
    ], AuthService);
    return AuthService;
}());
exports.AuthService = AuthService;
