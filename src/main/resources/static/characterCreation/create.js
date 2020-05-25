$(document).ready(function(){
    document.getElementById("race").addEventListener("change", updateSubRace);
});

function updateSubRace(){
    var sub = document.getElementById("subrace");
    var e = document.getElementById("race");
    var selected = e.options[e.selectedIndex].value;
    
    switch(selected){
        case null:
            $("#subrace").empty();
            sub.setAttribute("disabled", "disabled");
            break;
        case "Dwarf":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["Hill Dwarf", "Mountain Dwarf"];
            addItemsToSelect("subrace", subs);
            break;
        case "Elf":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["High Elf", "Wood Elf", "Dark Elf"];
            addItemsToSelect("subrace", subs);
            break;
        case "Halfling":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["Lightfoot", "Stout"];
            addItemsToSelect("subrace", subs);
            break;
        case "Gnome":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["Forest Gnome", "Rock Gnome"];
            addItemsToSelect("subrace", subs);
            break;
        case "Tiefling":
        case "Half-Orc":
        case "Half-Elf":
        case "Dragonborn":
        case "Human":
        default:
            $("#subrace").empty();
            if(!sub.hasAttribute("disabled")){
                sub.setAttribute("disabled", "disabled");
            }
    }
}

function addItemsToSelect(id, arr){

    $("#" + id).empty();
    var select = document.getElementById(id);
    select.options[0] = new Option("--Select An Option--", null);
    for(i in arr){
        select.options[select.options.length] = new Option(arr[i], arr[i]);
    }
}