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
    fetch("http://localhost:9005/session")
})