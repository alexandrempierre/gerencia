/**
 * Created by fausto.junqueira on 01/02/2016.
 */

/**
 * Nos metodos Resolve, a terminação TO representa, Transport Object*/

(function(app){

app.config(function(lciCrudRouteProvider, lciCrudPageInfo){


  lciCrudRouteProvider.registrar('Cadastramento de Aluno', 'Aluno', null, '/aluno', 'alunoAPI',lciCrudPageInfo,
    {
      controller: 'alunoFiltroCtrl',
      templateUrl: '/assets/view/template/view/aluno/filtro.html'
    }, {
      controller: 'alunoDetalheCtrl',
      templateUrl: '/assets/view/template/view/aluno/detalhe.html'
    },{
      controller: 'alunoInserirCtrl',
      templateUrl: '/assets/view/template/view/aluno/inserir.html'
    });

  lciCrudRouteProvider.registrar('Cadastramento de Professor', 'Professor', null, '/professor', 'teacherAPI',lciCrudPageInfo,
    {
      controller: 'professorFiltroCtrl',
      templateUrl: '/assets/view/template/view/professor/filtro.html'
    }, {
      controller: 'professorDetalheCtrl',
      templateUrl: '/assets/view/template/view/professor/detalhe.html'
    },{
      controller: 'professorInserirCtrl',
      templateUrl: '/assets/view/template/view/professor/inserir.html'
    });

  lciCrudRouteProvider.registrar('Cadastramento de Funcionário', 'Funcionário', null, '/employee', 'employeeAPI',lciCrudPageInfo,
    {
      controller: 'employeeFilterCtrl',
      templateUrl: '/assets/view/template/view/employee/filter.html'
    }, {
      controller: 'professorDetalheCtrl',
      templateUrl: '/assets/view/template/view/professor/detalhe.html'
    },{
      controller: 'professorInserirCtrl',
      templateUrl: '/assets/view/template/view/professor/inserir.html'
    });

});

})(angular.module('gerencia'));
