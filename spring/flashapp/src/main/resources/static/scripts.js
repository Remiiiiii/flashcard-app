window.onload = async () => {
    let response = await fetch("http://localhost:9005/session");
    
    let responseBody = await response.json();

    if(responseBody.successful){
        window.location = "./flashcard-set-dashboard/index.html";
    }
}

let loginFormElem = document.getElementById("login-form");

loginFormElem.addEventListener("submit", (event) => {
    event.preventDefault()

    //retrieve values from login input
    let userNameInputElem = document.getElementById("username-input");
    let passwordInputElem = document.getElementById("password-input");

    sendLoginRequest(userNameInputElem.value, passwordInputElem.value);
});

// ---------------------------------------------------------------------------------

/*let addCardFormElem = document.getElementById("add-card-form")
    addCardFormElem.addEventListener("submit", (event) => {
    event.preventDefault()

    
});*/

// ---------------------------------------------------------------------------------


async function sendLoginRequest(username, password){
    let response = await fetch(`http://localhost:9005/session`, {
            method: "POST",
            credentials: "include",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                "username": username,
                "password": password
            })
        }
    )

    let responseBody = await response.json();
    
    if(responseBody.successful){
        window.location = "/flashcard-set-dashboard/index.html";
    }else{
        let messageElem = document.getElementById("message");
        messageElem.style.display = "block";
    }
}
