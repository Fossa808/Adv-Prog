let button = document.getElementById("show-button");
button.addEventListener('click', function(){
    showEmoji();
});

let modeButton = document.getElementById("mode");
modeButton.addEventListener('click', function(){
    changeMode();
})

function changeMode(){
    let currentMode = modeButton.innerHTML.toLowerCase();
    if(currentMode === "darkmode"){
        modeButton.innerHTML = "lightmode";
        const link = document.querySelector('link[rel="stylesheet"]');
        link.href = "emojiDark.css";
    }else{
        modeButton.innerHTML = "darkmode";
        const link = document.querySelector('link[rel="stylesheet"]');
        link.href = "emojiLight.css";
    }
}

function showEmoji(){
    let input_box = document.getElementById("emoji-text");
    let input = input_box.value.toLowerCase();
    let span = document.getElementById("output");
    if(input === "grinning"){
        span.innerHTML = "😀";
    }else if(input === "crying"){
        span.innerHTML = "😢"
    }else if(input === "heart"){
        span.innerHTML = "❤️";
    }else if(input === "dog"){
        span.innerHTML = "🐶";
    }else if(input === "cherry blossom"){
        span.innerHTML = "🌸";
    }
}