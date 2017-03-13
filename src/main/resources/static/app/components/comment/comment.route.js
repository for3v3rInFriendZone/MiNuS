(function() {
	"use strict";

	angular
		.module('minus.comment')
		.config(config);

	config.$inject = ['$stateProvider', '$urlRouterProvider'];
	function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('/home');

		$stateProvider
			.state('main.comment', {
				url: '/comments',
				views: {
					'content@': {
						templateUrl: 'app/components/comment/comment.html'
					}
				}
			});
		
		getComments.$inject = ['Comment'];
		function getComments(Comment) {
			return Comment.findAll();
		}
	}
})();