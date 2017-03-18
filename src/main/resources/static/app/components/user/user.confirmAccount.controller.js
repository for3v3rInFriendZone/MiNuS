(function() {
	'use strict';

	angular
		.module('minus.user')
		.controller('ConfirmAccountController', ConfirmAccountController);

	ConfirmAccountController.$inject = ['$state', 'localStorageService', 'User'];
	function ConfirmAccountController( $state, localStorageService, User) {  
		var cac = this;
		
		sendConfirmationMail();
		
		function sendConfirmationMail() {
			User.sendMail(localStorageService.cookie.get('userCheck'));
			return;
		}
		
	}
	
})();