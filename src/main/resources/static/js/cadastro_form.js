 document.getElementById("submitButton").addEventListener("click", function(event) {
  event.preventDefault();

  let form = document.getElementById("cadastroForm");
  let nome = form.elements.nome.value;
  let valor = form.elements.valor.value.replace('R$ ', '');
  let dataPagamento = form.elements.dataPagamento.value;

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
        window.location.replace("http://localhost:8080/");
    }
  )
  .catch(error => console.error(error));
});