(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$scope', '$state', 'localStorageService', 'users', 'User'];
	function LoginController($scope, $state, localStorageService, users, User) {  
		var lgc = this;
		
		lgc.checkLogin = false;
		lgc.usernameExists = false;
		lgc.users = users;
		lgc.submitLoginForm = submitLoginForm;
		lgc.submitSignUpForm = submitSignUpForm;
		
		function submitLoginForm() {
			if(lgc.form.$invalid) {
				lgc.checkLogin = true;
				return;
			}
			
			User.login(lgc.user).then(function(data) {
				if(data == true) {
					$state.go("main.home");
				} else {
					lgc.checkLogin = true;
					return;
				}
			})
		}
		
		function submitSignUpForm() {
			if(lgc.form.$invalid) {
				lgc.checkLogin = true;
				return;
			}
	
			User.checkUsernameUniqueness(lgc.user).then(function(data) {
				if(data == true) {
					lgc.usernameExists = true;
					return;
				} else {
					User.save(lgc.user, "main.confirm");
				}
			});
			
			
		}
		
	}
	
})();