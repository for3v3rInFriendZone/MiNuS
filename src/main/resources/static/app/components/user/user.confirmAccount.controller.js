(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('ConfirmAccountController', ConfirmAccountController);

	ConfirmAccountController.$inject = ['$state', 'localStorageService', 'User'];
	function ConfirmAccountController( $state, localStorageService, User) {  
		var cac = this;
		
		sendConfirmationMail();
		
		function sendConfirmationMail() {
			User.sendMail(localStorageService.cookie.get('user'));
			return;
		}
		
	}
	
})();