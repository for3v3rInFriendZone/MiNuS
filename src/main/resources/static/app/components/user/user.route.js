(function() {
	"use strict";

	angular
		.module('minus.user')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];
	function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');

		$stateProvider
			.state('main.login', {
				url: '/login',
				views: {
					'content@': {
						resolve: {
							users: getUsers
						},
						templateUrl: 'app/components/user/login.user.html',
						controller: "LoginController",
						controllerAs: "lgc"
					}
				}
			})
			.state('main.signup', {
				url: '/signUp',
				views: {
					'content@': {
						resolve: {
							users: getUsers
						},
						templateUrl: 'app/components/user/user.signup.html',
						controller: "LoginController",
						controllerAs: "lgc"
					}
				}
			})
			.state('main.confirm', {
				url: '/confirm',
				views: {
					'content@': {
						templateUrl: 'app/components/user/user.confirm.html',
						controller: "ConfirmAccountController",
						controllerAs: "cac"
					}
				}
			});
		
		getUsers.$inject = ['User'];
		function getUsers(User) {
			return User.findAll();
		}
	}
})();