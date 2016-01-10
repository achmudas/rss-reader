 var readItApp = angular.module('readItApp', [
     'ngRoute',
     'readItControllers'
 ]);


 readItApp.config(['$routeProvider',
     function($routeProvider) {
         $routeProvider.
             when('/', {
                 templateUrl: 'assets/templates/landing.html',
                 controller: 'LoginCtrl'
             }).
             when('/main', {
                 templateUrl: 'assets/templates/main.html',
                 controller: 'FeedCtrl'
             }).
             otherwise({
                 redirectTo: '/'
             });
     }]);
