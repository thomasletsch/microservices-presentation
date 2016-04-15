angular.module('showMessage', []).controller('home', function($http, $log) {
	var self = this;
	$http.get('message').then(function(response) {
		self.message = response.data;
		$log.info("Message: " + self.message);
	})
});
