var myVar = setInterval(myTimer, 1000);
function myTimer() {
    var d = new Date();
    document.getElementById("dt-hora").innerHTML = d.getDate() + '/' + (d.getMonth() + 1) + '/' + d.getFullYear() + ' ' + d
            .toLocaleTimeString();

    var tabela = localStorage.getItem('tbody');

    document.getElementById("tbody").innerHTML = tabela;
}
documento.myTimer();