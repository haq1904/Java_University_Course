// Form validation functions
function validateRequired(fieldId, fieldName) {
    var value = document.getElementById(fieldId).value.trim();
    if (value === '') {
        alert(fieldName + ' is required!');
        return false;
    }
    return true;
}

function validateNumber(fieldId, fieldName) {
    var value = document.getElementById(fieldId).value.trim();
    if (isNaN(value) || value === '') {
        alert(fieldName + ' must be a number!');
        return false;
    }
    return true;
}
