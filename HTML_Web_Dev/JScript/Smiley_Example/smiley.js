let button = document.getElementById("smiley");
button.addEventListener('click', function() {
    showSmiley();
});

function showSmiley(){
    let span = document.getElementById("output");
    span.innerHTML = "😭";
}