$(document).ready(function() {
    let fileName = "[[${anexo.nome_arquivo}]]";
    let file = new File("[[${anexo.conteudo}]]", fileName,{type:"[[${anexo.tipo_arquivo}]]"});
    let container = new DataTransfer(); 
    container.items.add(file);
    document.querySelector('#anexo').files = container.files;
});