

function lightMode() {
    document.body.style.backgroundColor  = "#fff";
    document.body.style.color = '#333';



    let buttons = document.querySelectorAll('.btn');
    buttons.forEach(button => button.style.color='#fff');
}

function darkMode() {
    document.body.style.backgroundColor  = "#333";
    document.body.style.color = '#fff';

}

var isDarkMode = true;
function changeMode() {


    if (isDarkMode) {
        lightMode();
        isDarkMode = false;
        console.log(isDarkMode);
    } else {
        darkMode();
        isDarkMode = true
    }
}


