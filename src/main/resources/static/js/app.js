const projects = document.querySelectorAll('.project-list a'); 
const bugList =  document.querySelector('.bug-list');

const selectedProject = document.querySelector('.current-project h4');

if (projects !== null || projects.length >0) {
    const firstProject = projects.item(0);
    if (firstProject !== null ) {
        selectedProject.innerHTML = firstProject.innerHTML;
    }

}


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


$(document).ready(
    function() {
        $('.btn-projectBugs').click(function (event) {
            ajaxGet();
        });

        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: "/bug/getBugsByProjectName?projectName=" + selectedProject.innerHTML,
                dataType: 'json', // added data type
                success: function (result) {
                    if (result != null) {

                        $('.bug-list ul').empty();
                        for (let i=0; i<result.length; i++) {
                            let bugName = result[i].bugName;
                            let bugId = result[i].bugId;
                            let li = document.createElement('li');
                            let a = document.createElement('a');
                            a.appendChild(document.createTextNode(bugName));
                            a.setAttribute("href", "/bug/getBugDetails?bugId=" + bugId);
                            a.setAttribute("method", "get");
                            li.append(a);
                            $('.bug-list ul').append(li);
                        }
                    } else {
                        console.log('fail');
                    }
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                }
            });
        }
    }
)


window.addEventListener("load", () => {
    // get html elements
    var filter = document.querySelector('#searchProject');
    var list = document.querySelectorAll('.project-list a');
    //attach key up listener to search bar
    filter.onkeyup = () => {

        //get current search
        let search = filter.value.toLowerCase();
        for (let i of list) {
            let item = i.innerHTML.toLowerCase();
            if (item.indexOf(search) === -1) {
                i.style.display="none";
            } else {
                i.style.display="block";
            }
        }
    };
});


