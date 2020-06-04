$(document).ready(function(){
    document.getElementById("race").addEventListener("change", updateSubRace);
    document.getElementById("generateAbilityScores").addEventListener("click", generateScores);
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
        case "DWARF":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["Hill Dwarf", "Mountain Dwarf"];
            var subValues = ["HILLDWARF", "MOUNTAINDWARF"];
            addItemsToSelect("subrace", subs, subValues);
            break;
        case "ELF":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["High Elf", "Wood Elf", "Dark Elf/Drow"];
            var subValues = ["HIGHELF", "WOODELF", "DROW"];
            addItemsToSelect("subrace", subs, subValues);
            break;
        case "HALFLING":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["Lightfoot", "Stout"];
            var subValues = ["LIGHTFOOT", "STOUT"];
            addItemsToSelect("subrace", subs, subValues);
            break;
        case "GNOME":
            if(sub.hasAttribute("disabled")){
                sub.removeAttribute("disabled");
            }
            var subs = ["Forest Gnome", "Rock Gnome"];
            var subValues = ["FORESTGNOME", "ROCKGNOME"];
            addItemsToSelect("subrace", subs, subValues);
            break;
        case "TIEFLING":
        case "HALFORC":
        case "HALFELF":
        case "DRAGONBORN":
        case "HUMAN":
        default:
            $("#subrace").empty();
            if(!sub.hasAttribute("disabled")){
                sub.setAttribute("disabled", "disabled");
            }
    }
}

function addItemsToSelect(id, arr, valueArr){

    $("#" + id).empty();
    var select = document.getElementById(id);
    select.options[0] = new Option("--Select An Option--", null);
    for(i in arr){
        select.options[select.options.length] = new Option(arr[i], valueArr[i]);
    }
}


function generateScores(){
    document.getElementById("generateAbilityScores").setAttribute("disabled", "disabled");
    arr = [];
    for(let i = 0; i < 6; ++i){
        arr.push(sumOfTopThreeRolls());
    }

    //activate all dropdowns
    document.getElementById("str").removeAttribute("disabled");
    document.getElementById("dex").removeAttribute("disabled");
    document.getElementById("consti").removeAttribute("disabled");
    document.getElementById("intell").removeAttribute("disabled");
    document.getElementById("wis").removeAttribute("disabled");
    document.getElementById("charisma").removeAttribute("disabled");

    addItemsToSelect("str", arr, arr);
    addItemsToSelect("dex", arr, arr);
    addItemsToSelect("consti", arr, arr);
    addItemsToSelect("intell", arr, arr);
    addItemsToSelect("wis", arr, arr);
    addItemsToSelect("charisma", arr, arr);


}

function sumOfTopThreeRolls(){
    var sum = 0;
    var min = 7;

    for(let i = 0; i < 4; ++i){
        let temp = Math.floor((Math.random() * 6) + 1);
        sum += temp;
        if(temp < min){
            min = temp;
        }
    }
    return sum - min;
}