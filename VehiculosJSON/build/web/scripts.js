getVehiculos();

function getVehiculos(){
    $("#vehiculosTable").remove();
    $.getJSON('http://localhost:8080/VehiculosAPI/webresources/service/getVehiculos', {/*somedata*/}, function(json_data){

    //no need for parsejson
    //use the json_data object

    var table_obj = $('#vehiculosTable');
    $.each(json_data, function(index, item){
         var table_row = $('<tr>', {id: item.id});
         var table_cell0 = $('<td>', {html: item.id});
         var table_cell1 = $('<td>', {html: item.placa});
         var table_cell2 = $('<td>', {html: item.modelo});
         var table_cell3 = $('<td>', {html: item.color});
         var table_cell4 = $('<td>', {html: item.puertas});
         var table_cell5 = $('<a>', {href:"#ex1", rel:"modal:open", html:"editar", class: "btnSelect"});
         table_row.append(table_cell0);
         table_row.append(table_cell1);
         table_row.append(table_cell2);
         table_row.append(table_cell3);
         table_row.append(table_cell4);
         table_row.append(table_cell5);
         table_obj.append(table_row);
    })
  })
}

function confirmar(){
    if(confirm('¿Los datos ingresados son correctos?')){
        return true;
    }
    return false;
}


$(document).ready(function(){
    $("#vehiculosTable").on('click','.btnSelect',function(){
         var currentRow=$(this).closest("tr");
         var id=currentRow.find("td:eq(0)").text();
         var placa=currentRow.find("td:eq(1)").text();
         var modelo=currentRow.find("td:eq(2)").text();
         var color=currentRow.find("td:eq(3)").text();
         var puertas=currentRow.find("td:eq(4)").text();
         $("#editTitle").text("Editar Vehiculo " + placa);
         $("#editID").val(id);
         $("#editPlaca").val(placa);
         $("#editModelo").val(modelo);
         $("#editColor").val(color);
         $("#editPuertas").val(puertas);
    });
    
    document.querySelector('#editVehiculo').addEventListener('submit', (e) => {
        e.preventDefault();
        const data = Object.fromEntries(new FormData(e.target).entries());
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/VehiculosAPI/webresources/service/updateVehiculo',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                location.reload();
            }
        });
    });
    
    document.querySelector('#newVehiculo').addEventListener('submit', (e) => {
        e.preventDefault();
        const data = Object.fromEntries(new FormData(e.target).entries());
        $.ajax({
            type: 'post',
            url: 'http://localhost:8080/VehiculosAPI/webresources/service/setVehiculo',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                location.reload();
            }
        });
    });
});

