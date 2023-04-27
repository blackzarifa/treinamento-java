// GET "estudantes"
axios.get('http://localhost:8080/treinamento-java/rest/estudantes')
    .then(response => {
        const estudantes = response.data;

        const table = document.getElementById('estudantes-table');
        estudantes.forEach(estudante => {
            // Convert date to a readable format
            let date = new Date(estudante.aniversario);
            formattedDate = data.toLocaleDateString('en-GB');

            // Create object row
            let row = document.createElement('tr');
            row.innerHTML = '<td>' + estudante.id + '</td>' +
                            '<td>' + estudante.nome + '</td>' +
                            '<td>' + estudante.matricula + '</td>' +
                            '<td>' + formattedDate + '</td>' +
                            '<td>' + estudante.FK_curso + '</td>';
            table.appendChild(row);
        });
    })
    .catch(e => console.log(e));