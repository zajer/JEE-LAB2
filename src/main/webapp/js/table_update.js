/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
    console.log( "ready!" );
    var api_uri = "http://localhost:8080/I6I1S1/api-feeder"
    var jqxhr = $.getJSON( api_uri, function() {
  console.log( "success" );
    })
  .done(function(data) {
      console.log(data);
      $.each( data, function( key, value ) {
          console.log(value);
          var row = $("<tr>").appendTo("#content");
          $("<td>").append(value.name).appendTo(row);
          $("<td>").append(value.itemName).appendTo(row);
          $("<td>").append(value.itemPrice).appendTo(row);
        });
  });
});


