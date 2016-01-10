var readItControllers = angular.module('readItControllers', ['ui.bootstrap'])


readItControllers.controller('FeedAddCtrl', function($scope, $rootScope, $uibModalInstance) {
    $scope.add = function () {
        var foundItemIndex = -1;
        if ($scope.feedUrl) {
            $rootScope.feeds.forEach(function(feed, index) {
                if (feed.name == $scope.feedUrl) {
                    foundItemIndex = index;
                }
            });
            if (foundItemIndex == -1) {
                $scope.errorMessage = null;
                $uibModalInstance.close($scope.feedUrl);
            } else {
                $scope.errorMessage = "This feed is already added";
            }
        }
    };
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

readItControllers.controller('LoginCtrl', function($scope) {

});