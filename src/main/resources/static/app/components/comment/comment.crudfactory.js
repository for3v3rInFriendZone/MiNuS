(function() {
	"use strict";

	angular
		.module('minus.comment')
		.factory('Comment', Comment);

	Comment.$inject = ['Restangular', '$state'];
	function Comment(Restangular, $state) {

		var commentService = {};
		
		commentService.save = function(user) {
			Restangular.all("comment").post(user).then(function(data) {
				alert('Your message has been sent.');
			});
		}
		
		commentService.findAll = function() {
			return Restangular.all("comment").getList();
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