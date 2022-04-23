const projects = document.querySelectorAll('.project-list a'); 
//const firstProject = projects.item(0);

const selectedProject = document.querySelector('.current-project h4');

// if (firstProject !== null) {
//     if (firstProject.innerHTML !== null || firstProject.innerHTML !== "") {
//         selectedProject.innerHTML = firstProject.innerHTML;
//
//     }
//
// }


projects.forEach(project => project.addEventListener('click', (e) => {

    selectedProject.innerHTML = e.target.text;
    //console.log(e.target.text);
}));




function lightMode() {
    document.body.style.backgroundColor  = "#fff";
    document.body.style.color = '#333'; 
    let items = document.querySelectorAll('.project-list a, .select-display a')

    document.querySelector('.search-bar input')
    
    items.forEach(item => item.style.color='#333');

    document.querySelector('.search-bar input').style.border='1px solid #333';

    let buttons = document.querySelectorAll('.btn');
   buttons.forEach(button => button.style.color='#fff');
}

function darkMode() {
    document.body.style.backgroundColor  = "#333";
    document.body.style.color = '#fff'; 
    let items = document.querySelectorAll('.project-list a, .select-display  a')
    
    items.forEach(item => item.style.color='#fff');   
}

var isDarkMode = true;
function changeMode() {
    
    
    if (isDarkMode) {
        lightMode(); 
        isDarkMode = false;
        console.log(isDarkMode);
    } else {
        darkMode();
        isDarkMode = true
    }
}




// // Get the modal
// var createBuModal = document.getElementById("createBug");

// // Get the button that opens the modal
// var btn_bug = document.querySelector('.btn-bug');

// // Get the <span> element that closes the modal
// var span = document.getElementsByClassName("close")[0];

// // When the user clicks on the button, open the modal
// btn_bug.onclick = function() {
//   createBuModal.style.display = "block";
// }

// // When the user clicks on <span> (x), close the modal
// span.onclick = function() {
//   createBuModal.style.display = "none";
// }

// // When the user clicks anywhere outside of the modal, close it
// window.onclick = function(event) {
//   if (event.target == createBuModal) {
//     createBuModal.style.display = "none";
//   }
// }



// // Get the modal
// var createProjectModal = document.getElementById("createProject");

// // Get the button that opens the modal
// var btn_project = document.querySelector('.btn-project');

// // Get the <span> element that closes the modal
// var span = document.getElementsByClassName("close")[1];

// // When the user clicks on the button, open the modal
// btn_project.onclick = function() {
//   createProjectModal.style.display = "block";
// }

// // When the user clicks on <span> (x), close the modal
// span.onclick = function() {
//   createProjectModal.style.display = "none";
// }

// // When the user clicks anywhere outside of the modal, close it
// window.onclick = function(event) {
//   if (event.target == createProjectModal) {
//     createProjectModal.style.display = "none";
//   }
// }

var span1 = document.getElementsByClassName("close")[0]; 
var span2 = document.getElementsByClassName("close")[1]; 
var createProjectModal = document.getElementById("createProject");
var btn_project = document.querySelector('.btn-project');
var createBuModal = document.getElementById("createBug");
var btn_bug = document.querySelector('.btn-bug');


function openCloseModal(modal,button,span) {
  button.onclick = function () {
    modal.style.display = "block"; 
}
    span.onclick = function() {
      modal.style.display = "none";
      }

   window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  } 
  } 

}


openCloseModal(createBuModal,btn_bug,span1); 
openCloseModal(createProjectModal, btn_project, span2);


const projectButton = document.querySelector('.btn-projectBugs');



//var selectedProject = document.querySelector('.current-project h4').innerHTML;


// projectButton.addEventListener('click', getAllBugsByProject() );
//
//
// function getAllBugsByProject() {
//     $.ajax({
//         type: "GET",
//         url: "/bug/getBugsByProjectName?projectName=" + selectedProject.innerHTML,
//         success: function (result) {
//             if (result.status == "success") {
//                 console.log(result.data);
//             }
//         }
//     })
// }
