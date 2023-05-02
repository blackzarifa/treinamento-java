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
            row.classList.add('row-hover');
            row.innerHTML = '<td>' + estudante.id + '</td>' +
                            '<td>' + estudante.nome + '</td>' +
                            '<td>' + estudante.matricula + '</td>' +
                            '<td>' + dataAniversario + '</td>' +
                            '<td>' + estudante.FK_curso + '</td>';
            // Make row clickable
            row.addEventListener('click', () => {
                // Get row data
                const rowData = row.getElementsByTagName('td');
                const id = rowData[0].textContent;
                const nome = rowData[1].textContent;
                const matricula = rowData[2].textContent;
                const aniversario = rowData[3].textContent;
                const curso = rowData[4].textContent;

                // Fill form with data
                document.getElementById('id').value = id;
                document.getElementById('nome').value = nome;
                document.getElementById('matricula').value = matricula;
                document.getElementById('aniversario').value = aniversario;
                document.getElementById('FK_curso').value = curso;
            });

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