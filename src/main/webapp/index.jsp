<!DOCTYPE html>
<html ng-app="weiboDemo">
<head>
	<meta charset="UTF-8">
	<title>Demo for weiboclient4j</title>
	<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.0.0-rc2/css/bootstrap.min.css">
	<style type="text/css">
		.top-buffer {margin-top: 20px;}
	</style>
	<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.0.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0-rc2/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/angular.js/1.1.5/angular.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/angular.js/1.1.5/angular-resource.min.js"></script>
	<script type="text/javascript" src="js/ui-bootstrap-0.6.0.min.js"></script>
	<script type="text/javascript" src="js/demo.js"></script>
</head>
<body>
<div class="container">
	<div class="page-header">
		<h1>Demo for weiboclient4j</h1>
	</div>
	<div class="row text-right" ng-controller="MenuCtrl">
		<div class="btn-group" ng-show="displayMenu">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				Demo <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#/main">Access Token</a></li>
				<li><a href="#/timeline">Home Timeline</a></li>
				<li class="divider"></li>
				<li><a href ng-click="logout()">Logout</a></li>
			</ul>
		</div>
		<a href class="btn btn-warning" ng-show="displayMenu" ng-click="getNewAccessToken()">Get New Access Token</a>
	</div>
	<div class="top-buffer" ng-view></div>
</div>
</body>
</html>
