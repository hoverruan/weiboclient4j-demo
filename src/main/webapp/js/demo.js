var weiboDemoModule = angular.module('weiboDemo', ['ui.bootstrap'], function ($routeProvider) {
  $routeProvider.
    when('/', {controller: SettingCtrl, templateUrl: 'setting.html'}).
    when('/main', {controller: MainCtrl, templateUrl: 'main.html'}).
    when('/timeline', {controller: TimelineCtrl, templateUrl: 'timeline.html'}).
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
  $scope.fetchBasicInfo = function () {
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

function TimelineCtrl($scope, $http, $rootScope) {
  $scope.pageSize = 20;

  $scope.fetchHomeTimeline = function () {
    showMenu($rootScope);

    $http({
      method: 'GET',
      url: '/api/timeline/home',
      params: {
        pageSize: $scope.pageSize
      }
    }).success(function (timeline) {
        $scope.totalNumber = timeline['total_number'];
        $scope.nextCursor = timeline['next_cursor'];
        $scope.statuses = timeline['statuses'];

        angular.forEach($scope.statuses, function (status) {
          var retweet = status['retweeted_status'];
          status.isRetweet = !!retweet;
        });
      });
  };

  $scope.fireSomething = function () {
    console.log('pageSize: ' + $scope.pageSize);
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
