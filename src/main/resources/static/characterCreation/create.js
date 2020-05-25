$(document).ready(function(){
    document.getElementById("race").addEventListener("change", updateSubRace);
});

function updateSubRace(){
    var sub = document.getElementById("subrace");
    var e = document.getElementById("race");
    var selected = e.options[e.selectedIndex].value;
    
    switch(selected){
        case "None":
            $("#subrace").empty();
            sub.setAttribute("disabled", "disabled");
            break;
        case "Dwarf":
            var subs = ["Hill Dwarf", "Mountain Dwarf"];
            addItemsToSelect("subrace", subs);
            break;
        default:
            $("#subrace").empty();
            if(!sub.hasAttribute("disabled")){
                sub.setAttribute("disabled", "disabled");
            }
    }
}

function addItemsToSelect(id, arr){
    if(sub.hasAttribute("disabled")){
        sub.removeAttribute("disabled");
    }

    $("#" + id).empty();
    var select = document.getElementById(id);
    for(i in arr){
        select.options[select.options.length] = new Option(arr[i], arr[i]);
    }
}