// Main form
const form = document.querySelector('form');


// Clear form button
const clearFormBtn = document.getElementById('clear-form-btn');
clearFormBtn.addEventListener('click', () => form.reset());


// Make it so checkbox text changes when clicked
const presencialCheckbox = document.getElementById('presencial');
const presencialLabel = document.getElementById('presencial-label');
presencialCheckbox.addEventListener('change', (event) => {
    if (event.target.checked) 
        presencialLabel.textContent = 'Ensino Presencial';
    else
        presencialLabel.textContent = 'Ensino a Distância';
});


// Function to load table with all values
const loadTable = async () => {
    try {
        // GET all 'estudante' values
        const getEstudantes = await axios.get('http://localhost:8080/treinamento-java/rest/estudantes/getall');
        const estudantes = getEstudantes.data;

        // Get table tag and populate it
        const table = document.getElementById('estudantes-table');
        for (const estudante of estudantes) {
            // Convert date to a more readable format
            const dataAniversario = moment(estudante.aniversario).format('DD/MM/YYYY');

            // More reable format of 'presencial'
            let tipoDeEnsino;
            if (estudante.presencial)
                tipoDeEnsino = 'Presencial'
            else
                tipoDeEnsino = 'A Distância'

            // GET 'curso' values connected with current 'estudante'
            const getCursos = await axios.get(`http://localhost:8080/treinamento-java/rest/cursos/${estudante.FK_curso}`);
            const nomeCurso = getCursos.data.nome;


            // Create table row
            const row = document.createElement('tr');
            row.classList.add('row-hover');

            // Add row to the table
            row.innerHTML = '<td>' + estudante.id + '</td>' +
                            '<td>' + estudante.nome + '</td>' +
                            '<td>' + estudante.matricula + '</td>' +
                            '<td>' + dataAniversario + '</td>' +
                            '<td>' + nomeCurso + '</td>' +
                            '<td>' + estudante.semestre + '</td>' +
                            '<td>' + tipoDeEnsino + '</td>';
                        

            // Add clickable function to row
            row.addEventListener('click', () => {
                const id = estudante.id;
                const nome = estudante.nome;
                const matricula = estudante.matricula;
                const aniversario = moment(estudante.aniversario).format('YYYY-MM-DD');
                const curso = estudante.FK_curso;

                document.getElementById('id').value = id;
                document.getElementById('nome').value = nome;
                document.getElementById('matricula').value = matricula;
                document.getElementById('aniversario').value = aniversario;
                document.getElementById('curso-select').value = curso;
            });

            table.appendChild(row);
        }
    } catch (e) {
        console.log(e);
    }
}

// Function to load select options
const loadSelect = async () => {
    try {
        // GET all 'curso' values
        const getCursos = await axios.get('http://localhost:8080/treinamento-java/rest/cursos/getall');
        const cursos = getCursos.data;
		
        // Get select tag and populate it
        const select = document.getElementById('curso-select');
        for(const curso of cursos) {
            // Create option
            let option = document.createElement('option');
            option.value = curso.id;
            option.text = curso.nome;

            // Append option to select
            select.appendChild(option);
        }
    } catch (e) {
        console.log(e);
    }
}

loadTable();
loadSelect();


// POST new values to 'estudante' or PUT in existing values
form.addEventListener('submit', (event) => {
    event.preventDefault();

    // Get values from 'nome and 'matricula'
    const valueNome = document.getElementById('nome').value.trim();
    const valueMatricula = document.getElementById('matricula').value.trim();

    // Check if any of the 2 values are empty
    if (valueNome === '' || valueMatricula === '') {
        alert('Por favor, preencha os campos.');
    } else {
        // Get values from form
        const formData = new FormData(event.target);

        // Creat an object with the values
        const data = {};
        for (const [key, value] of formData.entries()) {
            // If ID is empty, ignore the field
            if (value === '' && key ==='id')
                continue; 
            data[key] = value;
        } 
        
        // Convert value from string to int
        //data.FK_curso = parseInt(data.FK_curso);

    
        // Give accurate value to 'presencial' property
        if (Object.hasOwn(data, 'presencial'))
            data['presencial'] = true;
        else
            data['presencial'] = false;
    

        // Check if there's an ID in the form, if so then update a value, if not create a new one
        if ('id' in data) {
            // PUT
            axios.put('http://localhost:8080/treinamento-java/rest/estudantes/update', JSON.stringify(data), {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    console.log(response.data);
                    window.location.reload();
                })
                .catch (e => console.log(e));
        } else {
            // POST
            axios.post('http://localhost:8080/treinamento-java/rest/estudantes/add', JSON.stringify(data), {
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    console.log(response.data);
                    window.location.reload();
                })
                .catch(e => console.log(e));
        }
    }
    
});


// DELETE from database
const deleteDataBtn = document.getElementById('delete-data-btn');
deleteDataBtn.addEventListener('click', () => {
    // Get ID in the form
    const id = document.getElementById('id').value;
    
    // DELETE
    axios.delete(`http://localhost:8080/treinamento-java/rest/estudantes/delete/${id}`)
        .then(response => {
            console.log(response.data);
            window.location.reload();
        })
        .catch(e => console.log(e));
});