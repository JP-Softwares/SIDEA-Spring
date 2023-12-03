$(document).ready(function () {
    $("#anexo").bind('change', handleFileSelect);
});

function handleFileSelect(evt) {
    var filename;
    try {
        var files = evt.target.files;
        filename = files[0].name;
        $('#anexo-name').text(filename);
    } catch (error) {
        $('#anexo-name').text('Escolha um arquivo');
    }
}