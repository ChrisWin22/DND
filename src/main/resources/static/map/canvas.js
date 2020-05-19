var canvas = document.getElementById("canvasMap");
var w3rcontext = canvas.getContext('2d');
// Box width
var bw = 400;
// Box height
var bh = 400;
// Padding
var p = 10;

function drawBoard(){
    for (var x = 0; x <= bw; x += 40) {
        w3rcontext.moveTo(0.5 + x + p, p);
        w3rcontext.lineTo(0.5 + x + p, bh + p);
    }

    for (var x = 0; x <= bh; x += 40) {
        w3rcontext.moveTo(p, 0.5 + x + p);
        w3rcontext.lineTo(bw + p, 0.5 + x + p);
    }
    w3rcontext.strokeStyle = "black";
    w3rcontext.stroke();
}

drawBoard();



