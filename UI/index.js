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





