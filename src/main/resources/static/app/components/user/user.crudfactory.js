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
		
		userService.activateAccount = function(username) {
			return Restangular.one('user/activateAccount', username).get();		
		}
		
		userService.login = function(user) {
			return Restangular.all('user/login').post(user);
		
		}
		
		userService.checkUsernameUniqueness = function(user) {
			return Restangular.all('user/checkUsername').post(user);
		
		}
		
		userService.sendMail = function(user) {
			return Restangular.all('user/mail').post(user);
		
		}	
		
		return userService;
	}
})();