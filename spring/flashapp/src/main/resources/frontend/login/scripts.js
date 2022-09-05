let loginFormElem = document.getElementById("login-form");

loginFormElem.addEventListener("submit", (event) => {
    event.preventDefault()

    //retrieve values from login input
    let userNameInputElem = document.getElementById("username-input");
    let passwordInputElem = document.getElementById("password-input");

    sendLoginRequest(userNameInputElem.value, passwordInputElem.value);
});

// ---------------------------------------------------------------------------------

let addCardFormElem = document.getElementById("add-card-form")
addCardFormElem.addEventListener("submit", (event) => {
    event.preventDefault()

    
});

// ---------------------------------------------------------------------------------


function sendLoginRequest(username, password){
}