"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var material_1 = require("@angular/material");
var aportacion_create_dto_1 = require("../_dto/aportacion-create.dto");
var DialogNuevaAportacionComponent = /** @class */ (function () {
    function DialogNuevaAportacionComponent(aportacionService, datosMaestrosService, dialogRef, data) {
        this.aportacionService = aportacionService;
        this.datosMaestrosService = datosMaestrosService;
        this.dialogRef = dialogRef;
        this.data = data;
    }
    DialogNuevaAportacionComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.idCampanya = this.data.idCamp;
        this.datosMaestrosService.getAllDatos().subscribe(function (datosList) {
            _this.datosMaestros = datosList;
        }, function (error) {
            console.log('Error. No recibe datos.');
        });
    };
    DialogNuevaAportacionComponent.prototype.saveAportacion = function () {
        var _this = this;
        var aportacionCreate = new aportacion_create_dto_1.AportacionCreateDto(this.dato, this.cantidad, this.idCampanya, this.idDatosMaestros);
        this.aportacionService.createAportacion(aportacionCreate).subscribe(function (aportacion) {
            _this.dialogRef.close(aportacion);
        });
    };
    DialogNuevaAportacionComponent = __decorate([
        core_1.Component({
            selector: 'app-dialog-nueva-aportacion',
            templateUrl: './dialog-nueva-aportacion.component.html',
            styleUrls: ['./dialog-nueva-aportacion.component.css']
        }),
        __param(3, core_1.Inject(material_1.MAT_DIALOG_DATA))
    ], DialogNuevaAportacionComponent);
    return DialogNuevaAportacionComponent;
}());
exports.DialogNuevaAportacionComponent = DialogNuevaAportacionComponent;
