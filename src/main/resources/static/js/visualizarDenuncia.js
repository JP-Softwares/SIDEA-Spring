$(document).ready(function () {
    $('#select-status').bind('change', statusChange);
});

function statusChange () {
    var status = $('#select-status :selected').text();

    $('#textarea-parecer-tecnico').prop('required', status == "Finalizada");
}