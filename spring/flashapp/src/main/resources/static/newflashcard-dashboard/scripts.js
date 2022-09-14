const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});
let setId = params.setId;
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
    window.location = `../flashcard-dashboard/index.html?setId=${setId}`;
});

let saveButton = document.getElementById("save-btn");

saveButton.addEventListener('click', (event) => {
    event.preventDefault()
    saveCard();
});

async function saveCard(){
    let front = document.getElementById("front").value;
    let back = document.getElementById("back").value;

    let response = await fetch(`http://localhost:9005/flashcard`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                "title": front,
                "description": back,
                "flashcardSet": {
                    "id": setId
                }
            })
        }
    )

    let responseBody = await response.json();
    if(responseBody){
        window.location = `./index.html?setId=${setId}`;
    }else{
        alert("ERROR: Could not create flashcard");
    }

}

let homeButton = document.getElementById("home-button");
homeButton.addEventListener('click', () => {
       window.location = "../flashcard-set-dashboard/index.html";
});

//-------------------------------Profile Icon Menu Dropdown------------------------------

let addCardBtn = document.getElementById("add-flashcard-btn");
addCardBtn.addEventListener('click', () => {
       window.location = "../newflashcardset-dashboard/index.html";
});



