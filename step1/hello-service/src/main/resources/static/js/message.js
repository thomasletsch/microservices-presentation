angular.module('showMessage', []).controller('home', function($http) {
	var self = this;
	$http.get('/message').then(function(response) {
		self.message = response.data;
	})
});
