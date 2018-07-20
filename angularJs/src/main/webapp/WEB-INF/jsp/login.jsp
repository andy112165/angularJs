<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />

<title>试验</title>

<script type="text/javascript" src="http://s.zys.me/js/jq/jquery.js"></script>
<script type="text/javascript" src="http://s.zys.me/js/ng/angular.js"></script>

</head>
<body>
  <div ng-controller="BoxCtrl">
    <div style="width: 100px; height: 100px; background-color: red;"
         ng-click="click()"></div>
    <p>{{ w }} x {{ h }}</p>
    <p>W: <input type="text" ng-model="w" /></p>
    <p>H: <input type="text" ng-model="h" /></p>
  </div>


<script type="text/javascript" charset="utf-8">

  angular.module('app', [], angular.noop)
  .controller('BoxCtrl', function($scope, $element){
      //$element 就是一个 jQuery 对象
      var e = $element.children().eq(0);
      $scope.w = e.width();
      $scope.h = e.height();

      $scope.click = function(){
        $scope.w = parseInt($scope.w) + 10;
        $scope.h = parseInt($scope.h) + 10;
      }

      $scope.$watch('w',
        function(to, from){
          e.width(to);
        }
      );

      $scope.$watch('h',
        function(to, from){
          e.height(to);
        }
      );
  });


  angular.bootstrap(document.documentElement, ['app']);
</script>
</body>
</html>
