// GET "estudantes"
axios.get('/rest/estudantes')
    .then(response => {
        const estudantes = response.data;

        const table = document.getElementById('estudantes-table');
        estudantes.forEach(estudante => {
            let row = document.createElement('tr');
            row.innerHTML = '<td>' + estudante.id + '</td>';
            table.appendChild(row);
        });
    })
    .catch(e => console.log(e));