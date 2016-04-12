/**
 * Created by fausto.junqueira on 01/02/2016.
 */

/**
 * Nos metodos Resolve, a terminação TO representa, Transport Object*/

(function(app){

app.config(function(lciCrudRouteProvider, lciCrudPageInfo){


  lciCrudRouteProvider.registrar('Cadastramento de Sistema', 'Sistema', null, '/sistema', 'sistemaAPI',lciCrudPageInfo,
    {
      controller: 'sistemaCtrl',
      templateUrl: '/view/template/view/sistema/filtro.html'
    }, {
      controller: 'sistemaAtualizarCtrl',
      templateUrl: '/view/template/view/sistema/detalhe.html'
    });

  lciCrudRouteProvider.registrar('Cadastramento de Aluno', 'Aluno', null, '/aluno', 'alunoAPI',lciCrudPageInfo,
    {
      controller: 'alunoFiltroCtrl',
      templateUrl: '/view/template/view/aluno/filtro.html'
    }, {
      controller: 'alunoDetalheCtrl',
      templateUrl: '/view/template/view/aluno/detalhe.html'
    },{
      controller: 'alunoInserirCtrl',
      templateUrl: '/view/template/view/aluno/inserir.html'
    });

  lciCrudRouteProvider.registrar('Cadastramento de Professor', 'Professor', null, '/professor', 'professorAPI',lciCrudPageInfo,
    {
      controller: 'professorFiltroCtrl',
      templateUrl: '/view/template/view/professor/filtro.html'
    }, {
      controller: 'professorDetalheCtrl',
      templateUrl: '/view/template/view/professor/detalhe.html'
    },{
      controller: 'professorInserirCtrl',
      templateUrl: '/view/template/view/professor/inserir.html'
    });

});

})(angular.module('gerencia'));
