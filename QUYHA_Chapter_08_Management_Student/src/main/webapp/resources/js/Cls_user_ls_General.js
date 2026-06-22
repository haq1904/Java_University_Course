// User list general functions
function selectRow(radio) {
    var row = radio.parentNode.parentNode;
    var cells = row.getElementsByTagName('td');
    if (cells.length >= 5) {
        document.getElementById('id').value = cells[1].textContent;
        document.getElementById('firstName').value = cells[2].textContent;
        document.getElementById('lastName').value = cells[3].textContent;
        document.getElementById('mark').value = cells[4].textContent;
    }
}
