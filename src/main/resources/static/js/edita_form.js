function editarModal(despesa) {
//    document.getElementById("nome").focus();
    document.getElementById("modalId").innerHTML = despesa.id;
    document.getElementById("nomeModal").value = despesa.nome;
    document.getElementById("valorModal").value = 'R$ ' + despesa.valor;
    document.getElementById("dataPagamentoModal").value = despesa.dataPagamento;
    console.log(despesa);
}

function salvaEdicao() {
    let form = document.getElementById("edita_form");
    let id = document.getElementById("modalId").innerHTML;
    let nome = form.elements.nomeModal.value;
    let valor = form.elements.valorModal.value.replace('R$ ', '');
    let dataPagamento = form.elements.dataPagamentoModal.value;

    console.log("----- DADOS DO editaForm ----");
    console.log(id, nome, valor, dataPagamento);

    fetch('http://localhost:8080/despesa/' + id, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          nome: nome,
          valor: valor,
          dataPagamento: dataPagamento
        })
      })
      .then(response => response.json())
      .then(
        data =>  {
            console.log(data);
            window.location.replace("http://localhost:8080");
        }
      )
      .catch(error => console.error(error));

}