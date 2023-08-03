

// //////////////////////////////////to create Board////////////////////////////////////////

function createCard() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    
    var raw = JSON.stringify({
        "createdDate": document.getElementById("createdDate").value,
        "updatedDate": document.getElementById("updatedDate").value,
        "isActive": document.getElementById("isActive").value,
        "title": document.getElementById("title").value,
        "section": document.getElementById("section").value,
        "description": document.getElementById("description").value,
    });
    
    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };
    
    fetch("http://localhost:8080/create", requestOptions)
        .then(response => response.json())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}

//////////////////////////////////////////////////// to get all boards////////////////////////////

function getAllBoards() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/get", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}



//////////////////////get board by ID/////////////////////////////


function getBoardByID() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/api/board/2", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}



/////////////////////////delete Board by ID//////////////////////



function deleteBoardByID() {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'DELETE',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/delete/1", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}






/////////////////////////////////to create card////////////////////////////////////
function createCard(){
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "createdDate": null,
  "updatedDate": null,
  "isActive": null,
  "cardId": 2,
  "boardModel": null,
  "title": "",
  "section": "section",
  "description": "description"
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/createCard", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}




/////////////////////////to get all Cards/////////////////////////////

function getallCards(){
var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "createdDate": null,
  "updatedDate": null,
  "isActive": null,
  "cardId": 2,
  "boardModel": null,
  "title": "",
  "section": "section",
  "description": "description"
});

var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/getCard", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}


/////////////////////////get card by id////////////////////////


function getCardByID(){

var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "createdDate": null,
  "updatedDate": null,
  "isActive": null,
  "cardId": 2,
  "boardModel": null,
  "title": "",
  "section": "section",
  "description": "description"
});

var requestOptions = {
  method: 'GET',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:8080/api/Card/2", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
}


/////////////////////////Delet card by id //////////////////////

function deletCard(){

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    
    var raw = JSON.stringify({
      "createdDate": null,
      "updatedDate": null,
      "isActive": null,
      "cardId": 2,
      "boardModel": null,
      "title": "",
      "section": "section",
      "description": "description"
    });
    
    var requestOptions = {
      method: 'DELETE',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
    
    fetch("http://localhost:8080/deleteCard/1", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));



}

//////////////////update card ///////////////////////


function updateCard(){


    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    
    var raw = JSON.stringify({
      "createdDate": null,
      "updatedDate": null,
      "isActive": null,
      "cardId": 2,
      "boardModel": null,
      "title": "",
      "section": "section",
      "description": "description"
    });
    
    var requestOptions = {
      method: 'PUT',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
    
    fetch("http://localhost:8080/UpdateCard/2", requestOptions)
      .then(response => response.text())
      .then(result => console.log(result))
      .catch(error => console.log('error', error));










}