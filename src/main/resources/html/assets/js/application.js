 var readItApp = angular.module('readItApp', []);


 readItApp.controller('FeedAddCtrl', function($scope, $rootScope) {

     $scope.submit = function() {
         if ($scope.feedUrl)
            $rootScope.feeds.push({'name': $scope.feedUrl, 'numberOfNew':0});
     };

 });

 readItApp.controller('FeedDeleteCtrl', function($scope, $rootScope) {

     $scope.submit = function() {
         $rootScope.feeds.splice($rootScope.feeds.indexOf($scope.feedToDelete), 1); //TODO prefill dropdown
                                                                                    // TODO delete somehow from dropdown
     };

 });


 readItApp.controller('FeedCtrl', function($rootScope){ // TODO change later to the scope and store value from backend
    $rootScope.feeds = [
        {'name': 'levels.io',
            'numberOfNew': '1'},
        {'name': 'hacker.news',
            'numberOfNew': '14'},
        {'name': 'delfi.lt',
            'numberOfNew': '23'},
        {'name': '15min.lt',
            'numberOfNew': '17'},
        {'name': 'blog.codinghorror.com',
            'numberOfNew': '2'},
        {'name': 'dzone.com',
            'numberOfNew': '9'},
        {'name': 'bernardinai.lt',
            'numberOfNew': '12'},
        {'name': 'wired.com',
            'numberOfNew': '54'},
        {'name': 'levels.io',
            'numberOfNew': '1'},
        {'name': 'hacker.news',
            'numberOfNew': '14'},
        {'name': 'delfi.lt',
            'numberOfNew': '23'},
        {'name': '15min.lt',
            'numberOfNew': '17'},
        {'name': 'blog.codinghorror.com',
            'numberOfNew': '2'},
        {'name': 'dzone.com',
            'numberOfNew': '9'},
        {'name': 'bernardinai.lt',
            'numberOfNew': '12'},
        {'name': 'wired.com',
            'numberOfNew': '54'},
        {'name': 'dzone.com',
            'numberOfNew': '9'},
        {'name': 'bernardinai.lt',
            'numberOfNew': '12'},
        {'name': 'wired.com',
            'numberOfNew': '54'},
        {'name': 'levels.io',
            'numberOfNew': '1'},
        {'name': 'hacker.news',
            'numberOfNew': '14'},
        {'name': 'delfi.lt',
            'numberOfNew': '23'},
        {'name': '15min.lt',
            'numberOfNew': '17'},
        {'name': 'blog.codinghorror.com',
            'numberOfNew': '2'},
        {'name': 'dzone.com',
            'numberOfNew': '9'},
        {'name': 'bernardinai.lt',
            'numberOfNew': '12'},
        {'name': 'wired.com',
            'numberOfNew': '54'}
    ]
 });

