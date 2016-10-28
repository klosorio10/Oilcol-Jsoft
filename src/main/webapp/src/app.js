
(function (ng){

    var mod = ng.module("mainApp",[
        "ui.router",
        "AppZona",
        "AppCampo",
        "AppPozo",
        "AppHotel"
    ]);


    mod.config(['$logProvider', function($logProvider){
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider','$urlRouterProvider', function($stateProvider,$urlRouterProvider) {
            $urlRouterProvider.otherwise("/oilcol");
            $stateProvider
                   
                     .state('pozo',{
                        url:'/pozo',
//                        controller: "",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/Pozo/nuevo.html"
                    })
                    .state('campo',{
                        url:'/campo',
//                        controller: "",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/Campo/nuevo.html"
                    })
                    .state('zonaGeografica',{
                        url:'/zonaGeografica',
//                        controller: "",
//                        controllerAs: "ctrl",
                        templateUrl:"src/modules/ZonaGeografica/nuevo.html"
                    })
                    ;
    }]);
})(window.angular);


