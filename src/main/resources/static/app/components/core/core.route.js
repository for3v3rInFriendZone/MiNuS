(function() {
	"use strict";

	angular
		.module('minus.core')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];
	function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');

		$stateProvider
			.state('main', {
				abstract: true,
				views: {
					'header@': {
						templateUrl: 'app/components/core/header.core.html',
						controller: "NavbarController",
						controllerAs: "nbc"
					},
					'footer': {
						templateUrl: 'app/components/core/footer.core.html'
					}
				}
			})
			.state('main.home', {
				url: '/home',
				views: {
					'content@': {
						templateUrl: 'app/components/core/home.core.html'
					}
				}
			})
			.state('main.about', {
				url: '/aboutUs',
				views: {
					'content@': {
						templateUrl: 'app/components/core/about.html',
						controller: "AboutController",
						controllerAs: "acr"
					}
				}
			});
	}
})();