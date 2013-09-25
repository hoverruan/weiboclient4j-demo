<!DOCTYPE html>
<html ng-app="weiboDemo">
<head>
	<title>Demo for weiboclient4j</title>
	<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.0.0-rc2/css/bootstrap.min.css">
	<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.0.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0-rc2/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/angular.js/1.1.5/angular.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/angular.js/1.1.5/angular-resource.min.js"></script>
	<script type="text/javascript" src="js/demo.js"></script>
</head>
<body>
<div class="container">
	<div class="page-header">
		<h1>Demo for weiboclient4j</h1>
	</div>
	<div class="text-right" ng-controller="MenuCtrl">
		<div class="btn-group" ng-show="displayMenu">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				Demo <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#/main">Access Token</a></li>
				<li class="divider"></li>
				<li><a href="#">Other</a></li>
			</ul>
		</div>
		<a href class="btn btn-warning" ng-show="displayMenu" ng-click="getNewAccessToken()">Get New Access Token</a>
	</div>
	<div ng-view></div>
</div>
</body>
</html>
