var userMarker;
var map;
var userCurrentPosition = {lat: 0.0, lng: 0.0};
var userPreviousPosition = {lat: 0.0, lng: 0.0};
var markerIcon = {
        path: google.maps.SymbolPath.FORWARD_CLOSED_ARROW,
        strokeColor: '#3333FF',
        strokeWeight: 1.5,
        scale: 4,
        rotation: 50,
        anchor: new google.maps.Point(0, 0)
};

function makeMarker(position){
  userMarker = new google.maps.Marker({
    position: {lat: position.coords.latitude, lng: position.coords.longitude},
    map: map,
    title: 'Я тут!',
    icon: markerIcon
    });
  //userMarker.setFlat(true);
  map.setCenter(userMarker.getPosition());
  }

 function updateUserPositionMarker(userMarker, position){
	userPreviousPosition = {lat: userCurrentPosition.lat, lng: userCurrentPosition.lng};
	userCurrentPosition = {lat: position.coords.latitude, lng: position.coords.longitude};

	var heading = google.maps.geometry.spherical.computeHeading(new google.maps.LatLng(userPreviousPosition.lat, userPreviousPosition.lng),new google.maps.LatLng(userCurrentPosition.lat, userCurrentPosition.lng));
	//userMarker.setRotation(heading);
	//alert(heading);
	markerIcon.rotation = heading;
  userMarker.position = userCurrentPosition;
  userMarker.setPosition(userCurrentPosition);
  //map.panTo(userCurrentPosition);
	//userMarker.setMap(null);
	//userMarker.setMap(map);
    markerIcon.rotation = heading;
	userMarker.setIcon(markerIcon);
	//
	map.setCenter(userCurrentPosition);
  }

function initMap() {

  var myLatLng = {lat: 0.0, lng: 0.0};
	navigator.geolocation.getCurrentPosition(function(position){myLatLng = {lat: position.coords.latitude, lng: position.coords.longitude};});
	map = new google.maps.Map(document.getElementById('map'), {
    zoom: 16,
    center: myLatLng
  });



  navigator.geolocation.getCurrentPosition(makeMarker);


  navigator.geolocation.watchPosition(function(position){updateUserPositionMarker(userMarker, position);}, function(error){/*donothing*/},{timeout: 1000});


  var flightPlanCoordinates = [
	{lat: 46.469409, lng: 30.638559},
	{lat: 46.468624, lng: 30.618504},
	{lat: 46.486378, lng: 30.614915},
	{lat: 46.475139, lng: 30.643630}
  ];

  var polyline = new google.maps.Polyline({
	path: flightPlanCoordinates,
	geodesic: true,
	strokeColor: '#0000FF',
	strokeOpacity: 1.0,
	strokeWeight: 2
  });

  polyline.setMap(map);
}