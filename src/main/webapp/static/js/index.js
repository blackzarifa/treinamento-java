const form = document.querySelector('form');


// Get all from 'curso'
axios.get('http://localhost:8080/treinamento-java/rest/cursos/getall')
    .then(response => {
        const cursos = response.data;

        const select = document.getElementById('curso-select');
        cursos.forEach(curso => {
            let option = document.createElement('option');
            option.value = curso.id;
            option.text = curso.nome;

            select.appendChild(option);
        })
    })
    .catch(e => console.log(e));


// GET all from 'estudante'
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
            // Add clickable function to row
            row.addEventListener('click', () => {
                // Get row data
                //const rowData = row.getElementsByTagName('td');
                const id = estudante.id;
                const nome = estudante.nome;
                const matricula = estudante.matricula;
                const aniversario = moment(estudante.aniversario).format('YYYY-MM-DD');
                const curso = estudante.curso;

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

// POST new values to 'estudante'
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