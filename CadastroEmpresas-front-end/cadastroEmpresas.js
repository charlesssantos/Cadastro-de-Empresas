function preencherTabelaEmpresas(empresas) {
    var tabelaBody = document.querySelector('#empresasTable tbody');
    tabelaBody.innerHTML = '';
  
    empresas.forEach(function(empresa) {
      var newRow = tabelaBody.insertRow();
  
      var idCell = newRow.insertCell();
      idCell.textContent = empresa.id;
  
      var nomeCell = newRow.insertCell();
      nomeCell.textContent = empresa.nome;
  
      var enderecoCell = newRow.insertCell();
      enderecoCell.textContent = empresa.endereco;
  
      var acoesCell = newRow.insertCell();
      var detalhesBtn = document.createElement('button');
      detalhesBtn.textContent = 'Detalhes';
      detalhesBtn.addEventListener('click', function() {
        mostrarDetalhes(empresa.id);
      });
      acoesCell.appendChild(detalhesBtn);
  
      var editarBtn = document.createElement('button');
      editarBtn.textContent = 'Editar';
      editarBtn.addEventListener('click', function() {
        editarEmpresa(empresa.id);
      });
      acoesCell.appendChild(editarBtn);
  
      var apagarBtn = document.createElement('button');
      apagarBtn.textContent = 'Apagar';
      apagarBtn.addEventListener('click', function() {
        confirmarExclusao(empresa.id);
      });
      acoesCell.appendChild(apagarBtn);
    });
  }
  
  function mostrarDetalhes(id) {
  
    var modalDetalhes = document.querySelector('#modalDetalhes');
    modalDetalhes.style.display = 'block';
  }
  
  function editarEmpresa(id) {
  
    var modalEdicao = document.querySelector('#modalEdicao');
    modalEdicao.style.display = 'block';
  }
  
  function confirmarExclusao(id) {
    var modalExclusao = document.querySelector('#modalExclusao');
    modalExclusao.style.display = 'block';
  }
  
  function abrirFormulario() {
    var modalAdicao = document.querySelector('#modalAdicao');
    modalAdicao.style.display = 'block';
  }
  
  var adicionarEmpresaBtn = document.querySelector('#adicionarEmpresaBtn');
  adicionarEmpresaBtn.addEventListener('click', abrirFormulario);
  
  var empresas = [
    { id: 1, nome: 'Empresa 1', endereco: 'Endereço 1' },
    { id: 2, nome: 'Empresa 2', endereco: 'Endereço 2' },
    { id: 3, nome: 'Empresa 3', endereco: 'Endereço 3' }
  ];
  
  preencherTabelaEmpresas(empresas);
  