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
			
		}
		
		function submitSignUpForm() {
			if(lgc.form.$invalid) {
				return;
			}
			lgc.user.type = "simple";
			User.save(lgc.user, "main.home");
		}
		
	}
	
})();