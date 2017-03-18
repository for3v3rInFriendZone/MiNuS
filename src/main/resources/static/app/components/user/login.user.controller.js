(function() {
	'use strict';

	angular
		.module('minus.user')
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$state', 'localStorageService', 'users', 'User'];
	function LoginController($state, localStorageService, users, User) {  
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
					User.findOne(lgc.user).then(function(result) {
						localStorageService.cookie.set('user', result, 1, false);
						localStorageService.cookie.remove('userCheck');
						$state.go("main.menu");
					});
				} else {
					lgc.checkLogin = true;
					return;
				}
			});
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
					localStorageService.cookie.set('userCheck', lgc.user, 1, false);
					User.save(lgc.user, "main.confirm");
				}
			});
			
			
		}
		
	}
	
})();