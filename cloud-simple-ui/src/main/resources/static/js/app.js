angular.module('users', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'user-page.html',
        controller: 'userCtr'
    }).when('/userFirst',{
    	templateUrl: 'user-single-page.html',
        controller: 'userSingleCtr'
    })
}).controller('userCtr', function ($scope, $http) {
    $http.get('users').success(function (data) {
        alert("data="+data+"");
        $scope.userList = data;
    });
}).controller('userSingleCtr', function ($scope, $http) {
    $http.get('userFirst').success(function (data) {
        alert("data="+data+"");
        $scope.user = data;
    });
});
