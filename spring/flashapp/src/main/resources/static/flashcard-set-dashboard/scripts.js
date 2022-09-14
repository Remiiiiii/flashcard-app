let setContainer = document.getElementById("set-container");
let set;
let user;
window.onload = async () => {
  let response = await fetch("http://localhost:9005/session");
    
  let responseBody = await response.json();

  if(!responseBody.successful){

    window.location = "../index.html";
  }

  user = responseBody.data;

  items = await getAllItems();
  displaySets();
}

async function getAllItems(){
  let response = await fetch(`http://localhost:9005/flashcardset/${user.id}`);

  let responseBody = await response.json();

  return responseBody.data;
}

let card = document.querySelector(".inside-card");

card.addEventListener('click', function() {
    card.classList.toggle('flipped');
});

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