//fucntion to get card



document.getElementById("boardApiName").innerText="Choose Board ID:"

const requestOptionss = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/api/boards", requestOptionss)
  .then((response) => {return response.json()})
  .then((result) => {
result.forEach(board => {
  const boardList = document.getElementById('boardsInfo');

  const option= document.createElement('option');
  option.value = board.id;
  option.textContent = 'Board ID:' + board.id;
  boardList.appendChild(option);
  })
})
  .catch(error => console.log('error', error));


const boardId = document.getElementById('boardsInfo').value
function getBoardId(){
  column1 =document.getElementById('1')
  column2 =document.getElementById('2')
  column3 =document.getElementById('3')
  column1.innerHTML="";
  column2.innerHTML="";
  column3.innerHTML="";
///function to get card
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");



const requestOptions = {
  method: 'GET',
  headers: myHeaders,
  redirect: 'follow'
};
const deleteOptions = document.getElementById('deleteExistingCard');
const updateExistingCard = document.getElementById('updateExistingCard');
deleteOptions.innerHTML=""
updateExistingCard.innerHTML=""
fetch("http://localhost:8080/api/boards/"+document.getElementById('boardsInfo').value.trim()+"/cards", requestOptions)
  .then((response) => {return response.json()})
  .then((resultt) =>{
    resultt.forEach(card => {
     
      const option1= document.createElement('option');
      option1.value = card.cardId;
      option1.textContent = 'Card ID:' + card.cardId;
      const option2= document.createElement('option');
      option2.value = card.cardId;
      option2.textContent = 'Card ID:' + card.cardId;
      deleteOptions.appendChild(option1);
      updateExistingCard.appendChild(option2);
      createCard(card.cardId,card.title,card.section,card.description)
    })
  })
  .catch(error => console.log('error', error));
SetName()

}

  
 


function SetName(){
  var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");



const requestOptions = {
  method: 'GET',
  headers: myHeaders,
 
  redirect: 'follow'
};

fetch("http://localhost:8080/api/boards/"+document.getElementById('boardsInfo').value.trim(), requestOptions)
.then((response) => {return response.json()})
  .then((result) =>{ 
    console.log(result)
    document.getElementById("boardApiName").innerText=result.title
    
    console.log(result)})
  .catch(error => console.log('error', error));
}


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


function addCard(){
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");
  
  var raw = JSON.stringify({
    "title": document.getElementById('createTitle').value,
    "description":  document.getElementById('createDescription').value,
    "section":  document.getElementById('createSection').value
  });
  
  const requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };
  
  fetch("http://localhost:8080/api/boards/"+document.getElementById('boardsInfo').value.trim()+"/cards", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));

}


function getAllCards() {
  const requestOptions = {
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
  const requestOptions = {
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
  

  
  const requestOptions = {
    method: 'DELETE',
    headers: myHeaders,

    redirect: 'follow'
  };
  
  fetch("http://localhost:8080/api/boards/"+document.getElementById('boardsInfo').value.trim()+"/cards/"+cardId, requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
}


function updateCard() {
  cardId = document.getElementById("updateExistingCard").value

  var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
alert(cardId+document.getElementById("updateTitle").value+document.getElementById("updateSection").value+
document.getElementById("updateDescription").value)
var raw = JSON.stringify({
  "cardId": cardId,
  "title": document.getElementById("updateTitle").value,
  "section":document.getElementById("updateSection").value,
  "description": document.getElementById("updateDescription").value
});

const requestOptions = {
  method: 'PUT',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/api/boards/"+document.getElementById('boardsInfo').value.trim()+"/cards/"+cardId, requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}


function updateBoardTtile(){
  var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "title":document.getElementById('newTitle').value
});

const requestOptions = {
  method: 'PUT',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/api/boards/"+document.getElementById('boardsInfo').value.trim(), requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}
