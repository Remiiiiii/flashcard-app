let card = document.querySelector(".inside-card");

card.addEventListener('click', function() {
    card.classList.toggle('flipped');
});

let subMenu = document.getElementById("subMenu");

//-------------------------------Profile Icon Menu Dropdown------------------------------

let addCardBtn = document.getElementById("add-flashcard-btn");
addCardBtn.addEventListener('click', () => {
       window.location = "../newflashcardset-dashboard/index.html";
});



