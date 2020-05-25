//Found at: https://stackoverflow.com/questions/11735856/draw-grid-table-on-canvas-html5

$(document).ready(function(){
    var canvas = document.getElementById("canvasMap");
    var w3rcontext = canvas.getContext('2d');
    // Box width
    var bw;
    // Box height
    var bh;
    // Padding
    var p = 10;
    
    function drawBoard(){
        bw = canvas.clientWidth - 40;
        bh = canvas.clientHeight - 40;
        for (var x = 0; x <= bw; x += 40) {
            w3rcontext.moveTo(x + p, p);
            w3rcontext.lineTo(x + p, bh + p);
        }
    
        for (var x = 0; x <= bh; x += 40) {
            w3rcontext.moveTo(p, x + p);
            w3rcontext.lineTo(bw + p, x + p);
        }
        w3rcontext.strokeStyle = "black";
        w3rcontext.stroke();
    }
    
    drawBoard();
    
    $("#canvasMap").mouseover(function(e){
        var x = e.offsetX;
        var y = e.offsetY;
    
        console.log(x + ", " + y);
    });

    $("#canvasMap").click(function(e){
        var x = e.offsetX - p;
        var y = e.offsetY - p;
        var squareHorizontal = Math.floor(x / 40);
        var squareVertical = Math.floor(y / 40);
        w3rcontext.fillRect(p + (squareHorizontal * 40), p + (squareVertical * 40), 40, 40);
        console.log("click");
    });

});





