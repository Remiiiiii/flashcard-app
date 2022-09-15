async function sendRegisterRequest(userCredentials){
    let response = await fetch("/user", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userCredentials)
                
    })
        
    let responseBody = await response.json();
    
    if(responseBody.successful){
        window.location = "../index.html";
    }else{
        let messageElem = document.getElementById("message");
        messageElem.style.display = "block";
    }
};

let registerFormElem = document.getElementById("registration-form");

registerFormElem.addEventListener("submit", (event) => {
    event.preventDefault()

    //retrieve values from login input
    let credentials = {
        "username": document.getElementById("username-input").value,
        "password": document.getElementById("password-input").value,
        "firstname": document.getElementById("firstname-input").value,
        "lastname": document.getElementById("lastname-input").value
    }
    sendRegisterRequest(credentials);
});