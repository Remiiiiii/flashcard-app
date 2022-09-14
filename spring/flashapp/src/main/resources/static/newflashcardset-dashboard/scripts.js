let user;

window.onload = async () => {
    let response = await fetch("http://localhost:9005/session");
      
    let responseBody = await response.json();
  
    if(!responseBody.successful){
  
      window.location = "../index.html";
    }
  
    user = responseBody.data;
}

let backButton = document.getElementById("back-btn");

backButton.addEventListener('click', (event) => {
    event.preventDefault()
    window.location = "../flashcard-set-dashboard/index.html"
});

let saveButton = document.getElementById("save-btn");

saveButton.addEventListener('click', (event) => {
    event.preventDefault()
    saveSet();
});

async function saveSet(){
    let titleText = document.getElementById("title").value;
    let descriptionText = document.getElementById("description").value;

    let response = await fetch(`http://localhost:9005/flashcardset`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                "title": titleText,
                "description": descriptionText,
                "user": {
                    "id": user.id
                }
            })
        }
    )

    let responseBody = await response.json();
    if(responseBody){
        window.location = "./index.html";
    }else{
        console.log("ERROR: Could not create set");
    }

}

let homeButton = document.getElementById("home-button");
homeButton.addEventListener('click', () => {
       window.location = "../flashcard-set-dashboard/index.html";
});





