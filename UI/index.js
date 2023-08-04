
//functions for Board////


function createBoard() {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    "name": document.getElementById("boardName").value
  });

  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };

  fetch("/create", requestOptions)
    .then(response => {
      if (response.status === 200) {
        console.log("Board created successfully!");
      } else {
        console.log("Failed to create board.");
      }
    })
    .catch(error => console.log('error', error));
}


function getAllBoards() {
  var requestOptions = {
    method: 'GET',
    headers: {
      "Content-Type": "application/json"
    },
    redirect: 'follow'
  };

  fetch("/get", requestOptions)
    .then(response => gitresponse.json())
    .then((result) => {
      result.forEach(board => {
        let div = document.getElementById("boardsColumn");
        div.innerHTML += "<h3 style='color: red'>Board ID: " + board.id + "</h3>";
        div.innerHTML += "Board Name: " + board.name + "<br />";
      });
    })
    .catch(error => console.log('error', error));
}

function getBoardById(boardId) {
  var requestOptions = {
    method: 'GET',
    headers: {
      "Content-Type": "application/json"
    },
    redirect: 'follow'
  };

  fetch("/api/board/" + boardId, requestOptions)
    .then(response => response.json())
    .then((result) => {
      let div = document.getElementById("boardByIdColumn");
      div.innerHTML = "<h3 style='color: red'>Board ID: " + result.id + "</h3>";
      div.innerHTML += "Board Name: " + result.name + "<br />";
    })
    .catch(error => console.log('error', error));
}


function deleteBoard(boardId) {
  var requestOptions = {
    method: 'DELETE',
    headers: {
      "Content-Type": "application/json"
    },
    redirect: 'follow'
  };

  fetch("/" + boardId, requestOptions)
    .then(response => {
      if (response.status === 200) {
        console.log("Board deleted successfully!");
      } else {
        console.log("Failed to delete board.");
      }
    })
    .catch(error => console.log('error', error));
}


//functions for Cards////

function createCard() {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    "title": document.getElementById("createTitle").value,
    "section": document.getElementById("cardSection").value,
    "description": document.getElementById("cardDescription").value
  });

  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };

  fetch("/createCard", requestOptions)
    .then(response => response.json())
    .then (data => {
      if (data) {
        console.log("Card created successfully!");
        alert ("card created successfully")
      } else {
        console.log("Failed to create card.");
      }
    })
    .catch(error => console.log('error', error));
}


function getAllCards() {
  var requestOptions = {
    method: 'GET',
    headers: {
      "Content-Type": "application/json"
    },
    redirect: 'follow'
  };

  fetch("/getCard", requestOptions)
    .then(response => response.json())
    .then((result) => {
      result.forEach(card => {
        let div = document.getElementById("cardsColumn");
        div.innerHTML += "<h3 style='color: red'>Card ID: " + card.cardId + "</h3>";
        div.innerHTML += "Title: " + card.title + "<br />";
        div.innerHTML += "Section: " + card.section + "<br />";
        div.innerHTML += "Description: " + card.description + "<br />";
      });
    })
    .catch(error => console.log('error', error));
}


function getCardById(cardId) {
  var requestOptions = {
    method: 'GET',
    headers: {
      "Content-Type": "application/json"
    },
    redirect: 'follow'
  };

  fetch("/api/Card/" + cardId, requestOptions)
    .then(response => response.json())
    .then((result) => {
      let div = document.getElementById("cardByIdColumn");
      div.innerHTML = "<h3 style='color: red'>Card ID: " + result.cardId + "</h3>";
      div.innerHTML += "Title: " + result.title + "<br />";
      div.innerHTML += "Section: " + result.section + "<br />";
      div.innerHTML += "Description: " + result.description + "<br />";
    })
    .catch(error => console.log('error', error));
}


function deleteCard(cardId) {
  var requestOptions = {
    method: 'DELETE',
    headers: {
      "Content-Type": "application/json"
    },
    redirect: 'follow'
  };

  fetch("/deleteCard/" + cardId, requestOptions)
    .then(response => {
      if (response.status === 200) {
        console.log("Card deleted successfully!");
      } else {
        console.log("Failed to delete card.");
      }
    })
    .catch(error => console.log('error', error));
}


function updateCard(cardId) {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    "title": document.getElementById("updateCardTitle").value,
    "section": document.getElementById("updateCardSection").value,
    "description": document.getElementById("updateCardDescription").value
  });

  var requestOptions = {
    method: 'PUT',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };

  fetch("/UpdateCard/" + cardId, requestOptions)
    .then(response => {
      if (response.status === 200) {
        console.log("Card updated successfully!");
      } else {
        console.log("Failed to update card.");
      }
    })
    .catch(error => console.log('error', error));
}


