const form = document.querySelector('form');

// GET all from database
axios.get('http://localhost:8080/treinamento-java/rest/estudantes/getall')
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
                            '<td>' + estudante.fk_curso + '</td>';
            table.appendChild(row);
        });
    })
    .catch(e => console.log(e));

// POST new values
form.addEventListener('submit', (event) => {
    const formData = new FormData(event.target);
    const data = {};
    for (const [key, value] of formData.entries()) data[key] = value;
    data.FK_curso = parseInt(data.FK_curso);
    console.log(data);
    
    axios.post('http://localhost:8080/treinamento-java/rest/estudantes/add', JSON.stringify(data), {
		headers: {
            'Content-Type': 'application/json'
        }
	})
        .then(response => {
            console.log(response.data);
        })
        .catch(e => console.log(e));
});