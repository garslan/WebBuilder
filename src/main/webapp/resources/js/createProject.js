function inputValid(){
    var name = document.getElementById("name").value;
    var description = document.getElementById("description").value;

    if (name.length <= 0){
        return alert("Input project name, please!");
    }
}

function test(){
    alert("test");
}