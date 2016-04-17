var readItControllers = angular.module('readItControllers', ['ui.bootstrap'])


readItControllers.controller('FeedAddCtrl', function($scope, $http, $uibModalInstance, $window) {

    $scope.feed = {name:"", url:""};

    $scope.add = function() {
        $http({
            method: 'POST',
            url: '/api/feed',
            headers: {
                'Auth-Token': $window.sessionStorage.token
            },
            data: $scope.feed
        }).then(function success(response) {
            if (response.status = 200) {
                $uibModalInstance.close($scope.feed);
            } else {
                $log.error("Failed to add new feed");
                $log.error(response.status);
                $log.error(response.statusText);
            }

        }, function error(response) {
            $log.error("Failed to add new feed");
            $log.error(response.status);
            $log.error(response.statusText);
        });
    };

    //$scope.add = function () {
    //    var foundItemIndex = -1;
    //    if ($scope.feedUrl) {
    //        $rootScope.feeds.forEach(function(feed, index) {
    //            if (feed.name == $scope.feedUrl) {
    //                foundItemIndex = index;
    //            }
    //        });
    //        if (foundItemIndex == -1) {
    //            $scope.errorMessage = null;
    //            $uibModalInstance.close($scope.feedUrl);
    //        } else {
    //            $scope.errorMessage = "This feed is already added";
    //        }
    //    }
    //};
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    }

});

readItControllers.controller('FeedDeleteCtrl', function($scope, $uibModalInstance) {

    $scope.deleteFeed = function () {
        $uibModalInstance.close($scope.feedToDelete);
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    }


});

readItControllers.controller('LandingCtrl', function ($scope, $rootScope, $uibModal) {
    $scope.signUp = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'signUpTemplate.html',
            controller: 'SignUpCtrl'
        });

        modalInstance.result.then(function () {
            console.info('Modal dismissed at: ' + new Date());
        });
    };
});

readItControllers.controller('SignUpCtrl', function ($scope, $uibModalInstance) {
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    }
});

readItControllers.controller('NavBarCtrl', function($scope, $rootScope, $uibModal) {
    $scope.add = function() {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'addFeedTemplate.html',
            controller: 'FeedAddCtrl'
        });

        modalInstance.result.then(function (selectedItem) {
            $rootScope.feeds.push({'name': selectedItem, 'numberOfNew': 0});
        }, function () {
            console.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.delete = function() {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'deleteFeedTemplate.html',
            controller: 'FeedDeleteCtrl'
        });
        modalInstance.result.then(function (selectedItem) {
            var foundItemIndex = -1;
            if (selectedItem)
                $rootScope.feeds.forEach(function(feed, index) {
                    if (feed.name == selectedItem) {
                        foundItemIndex = index;
                    }
                });
            if (foundItemIndex != -1) {
                $rootScope.feeds.splice(foundItemIndex, 1);
            }
        }, function () {
            console.info('Modal dismissed at: ' + new Date());
        });
    };

});


readItControllers.controller('FeedCtrl', function($rootScope){ // TODO change later to the scope and store value from backend
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

readItControllers.controller('LoginCtrl', function($scope, $http, $log, $location, $window) {

    $scope.user = {username:"", password:""};

    $scope.signIn = function() {
        $http({
            method: 'POST',
            url: '/api/user/signIn',
            data: $scope.user
        }).then(function success(response) {
            if (response.status = 200) {
                $window.sessionStorage.token = response.headers("Auth-Token");
                $location.path("/main");
            } else {
                $log.error("Failed to sign in");
                $log.error(response.status);
                $log.error(response.statusText);
            }

        }, function error(response) {
            $log.error("Failed to sign in");
            $log.error(response.status);
            $log.error(response.statusText);
        });
    };

});

readItControllers.controller('RegistrationCtrl', function($scope, $http, $log) {

    $scope.user = {email:"", username:"", password:"", repPassword:""};

    //$scope.signUp = function() {
    //    $http.post('/api/user/signUp', $scope.user).then(successCallback, errorCallback);
    //}

    $scope.signUp = function() {
        $http({
            method: 'POST',
            url: '/api/user/signUp',
            data: $scope.user
        }).then(function successCallback(response) {
            // TODO redirect to main page with some message
            $log.info("Success signing up");
        }, function errorCallback(response) {
            $log.error("Failed to sign up");
            // TODO redirect to main page with error message (error-label)
        });
    };

});