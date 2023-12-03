$(document).ready(function () {
    $("#anexo").bind('change', handleFileSelect);
    $("#select-categoria").bind('change', changeSubCategoria);

    changeSubCategoria();
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

function changeSubCategoria() {
    var nomeCategoria = $('#select-categoria :selected').text();

    var $selectSubCategoria = $("#select-subcategoria");

    $selectSubCategoria.empty();

    var newoptions = [
        "Teste1",
        "Teste2"
    ];;

    switch(nomeCategoria) {
        case "Fauna":
            newoptions = [
                "Do transporte e comercialização de animais abatidos de forma ilegal.",
                "Pesca ilegal, predatória ou por meio de explosivos, ou substâncias que em contato com a água produzem efeito semelhante. Assim como, transportar ou comercializar espécies provenientes de tais atos.",
                "Caça ilegal ou predatória, de animais em extinção ou fora de época, bem como entrar em locais de conservação portando instrumentos próprios para a atividade.",
                "Ferir, praticar maus-tratos, abuso ou mutilação de qualquer animal silvestre.",
                "Experiências que possam causar dor e sofrimento aos animais.",
                "Emissão de efluentes, substâncias tóxicas ou outro meio proibido que possa provocar a morte ou extinção de espécies aquáticas."
            ];
            break;
        case "Flora":
            newoptions = [
                "Destruir ou danificar florestas de preservação permanente, independentemente do estágio de formação.",
                "Destruir ou danificar qualquer vegetação do Bioma Mata Atlântica.",
                "Cortar árvores em florestas de preservação permanente, sem a devida permissão.",
                "Fabricar, vender, transportar ou soltar balões que podem provocar incêndios.",
                "Destruir, danificar, lesar ou maltratar, por qualquer meio ou modo, plantas de ordenação de espaços públicos ou em propriedades privadas alheias."
            ];
            break;
        case "Poluição":
            newoptions = [
                "Causar poluição atmosférica ou híbrida.",
                "Dificultar ou impedir o uso público das praias.",
                "Realizar pesquisa, lavra ou extração de recursos minerais sem autorização legal.",
                "Produzir, processar, embalar, importar, exportar, comercializar, fornecer, transportar, armazenar, guardar, ter em depósito ou usar substância tóxica perigosa, ou nociva à saúde humana ou ao meio ambiente, em desacordo com as exigências estabelecidas.",
                "Construir, reformar, ampliar, instalar ou fazer funcionar, estabelecimentos, obras ou serviços potencialmente poluidores, sem licença.",
                "Disseminar doença ou praga que cause dano à agricultura, pecuária, fauna, flora e aos ecossistemas."
            ];
            break;
        case "Ornamento Urbano e Patrimônio Cultural":
            newoptions = [
                "Pixação em áreas urbanas.",
                "Alterar o aspecto ou estrutura bem como promover a construção em solo de locais protegidos em razão do seu valor paisagístico, ecológico, turístico, artístico, histórico, cultural, religioso, arqueológico, etnográfico ou monumental, sem autorização prévia da autoridade competente.",
                "Mineração, Ruído e Vibração Industrial."
            ];
            break;
        case "Administração Ambiente":
            newoptions = [
                "Práticas como afirmações falsas ou enganosas.",
                "Concessões de licenças, autorizações ou permissões emitidas pelos funcionários, porém em desacordo com as normas ambientais."
            ];
            break;
    }

    newoptions.forEach(element => {
        $selectSubCategoria.append($("<option></option>").attr("value", element).text(element));
    });
}