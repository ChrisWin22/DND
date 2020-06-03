//Some found from http://jsfiddle.net/Trufa/dmyTR/36/show/

$('#toggleSidebar').click(function() {
    if ($("#gameMap").hasClass("halfScreen")) {
        $('#toggleSidebar i').addClass('icon-chevron-left');
        $('#toggleSidebar i').removeClass('icon-chevron-right');

        //move canvas to middle
        $("#gameMap").removeClass("halfScreen");
        $("#gameMap").css({float: ""});
        $("#gameMap").css({display: "inline-block"});

        //hide sheet
        $("#playerSheet").css({display: "none"});
    } else {
        $('#toggleSidebar i').removeClass('icon-chevron-left');
        $('#toggleSidebar i').addClass('icon-chevron-right');
          //move canvas right
        $("#gameMap").addClass("halfScreen");
        $("#gameMap").css({float: "right"});
        $("#gameMap").css({display: ""});

        //show sheet
        $("#playerSheet").css({display: "inline"});
      
    }
  });

$("#showSheetBtn").click(function(){
    //move canvas right
    $("#gameMap").addClass("halfScreen");
    $("#gameMap").css({float: "right"});

    //show sheet
    $("#playerSheet").css({display: "inline"});
});

$("#hideSheetBtn").click(function(){
    //move canvas to middle
    $("#gameMap").removeClass("halfScreen");
    $("#gameMap").css({float: ""});

    //hide sheet
    $("#playerSheet").css({display: "none"});
})