const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});
let setId = params.setId;
let cardContainer = document.getElementById("card-container");
let user;
let cards;
window.onload = async () => {
    let response = await fetch("http://localhost:9005/session");
      
    let responseBody = await response.json();
  
    if(!responseBody.successful){
      window.location = "../index.html";
    }

    if(!setId){
        window.location = "../flashcard-set-dashboard/index.html";
    }
  
    user = responseBody.data;
    cards = await getAllItems();

    //Redirect if incorrect user
    if(cards[0].flashcardSet.user.id != user.id){
        window.location = "../flashcard-set-dashboard/index.html";
    }
    
    displayFlashcards();
}

async function getAllItems(){
    let response = await fetch(`http://localhost:9005/flashcard/${setId}`);
  
    let responseBody = await response.json();
    console.log(responseBody);
    return responseBody;
}

function displayFlashcards(){
    
    cards.forEach(card => {
        let parentCardElem = document.createElement("div");
        parentCardElem.className = "card";
  
        let insideCardElem = document.createElement("div");
        insideCardElem.className = "inside-card";
  
        insideCardElem.addEventListener('click', function() {
        insideCardElem.classList.toggle('flipped');
          
        });
  
        let cardFaceFrontElem = document.createElement("div");
        cardFaceFrontElem.className = "card-face card-front";
  
        let cardFrontHeaderElem = document.createElement("div");
        cardFrontHeaderElem.className = "card-front-header";
  
        let imgElem = document.createElement("img");
        imgElem.className = "front-card-logo";
        imgElem.src = "../images/fm.jpg";
        imgElem.alt = "app logo";
  
        let headerFrontTextElem = document.createElement("h2");
        headerFrontTextElem.innerText = card.title;
  
        let cardFaceBackElem = document.createElement("div");
        cardFaceBackElem.className = "card-face card-back";
  
        let cardBackContentElem = document.createElement("div");
        cardBackContentElem.className = "back-card-content";
  
        let cardBackBodyElem = document.createElement("div");
        cardBackBodyElem.className = "back-card-body";
  
        let headerBackTextElem = document.createElement("h3");
        headerBackTextElem.innerText = "Description:";
  
        let descriptionTextElem = document.createElement("p");
        descriptionTextElem.innerText = card.description;
  
        let deleteButtonElem = document.createElement("button");
        deleteButtonElem.className = "delete-button";
        deleteButtonElem.id = "delete-card-form";
        deleteButtonElem.innerText = "Delete";
        deleteButtonElem.value = card.id;
        deleteButtonElem.addEventListener('click', function() {
        fetch(`http://localhost:9005/flashcard/${card.id}`, {method: "DELETE"});
          window.location = `./index.html?setId=${setId}`;
        });
  
        //Front of Card Set
        cardFrontHeaderElem.appendChild(imgElem);
        cardFrontHeaderElem.appendChild(headerFrontTextElem);
        cardFaceFrontElem.appendChild(cardFrontHeaderElem);
        insideCardElem.appendChild(cardFaceFrontElem);
        parentCardElem.appendChild(insideCardElem);
        cardContainer.appendChild(parentCardElem);
  
        //Back of Card Set
        cardBackBodyElem.appendChild(headerBackTextElem);
        cardBackBodyElem.appendChild(descriptionTextElem);
        cardBackContentElem.appendChild(cardBackBodyElem);
        cardFaceBackElem.appendChild(cardBackContentElem);
        insideCardElem.appendChild(cardFaceBackElem);
  
        //Buttons
        insideCardElem.appendChild(deleteButtonElem);
    });
    
  }

let searchButtonElem = document.getElementById("find-flashcardset-btn");
searchButtonElem.addEventListener('click', (event) => {
  event.preventDefault();
  let searchBarElem = document.getElementById("find-flashcard-input");
  let filter = searchBarElem.value.toUpperCase();
  let parent = document.getElementById("card-container");
  let child = parent.getElementsByClassName("card");
  for (i = 0; i < child.length; i++) {
    title = child[i].getElementsByTagName("h2")[0];
    txtValue = title.textContent || title.innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      child[i].style.display = "";
    } else {
      child[i].style.display = "none";
    }
  }
});

let subMenu = document.getElementById("subMenu");

let homeButton = document.getElementById("home-button");
homeButton.addEventListener('click', () => {
       window.location = "../flashcard-set-dashboard/index.html";
});


let newFlashcardButton = document.getElementById("add-flashcard-btn");
newFlashcardButton.addEventListener('click', () => {
       window.location = `../newflashcard-dashboard/index.html?setId=${setId}`;
});


