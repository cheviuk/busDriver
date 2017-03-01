var link = "http://localhost";
var send = document.getElementById("send");
var timer;

function httpGetRequest(link){
	var xmlHttp = new XMLHttpRequest();
  xmlHttp.onreadystatechange = function(){
  	if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
    	//updateUserPositionMarker(xmlHttp.responseText);
    	//updateUserPositionMarker(userMarker, userCurrentPosition);
        console.log(xmlHttp.responseText);
    }
	if(xmlHttp.status == 404){
		console.log("404");
	}
    console.log("status = " + xmlHttp.status);
  }
  xmlHttp.open("GET", "http://localhost:8080/RESTFulExample/rest/dispatcher/test", true);
  xmlHttp.send(null);
  console.log("send");
}

function timeout(){
send = document.getElementById("send");
console.log(send.checked);
console.log(timer);
	timer = setTimeout(function(){
  	httpGetRequest();
	if(send.checked){
		timeout();
	}
  }, document.getElementById("delay").value);

}