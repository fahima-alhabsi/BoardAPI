///function to get card
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
const tasks = []


var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  redirect: 'follow'
};

fetch("http://localhost:8080/api/boards/2/cards", requestOptions)
  .then((response) => {return response.json()})
  .then((result) =>{
    result.forEach(card => {
      const deleteOptions = document.getElementById('deleteExistingCard');

      const option1= document.createElement('option');
      option1.value = card.cardId;
      option1.textContent = 'Card ID:' + card.cardId;
      deleteOptions.appendChild(option1);
      createCard(card.cardId,card.title,card.section,card.description)
    })
  })
  .catch(error => console.log('error', error));


  function createCard(cardId, title, SECTION, description) {
    const cardDiv = document.createElement('div');
    cardDiv.className = 'card';

    const h3CardId = document.createElement('h3');
    h3CardId.textContent = 'Card ID: ' + cardId;
    cardDiv.appendChild(h3CardId);

    const h4Title = document.createElement('h4');
    h4Title.textContent = 'Title: ' + title;
    cardDiv.appendChild(h4Title);

    const pDescription = document.createElement('p');
    pDescription.textContent = 'Description: ' + description;
    cardDiv.appendChild(pDescription);


    column1 =document.getElementById('1')
    column2 =document.getElementById('2')
    column3 =document.getElementById('3')
   if(SECTION =='1'){
    column1.appendChild(cardDiv);
   }
   else if(SECTION =='2'){
    column2.appendChild(cardDiv);
   }
else if(SECTION =='3'){
  column3.appendChild(cardDiv);
}

}




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
function addCard(){
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  
  var raw = JSON.stringify({
    "title": document.getElementById('createTitle').value,
    "description":  document.getElementById('createDescription').value,
    "section":  document.getElementById('createSection').value
  });
  
  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };
  
  fetch("http://localhost:8080/api/boards/2/cards", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
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


function deleteCard() {
  cardId = document.getElementById("deleteExistingCard").value
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  

  
  var requestOptions = {
    method: 'DELETE',
    headers: myHeaders,

    redirect: 'follow'
  };
  
  fetch("http://localhost:8080/api/boards/2/cards/"+cardId, requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
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


