(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$state', 'localStorageService', 'users'];
	function LoginController($state, localStorageService, users) {  
		var lgc = this;
		
		lgc.users = users;
		lgc.submitForm = submitForm;
		
		
		function submitForm() {
			
		}
		
	}
	
})();