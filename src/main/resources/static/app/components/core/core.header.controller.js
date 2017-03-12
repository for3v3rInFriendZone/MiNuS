(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('NavbarController', NavbarController);

	NavbarController.$inject = ['$state'];
	function NavbarController($state) { 
		var nbc = this;
		
		nbc.isActive = isActive;
		nbc.toHome = toHome;
		
		function isActive(state) {
			return $state.current.name.indexOf(state) != -1;
		};
		
		function toHome() {
			$state.go("main.home");
		};
	}
	
})();