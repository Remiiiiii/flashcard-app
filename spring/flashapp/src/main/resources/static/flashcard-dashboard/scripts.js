let card = document.querySelector(".inside-card");

card.addEventListener('click', function() {
    card.classList.toggle('flipped');
});

let subMenu = document.getElementById("subMenu");

//-------------------------------Profile Icon Menu Dropdown------------------------------

// let addFlashcardElem = document.getElementById("add-flashcard-btn");
// addFlashcardElem.addEventListener("click", () => {
//     window.location.href = "/newflashcard-dashboard/index.html";
// });


let homeButton = document.getElementById("home-button");
homeButton.addEventListener('click', () => {
       window.location = "../flashcard-set-dashboard/index.html";
});


