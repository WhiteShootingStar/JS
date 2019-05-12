function callback(resp){
$("#sum").value=(resp.sum);
 alert("Data Loaded: " + JSON.stringify(resp));
        $("#sum").html(resp.sum);
}

function doGet(){
$.get("/MyFirstWebSite/OMEGALUL?", {
  num1: $("#NUMBER1").val(),
  num2: $("#NUMBER2").val()
 
},callback,"json")}


$("#NUMBER1").onfocusout=doGet();
$("#NUMBER2").onfocusout=doGet();