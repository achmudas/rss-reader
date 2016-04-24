 var readItApp = angular.module('readItApp', [
     'ngRoute',
     'readItControllers'
 ]);


 readItApp.config(['$routeProvider',
     function($routeProvider) {
         $routeProvider.
             when('/', {
                 templateUrl: 'assets/templates/landing.html'
             }).
             when('/main', {
                 templateUrl: 'assets/templates/main.html'
             }).
             otherwise({
                 redirectTo: '/'
             });
     }]);
