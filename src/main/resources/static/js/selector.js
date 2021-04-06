let movies = 3;
let person = 2;

function addMovie(){
    movies = movies + 1;
    let wheel = document.createElement("input");
    wheel.type = "text";
    wheel.name = "movie" + movies;
    wheel.id = "movie" + movies;
    wheel.required = true;
    let labeler = document.createElement("label");
    labeler.for = wheel.id;
    labeler.id = "label" + movies;
    labeler.innerHTML = "<mark>Item " + movies +"</mark> ";
    let brk = document.createElement("br");
    brk.id = "break"+movies;
    
    document.getElementById("addmovie").appendChild(labeler);
    document.getElementById("addmovie").appendChild(wheel);
    document.getElementById("addmovie").appendChild(brk);
    document.getElementById("numMovies").value = movies;
    document.getElementById("numPeople").value = person;
}

function removeMovie(){
    if (movies > 3 && movies > person + 1){
        document.getElementById("movie" + movies).remove();
        document.getElementById("label" + movies).remove();
        document.getElementById("break" + movies).remove();
        movies = movies - 1;
        document.getElementById("numMovies").value = movies;
        document.getElementById("numPeople").value = person;
    }
}


function addPerson(){
    if (person < movies - 1){
        person = person + 1;
        let wheel = document.createElement("input");
        wheel.type = "text";
        wheel.name = "person" + person;
        
        wheel.id = "person" + person;
        wheel.required = true;
        let labeler = document.createElement("label");
        labeler.for = wheel.id;
        labeler.id = "personlabel" + person;
        labeler.innerHTML = "<mark>Person " + person +"</mark> ";
        let brk = document.createElement("br");
        brk.id = "personbreak"+person;
        
        document.getElementById("addperson").appendChild(labeler);
        document.getElementById("addperson").appendChild(wheel);
        document.getElementById("addperson").appendChild(brk);
        document.getElementById("numMovies").value = movies;
        document.getElementById("numPeople").value = person;
    }
}

function removePerson(){
    if (person > 2){
        document.getElementById("person" + person).remove();
        document.getElementById("personlabel" + person).remove();
        document.getElementById("personbreak" + person).remove();
        person = person - 1;
        document.getElementById("numMovies").value = movies;
        document.getElementById("numPeople").value = person;
    }
}

function getMovie(){
    return movies;
}

function indexOnload(){
    document.getElementById("numMovies").value = movies;
    document.getElementById("numPeople").value = person;
    // add movies first then add people
    if (sessionStorage.getItem("prevmovies") === null) {

    }else{
    	let retrievedData = sessionStorage.getItem("prevmovies");
    	let newmovies = JSON.parse(retrievedData);
		console.log(retrievedData);
	    for (let mo = 1; mo <= 	sessionStorage.getItem("movies"); mo++){
	    	console.log(mo);
			if (mo <=3){
				document.getElementById("movie" + mo).value = newmovies[mo - 1];
			} else{
				addMovie();
				document.getElementById("movie" + mo).value = newmovies[mo - 1];
			}
		}
	}

	if (sessionStorage.getItem("prevpeople") === null) {

    }else{
    	let retrievedData = sessionStorage.getItem("prevpeople");
    	let newpeople = JSON.parse(retrievedData);
		console.log(retrievedData);
	    for (let mo = 1; mo <= 	sessionStorage.getItem("person"); mo++){
	    	console.log(mo);
			if (mo <=2){
				document.getElementById("person" + mo).value = newpeople[mo - 1];
			} else{
				addPerson();
				document.getElementById("person" + mo).value = newpeople[mo - 1];
			}
		}
	}
	validateCheckbox();
}

function store(){
	let prevmovies = [];
	let prevpeople = [];
	for (let mo = 1; mo <= 	movies; mo++){
		prevmovies.push(document.getElementById("movie" + mo).value);
	}
	for (mo = 1; mo <= 	person; mo++){
		prevpeople.push(document.getElementById("person" + mo).value);
	}
	sessionStorage.setItem("prevmovies",JSON.stringify(prevmovies));
	sessionStorage.setItem("prevpeople",JSON.stringify(prevpeople));
	sessionStorage.setItem("movies",movies);
	sessionStorage.setItem("person",person);
}
function logstorage(){
	console.log(sessionStorage.getItem("prevmovies"));
	console.log(sessionStorage.getItem("prevpeople"));
	console.log(sessionStorage.getItem("movies"));
	console.log(sessionStorage.getItem("person"));
}

function validateCheckbox(){
  // Get the checkbox
  var checkBox = document.getElementById("obfuscate");
  // If the checkbox is checked, display the output text
  if (checkBox.checked == true){
	for (let mo = 1; mo <= 	movies; mo++){
		document.getElementById("movie" + mo).type = 'password';
	}
  } else {
	for (let mo = 1; mo <= 	movies; mo++){
		document.getElementById("movie" + mo).type = 'text';
	}
  }
}