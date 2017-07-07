$(document).ready(function(){
 alert("hello");
}); 

function InitializeEvents(){
    $("#myTable > tbody > tr").css("background","#70B83C");
    $("#myTable > tbody > tr").click(
    function(){
        $("#myTable > tbody > tr").css("background","#3C5DB8");
        $(this).css("background","#B83C3C");
      //  b=$(this).find("input").val();
      //  $('#Id').val(b);
         alert("TR");
       //  GB_showCenter('Google', "http://google.com/");

    });
}
