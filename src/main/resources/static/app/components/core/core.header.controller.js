(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('NavbarController', NavbarController);

	NavbarController.$inject = ['$state', 'localStorageService'];
	function NavbarController($state, localStorageService) { 
		var nbc = this;
		
		nbc.isActive = isActive;
		nbc.toHome = toHome;
		nbc.user = localStorageService.cookie.get('user');
		nbc.logout = logout;
		
		function isActive(state) {
			return $state.current.name.indexOf(state) != -1;
		};
		
		function toHome() {
			$state.go("main.home");
		};
		
		function logout(){
			localStorageService.cookie.clearAll();
			$state.go('main.login');
		}
	}
	
})();