// Modal message functions
function showModal(title, message) {
    var overlay = document.querySelector('.modal-overlay');
    var box = document.querySelector('.modal-box');
    if (overlay && box) {
        box.querySelector('.modal-title').textContent = title;
        box.querySelector('.modal-body').textContent = message;
        overlay.style.display = 'block';
        box.style.display = 'block';
    } else {
        alert(message);
    }
}

function closeModal() {
    var overlay = document.querySelector('.modal-overlay');
    var box = document.querySelector('.modal-box');
    if (overlay) overlay.style.display = 'none';
    if (box) box.style.display = 'none';
}
