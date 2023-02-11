 document.getElementById("submitButton").addEventListener("click", function(event) {
  event.preventDefault();

  var form = document.getElementById("cadastroForm");
  var nome = form.elements.nome.value;
  var valor = form.elements.valor.value.replace('R$ ', '');
  var dataPagamento = form.elements.dataPagamento.value;

  fetch('http://localhost:8080/novaDespesa', {
    method: 'POST',
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
        window.location.replace("http://localhost:8080/todas_despesas");
    }
  )
  .catch(error => console.error(error));
});