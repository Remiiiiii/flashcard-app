let setContainer = document.getElementById("set-container");
let sets;
let user;
window.onload = async () => {
  let response = await fetch("http://localhost:9005/session");
    
  let responseBody = await response.json();

  if(!responseBody.successful){

    window.location = "../index.html";
  }

  user = responseBody.data;
  sets = await getAllItems();
  console.log(sets);
  displaySets();
}

async function getAllItems(){
  let response = await fetch(`http://localhost:9005/flashcardset/${user.id}`);

  let responseBody = await response.json();

  return responseBody;
}

function displaySets(){
    
  sets.forEach(set => {
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
      headerFrontTextElem.innerText = set.title;

      let cardFaceBackElem = document.createElement("div");
      cardFaceBackElem.className = "card-face card-back";

      let cardBackContentElem = document.createElement("div");
      cardBackContentElem.className = "back-card-content";

      let cardBackBodyElem = document.createElement("div");
      cardBackBodyElem.className = "back-card-body";

      let headerBackTextElem = document.createElement("h3");
      headerBackTextElem.innerText = "Description:";

      let descriptionTextElem = document.createElement("p");
      descriptionTextElem.innerText = set.description;

      let selectButtonElem = document.createElement("button");
      selectButtonElem.className = "cards-button";
      selectButtonElem.id = "delete-card-form";
      selectButtonElem.innerText = "Select";
      selectButtonElem.value = set.id;

      let deleteButtonElem = document.createElement("button");
      deleteButtonElem.className = "delete-button";
      deleteButtonElem.id = "delete-card-form";
      deleteButtonElem.innerText = "Delete";
      deleteButtonElem.value = set.id;

      //Front of Card Set
      cardFrontHeaderElem.appendChild(imgElem);
      cardFrontHeaderElem.appendChild(headerFrontTextElem);
      cardFaceFrontElem.appendChild(cardFrontHeaderElem);
      insideCardElem.appendChild(cardFaceFrontElem);
      parentCardElem.appendChild(insideCardElem);
      setContainer.appendChild(parentCardElem);

      //Back of Card Set
      cardBackBodyElem.appendChild(headerBackTextElem);
      cardBackBodyElem.appendChild(descriptionTextElem);
      cardBackContentElem.appendChild(cardBackBodyElem);
      cardFaceBackElem.appendChild(cardBackContentElem);
      insideCardElem.appendChild(cardFaceBackElem);

      //Buttons
      insideCardElem.appendChild(deleteButtonElem);
      insideCardElem.appendChild(selectButtonElem);
  });
  
}

//let card = document.querySelector(".inside-card");

//card.addEventListener('click', function() {
//    card.classList.toggle('flipped');
//});

let subMenu = document.getElementById("subMenu");

//-------------------------------Profile Icon Menu Dropdown------------------------------
function toggleMenu(){
  subMenu.classList.toggle("open-menu");
}

let logoutBtn = document.getElementById("logout-btn");
logoutBtn.addEventListener('click', () => {
    fetch("http://localhost:9005/session", {method: "DELETE"});
    window.location = "/index.html";
});