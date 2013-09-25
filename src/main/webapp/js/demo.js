var weiboDemoModule = angular.module('weiboDemo', [], function ($routeProvider) {
  $routeProvider.
    when('/', {controller: SettingCtrl, templateUrl: 'setting.html'}).
    when('/main', {controller: MainCtrl, templateUrl: 'main.html'}).
    otherwise({redirectTo: '/'});
});

var showMenuEvent = 'showMenu';
var hideMenuEvent = 'hideMenu';

function showMenu($scope) {
  $scope.$broadcast(showMenuEvent);
}

function hideMenu($scope) {
  $scope.$broadcast(hideMenuEvent);
}

function SettingCtrl($scope, $rootScope) {
  $scope.doInit = function () {
    hideMenu($rootScope);
  }
}

function MainCtrl($scope, $http, $rootScope) {
  $scope.doInit = function () {
    showMenu($rootScope);

    $http({
      method: 'GET',
      url: '/api/info'
    }).success(function (info) {
        $scope.accessToken = info['access_token'];

        var user = info['user'];
        $scope.uid = user['id'];
        $scope.screenName = user['screen_name'];
        $scope.profileImageUrl = user['profile_image_url'];
      });
  };
}

weiboDemoModule.controller('MenuCtrl', function ($scope, $location) {
  $scope.displayMenu = false;

  $scope.$on(hideMenuEvent, function () {
    $scope.displayMenu = false;
  });

  $scope.$on(showMenuEvent, function () {
    $scope.displayMenu = true;
  });

  $scope.getNewAccessToken = function () {
    hideMenu($scope);

    $location.path('/');
  };
});
