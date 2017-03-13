(function() {
	"use strict";

	angular
		.module('minus.comment')
		.factory('Comment', Comment);

	Comment.$inject = ['Restangular', '$state'];
	function Comment(Restangular, $state) {

		var commentService = {};
		
		commentService.save = function(user, path) {
			Restangular.all('user').post(user).then(function(data) {
				$state.go(path);
			});
		}
		
		commentService.findAll = function() {
			return Restangular.all("user").getList();
		}
		
		commentService.findOne = function() {
			
		}
		
		commentService.delete = function() {
					
		}
		
		commentService.deleteAll = function() {
			
		}
		
		return commentService;
	}
})();