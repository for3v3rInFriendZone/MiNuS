(function() {
	'use strict';

	angular
		.module('minus.user')
		.controller('AccountConfirmedController', AccountConfirmedController);

	AccountConfirmedController.$inject = ['$state', 'localStorageService', 'User', '$stateParams'];
	function AccountConfirmedController( $state, localStorageService, User, $stateParams) {  
		var acc = this;
		
		if($stateParams.username == null || $stateParams.username == undefined) {
			alert('This account is not valid.');
			$state.go('main.home');
			return;
		}
		
		acc.user = localStorageService.cookie.get('userCheck');
		
		activateUserAccount();
		
		function activateUserAccount() {
			User.activateAccount($stateParams.username).then(function(data) {
				if(data == null || data == undefined) {
					alert('This account is not valid.');
					$state.go('main.home');
					return;
				}
			});
			return;
		}
		
	}
	
})();