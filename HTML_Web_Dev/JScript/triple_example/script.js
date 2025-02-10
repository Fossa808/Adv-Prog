let button = document.getElementById("multiply");
button.addEventListener('click', function() {
    triple();
});

function triple() {
    let wordBox = document.getElementById("word-box");
    let word = wordBox.value;
    let resultBox = document.getElementById("result-box");
    let result = '';
    for(let i = 0; i < 3; i++){
        result += word + ' ';
    }
    result = result.trim();
    resultBox.value = result;
}