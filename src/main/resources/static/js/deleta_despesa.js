function deleta() {
    let id = document.getElementById("deletarModalId").innerHTML;
    console.log(id);
    fetch('http://localhost:8081/despesa/' + id, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => response.json())
      .then(
        data =>  {
            console.log(data);
            window.location.replace("http://localhost:8081");
        }
      )
      .catch(error => console.error(error));
}

function deletarModal(despesa) {
//    document.getElementById("nome").focus();
    document.getElementById("deletarModalId").innerHTML = despesa.id;
    document.getElementById("nomeDeletarModal").value = despesa.nome;
    document.getElementById("valorDeletarModal").value = 'R$ ' + despesa.valor;
    document.getElementById("dataPagamentoDeletarModal").value = despesa.dataPagamento;
    console.log(despesa);
}