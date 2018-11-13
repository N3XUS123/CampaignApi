"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var dialog_nueva_aportacion_component_1 = require("../dialog-nueva-aportacion/dialog-nueva-aportacion.component");
var RankingAportacionesComponent = /** @class */ (function () {
    function RankingAportacionesComponent(aportacionService, snackBar, dialog, router) {
        this.aportacionService = aportacionService;
        this.snackBar = snackBar;
        this.dialog = dialog;
        this.router = router;
        this.displayedColumns = ['dato', 'cantidad', 'fecha'];
    }
    RankingAportacionesComponent.prototype.ngOnInit = function () {
        this.getAportaciones('Listado de datos cargado');
    };
    RankingAportacionesComponent.prototype.getAportaciones = function (mensaje) {
        var _this = this;
        this.aportacionService.getAllAportaciones().subscribe(function (listaAportaciones) {
            _this.dataSource = listaAportaciones;
            _this.snackBar.open(mensaje, 'Cerrar', {
                duration: 3000,
                verticalPosition: 'top'
            });
        }, function (error) {
            _this.snackBar.open('Error al obtener datos', 'Cerrar', {
                duration: 3000
            });
        });
    };
    RankingAportacionesComponent.prototype.openAportacionDialog = function (campaign) {
        var dialogRef = this.dialog.open(dialog_nueva_aportacion_component_1.DialogNuevaAportacionComponent, {
            width: '250px',
            data: { idCamp: campaign.id }
        });
    };
    RankingAportacionesComponent.prototype.eliminarAportacion = function (aportacion) {
        var _this = this;
        this.aportacionService.deleteAportacion(aportacion).subscribe(function (listaAportaciones) {
            _this.dataSource = listaAportaciones;
        });
        this.snackBar.open("Eliminando " + aportacion.dato, 'Cerrar', {
            duration: 3000
        });
    };
    RankingAportacionesComponent = __decorate([
        core_1.Component({
            selector: 'app-ranking-aportaciones',
            templateUrl: './ranking-aportaciones.component.html',
            styleUrls: ['./ranking-aportaciones.component.css']
        })
    ], RankingAportacionesComponent);
    return RankingAportacionesComponent;
}());
exports.RankingAportacionesComponent = RankingAportacionesComponent;
