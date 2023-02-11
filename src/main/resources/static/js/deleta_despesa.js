function deleta(id) {
    console.log(id);
    fetch('http://localhost:8080/despesa/' + id, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => response.json())
      .then(
        data =>  {
            console.log(data);
            window.location.replace("http://localhost:8080/todas_despesas");
        }
      )
      .catch(error => console.error(error));
}