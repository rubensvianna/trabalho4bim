angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

      .state('menu.inicio', {
    url: '/page1',
    views: {
      'side-menu21': {
        templateUrl: 'templates/inicio.html',
        controller: 'inicioCtrl'
      }
    }
  })

  .state('menu.listaDeUsuarios', {
    url: '/page2',
    views: {
      'side-menu21': {
        templateUrl: 'templates/listaDeUsuarios.html',
        controller: 'listaDeUsuariosCtrl'
      }
    }
  })

  .state('menu.novoUsuario', {
    url: '/page3',
    views: {
      'side-menu21': {
        templateUrl: 'templates/novoUsuario.html',
        controller: 'novoUsuarioCtrl'
      }
    }
  })

  .state('menu', {
    url: '/side-menu21',
    templateUrl: 'templates/menu.html',
    controller: 'menuCtrl'
  })

$urlRouterProvider.otherwise('/side-menu21/page1')

});
