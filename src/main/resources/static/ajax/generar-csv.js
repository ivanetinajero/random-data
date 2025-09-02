$(function() {
  $('#form-csv').on('submit', function(e) {
    e.preventDefault();
    $('#resultado').hide();
    $('#loading').show();
    var cantidad = $('#cantidad').val();
    $.ajax({
      url: '/api/csv/personas',
      method: 'POST',
      data: { cantidad: cantidad },
      success: function(data) {
        $('#loading').hide();
        var html = '<div class="alert alert-success">Archivo generado correctamente.</div>';
        html += '<ul class="list-group mb-3">';
        html += '<li class="list-group-item"><b>Archivo:</b> ' + data.archivo + '</li>';
        html += '<li class="list-group-item"><b>Registros:</b> ' + data.totalRegistros + '</li>';
        html += '<li class="list-group-item"><b>Tamaño:</b> ' + (data.tamanoArchivoAmigable || data.tamanoArchivoBytes + ' B') + '</li>';
        html += '<li class="list-group-item"><b>Tiempo de generación:</b> ' + data.tiempoGeneracionMs + ' ms</li>';
        html += '</ul>';
        html += '<a class="btn btn-success w-100" href="/csv/' + data.archivo + '" download>Descargar CSV</a>';
        $('#resultado').html(html).show();
      },
      error: function(xhr) {
        $('#loading').hide();
        $('#resultado').html('<div class="alert alert-danger">Ocurrió un error al generar el archivo.</div>').show();
      }
    });
  });
});
