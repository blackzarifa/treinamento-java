// GET "estudantes"
axios.get('http://localhost:8080/treinamento-java/rest/estudantes')
    .then(response => {
        const estudantes = response.data;

        const table = document.getElementById('estudantes-table');
        estudantes.forEach(estudante => {
            // Convert date to a more readable format
            let dataAniversario = moment(estudante.aniversario).format('DD/MM/YYYY');

            // Create object row
            let row = document.createElement('tr');
            row.innerHTML = '<td>' + estudante.id + '</td>' +
                            '<td>' + estudante.nome + '</td>' +
                            '<td>' + estudante.matricula + '</td>' +
                            '<td>' + dataAniversario + '</td>' +
                            '<td>' + estudante.FK_curso + '</td>';
            table.appendChild(row);
        });
    })
    .catch(e => console.log(e));