(function() {
	"use strict";

	angular
		.module('minus.user')
		.factory('User', User);

	User.$inject = ['Restangular', '$state'];
	function User(Restangular, $state) {

		var userService = {};
		
		userService.save = function(user, path) {
			Restangular.all('user').post(user).then(function(data) {
				$state.go(path);
			});
		}
		
		userService.findAll = function() {
			return Restangular.all("user").getList();
		}
		
		userService.findOne = function() {
			
		}
		
		userService.delete = function() {
					
		}
		
		userService.deleteAll = function() {
			
		}
		
		userService.login = function(user) {
			return Restangular.all('user/login').post(user);
		
		}	
		
		return userService;
	}
})();