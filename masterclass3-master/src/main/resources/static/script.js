/*sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent*/
function registro(){
    var elemento={
        name:$("#name").val(),
        description:$("#description").val(),
        price:$("#price").val()
    }


    var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
    $.ajax({

        dataType: 'json',
        data:dataToSend,
        url:"http://localhost:8080/api/Papeleria/save",
        type:'POST',
        contentType:'application/json',
        success:function(response) {
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });

}

function obtenerItems(){

    $.ajax({
        dataType: 'json',
        url:"http://localhost:8080/api/Papeleria/all",
        crossOrigin:true,
        type:'GET',
        success:function(response) {
            console.log(response);
            var misItems=response;

            for(i=0;i<misItems.length;i++){

                $("#miResultado").append("<tr>");
                $("#miResultado").append("<td>"+misItems[i].name+"</td>");
                $("#miResultado").append("<td>"+misItems[i].price+"</td>");
                $("#miResultado").append("<td>"+misItems[i].description+"</td>");
                $("#miResultado").append('<td><button onclick="borrar('+misItems[i].id+')">Borrar</button></td>');
                $("#miResultado").append('<td><button onclick="obtenerItemEspecifico('+misItems[i].id+')">Cargar</button></td>');
                $("#miResultado").append("</tr>");

            }

        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });

}


function borrar(idElemento){
    var elemento={
        id:idElemento
    };


    var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
    $.ajax({
        dataType:'json',
        data:dataToSend,
        url:"https://g533ded53dca5a3-bdretovivo.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/papeleria/papeleria",
        type:'DELETE',
        contentType:'application/json',
        success:function(response) {
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });
}


function obtenerItemEspecifico(idItem){
    $.ajax({
        dataType: 'json',
        url:"https://g533ded53dca5a3-bdretovivo.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/papeleria/papeleria/"+idItem,
        type:'GET',
        success:function(response) {
            console.log(response);
            var item=response.items[0];

            $("#miId").val(item.id);
            $("#name").val(item.name);
            $("#description").val(item.description);
            $("#price").val(item.price);



        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });

}

function actualizar(){
    var elemento={
        id:$("#miId").val(),
        name:$("#name").val(),
        description:$("#description").val(),
        price:$("#price").val()
    }


    var dataToSend=JSON.stringify(elemento);
//JSON= JavaScript Object Notation
    $.ajax({
        dataType: 'json',
        data:dataToSend,
        contentType:'application/json',
        url:"https://g533ded53dca5a3-bdretovivo.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/papeleria/papeleria",
        type:'PUT',

        success:function(response) {
            console.log(response);
        },

        error: function(jqXHR, textStatus, errorThrown) {

        }
    });

}


