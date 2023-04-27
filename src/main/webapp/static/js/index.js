// GET "estudantes"
axios.get('http://localhost:8080/treinamento-java/rest/estudantes')
    .then(response => {
        const estudantes = response.data;

        const table = document.getElementById('estudantes-table');
        estudantes.forEach(estudante => {
            let row = document.createElement('tr');
            row.innerHTML = '<td>' + estudante.id + '</td>' +
                            '<td>' + estudante.nome + '</td>' +
                            '<td>' + estudante.matricula + '</td>' +
                            '<td>' + estudante.aniversario + '</td>' +
                            '<td>' + estudante.FK_curso + '</td>';
            table.appendChild(row);
        });
    })
    .catch(e => console.log(e));