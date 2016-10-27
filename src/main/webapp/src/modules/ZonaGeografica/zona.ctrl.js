/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function(ng)
{
    var mod = ng.module("AppZona");
  mod.controller('zonaCtrl', ['$scope','zonaSVC', function ($scope,svc){
    //Acordarse que estas variables no son universales, falta implementar
    //un servicio que las vuelvas de este carácter
    $scope.zonas =  svc.darZonas();
        
        $scope.newZona = function ()
        {
           svc.agregarZona({nombre:$scope.nombreZona, fechaInicio: $scope.fechaInicio, fechaFinal:$scope.fechaFinal});

        console.log($scope.zonas[0].nombre);
        
        $scope.id="";
        $scope.nombreZona="";
	$scope.fechaInicio="";
	$scope.fechaFinal="";
        };

        $scope.borrar = function()
        {
            svc.borrarZona($scope.zonaSeleccionado);
            $scope.zonas=  svc.darZonas();
        };

        $scope.guardarTodosLasZonas = function()
        {
            var zonaActual = svc.darZonaActualId();
            svc.agregarZonaPorId(zonaActual, $scope.zonas);
        }

}]);

})(window.angular);