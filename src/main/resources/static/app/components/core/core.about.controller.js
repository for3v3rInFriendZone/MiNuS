(function() {
	'use strict';

	angular
		.module('minus.core')
		.controller('AboutController', AboutController);

	AboutController.$inject = ['$state', 'Comment'];
	function AboutController($state, Comment) { 
		var acr = this;
		
		acr.checkComment = false;
		acr.sendComment = sendComment;

		function sendComment() {
			if(acr.form.$invalid) {
				acr.checkComment = true;
				return;
			}
			
			Comment.save(acr.message);
		}
	}
	
})();