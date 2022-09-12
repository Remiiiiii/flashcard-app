async function sendLoginRequest(firstname, lastname, password, username){
    let response = await fetch(`http://localhost:9005/user`, {
            method: "POST",
            credentials: "include",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                "firstname": firstname,
                "lastname": lastname,
                "password": password,
                "username": username
            })
        }
    )

    let responseBody = await response.json();
    
    if(responseBody.successful){
        window.location = "../login";
    }else{
        let messageElem = document.getElementById("message");
        messageElem.style.display = "block";
    }
};

let loginFormElem = document.getElementById("login-form");

loginFormElem.addEventListener("submit", (event) => {
    event.preventDefault()

    //retrieve values from login input
    let userNameInputElem = document.getElementById("username-input");
    let passwordInputElem = document.getElementById("password-input");
    let firstNameInputElem = document.getElementById("firstname-input");
    let lastNameInputElem = document.getElementById("lastname-input");

    sendLoginRequest(firstNameInputElem, lastNameInputElem, passwordInputElem.value, userNameInputElem.value);
});