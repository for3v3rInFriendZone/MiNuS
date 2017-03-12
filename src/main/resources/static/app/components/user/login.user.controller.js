(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$state', 'localStorageService', 'users', 'User'];
	function LoginController($state, localStorageService, users, User) {  
		var lgc = this;
		
		lgc.users = users;
		lgc.submitLoginForm = submitLoginForm;
		lgc.submitSignUpForm = submitSignUpForm;
		
		function submitLoginForm() {
			if(lgc.form.$invalid) {
				return;
			}
			
			User.login(lgc.user).then(function(data) {
				var aaa = data;
			})
			
		}
		
		function submitSignUpForm() {
			if(lgc.form.$invalid) {
				return;
			}
			
			User.save(lgc.user, "main.home");
		}
		
	}
	
})();