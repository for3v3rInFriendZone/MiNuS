(function() {
	'use strict';

	angular
		.module('minus.user')
		.controller('UserMenuController', UserMenuController);

	UserMenuController.$inject = ['$state', 'localStorageService', 'User'];
	function UserMenuController($state, localStorageService, User) {  
		var umc = this;
		
		umc.user = localStorageService.cookie.get('user');
		umc.signout = signout;
		
		function signout() {
			localStorageService.cookie.clearAll();
			$state.go('main.home');
		}
	}
	
})();