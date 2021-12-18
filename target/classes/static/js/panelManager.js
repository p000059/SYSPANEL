let lstPerson = [];

function loadAllPerson() {

    const xhttp = new XMLHttpRequest();

    xhttp.open("GET", `/panel/`);
    xhttp.send();

    xhttp.onload = function() {

        lstPerson = JSON.parse(this.responseText);
        let tabela = "";
        let person = "";

        for (let i in lstPerson) {
                person = status(lstPerson[i].status);
                tabela += '<tr onclick="activate(' + i + ')">' 
                        + '<td>' + lstPerson[i].namePerson + '</td>'
                        + '<td style="background-color: '+person.cor +';">'
                        + person.label 
                        + '<td>'+lstPerson[i].local + '</td>' 
                        + '<td>' + lstPerson[i].expectedStart + '</td>' 
                        + '<td>' + lstPerson[i].startSurgery + '</td>' 
                        + '<td>' + lstPerson[i].endSurgery + '</td>' 
                        + '<td>' + lstPerson[i].expectedOutput + '</td>' + '</tr>';
        }

        document.getElementById("tbody").innerHTML = tabela;
    }
}

function save() {

        const xhttp = new XMLHttpRequest();
        let id = document.getElementById('id').value;
        let namePerson = document.getElementById('namePerson').value;

        if (namePerson == '') {
                alert('O Nome do Paciente é obrigatório.');
                return false;
        }

        var status = document.getElementById("status").value;
        var local = document.getElementById("local").value;
        let expectedStart = document.getElementById('expectedStart').value;
        let startSurgery = document.getElementById('startSurgery').value;
        let endSurgery = document.getElementById('endSurgery').value;
        let expectedOutput = document.getElementById('expectedOutput').value;
        let urlPost = `/panel/?namePerson=${namePerson}&status=${status}&local=${local}&expectedStart=${expectedStart}&startSurgery=${startSurgery}&endSurgery=${endSurgery}&expectedOutput=${expectedOutput}`;
        let urlPut = `/panel/${id}?namePerson=${namePerson}&status=${status}&local=${local}&expectedStart=${expectedStart}&startSurgery=${startSurgery}&endSurgery=${endSurgery}&expectedOutput=${expectedOutput}`;

        if (local != '') {
                local = '(' + local + ')';
        }

        let save = confirm("Deseja Salvar as alterações?");

        if (save) {

            if(id > 0){
                xhttp.open("PUT", urlPut);
            }
            else{
                xhttp.open("POST", urlPost);
            }
        }

        xhttp.send();

        xhttp.onload = function() {

            alert(this.responseText);
            loadAllPerson();
        }
        clearP();
}

function activate(id) {

    let person = lstPerson[id];

    document.getElementById('id').value = person.idPerson;
    document.getElementById('namePerson').value = person.namePerson;
    document.getElementById('status').value = person.status;
    document.getElementById('local').value = person.local.replace("(","").replace(")","");
    document.getElementById('expectedStart').value = person.expectedStart;
    document.getElementById('startSurgery').value = person.startSurgery;
    document.getElementById('endSurgery').value = person.endSurgery;
    document.getElementById('expectedOutput').value = person.expectedOutput;

}

function status(status) {
        switch (status) {
        case 'operatorio':
                return {
                        label : 'Pré-Operatório',
                        cor : '#fbd972'
                };
        case 'sala-cirurgica':
                return {
                        label : 'Em sala cirúrgica',
                        cor : '#fd5766'
                };
        case 'recuperacao':
                return {
                        label : 'Em recuperação',
                        cor : '#89e89f'
                };
        case 'transferido':
                return {
                        label : 'Transferído',
                        cor : '#b8daff'
                };
        }
}


function clearP() {
        document.getElementById("id").value = '';
        document.getElementById('form-paciente').reset();
}

function deleteP() {

    const xhttp = new XMLHttpRequest();

    let id = document.getElementById('id').value;
    let urlDELETE = `/panel/${id}`;

    if (id != '') {

        let save = confirm("Tem certeza que quer apagar esse registro?");

        if (save) {

            xhttp.open("DELETE", urlDELETE);
            clearP();
        }
    }

    xhttp.send();

    xhttp.onload = function() {

        alert(this.responseText);
        loadAllPerson();
        clearP();
    }
}
