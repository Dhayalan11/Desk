/**
 * 
 */
function showPassword(){
 
       if(document.getElementById("showPassword").checked){
    
         document.getElementById("companyPasswordInputBox").type="text";
       }
       else{
    
           document.getElementById("companyPasswordInputBox").type="password";
       }
   }
 
 function logInSubmit(){
	 let email = document.getElementById("companyMailInputBox").value;
	 let password = document.getElementById("companyPasswordInputBox").value;
	 let xhr = new XMLHttpRequest();
	 
	 if(email != "" && password != ""){
		  document.getElementById("invalidCompany").innerText = "";
		  
		  xhr.onreadystatechange = function(){
			  if(xhr.readyState == 4 && xhr.status == 200 ){
				  if(xhr.responseText == 200){
	    window.location.href = "companyHomePage.html";
	     
				  }
				  else{
	document.getElementById("invalidCompany").innerText = "*Invalid email or password";
				  }
			  }
		  }
		  
		  xhr.open("POST","CompanySignIn");
		  xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
          xhr.send("companyEmail="+email+"&companyPassword="+password);
		  
		 
	 }
	 else{
		  document.getElementById("invalidCompany").innerText = "*Enter all the inputs.";
	 }
	 
	 
 } 
 //
 function logOut(){
	 let xhr = new XMLHttpRequest();
	 
	  xhr.onreadystatechange = function(){
		  if(xhr.status == 200 && xhr.readyState == 4){
			   window.location.href = "companySignIn.html";
		  }
	  }
	 
	 
	 
	 
	 xhr.open("POST","CompanyLogOut",true);
	 xhr.send();
 }
//
function showTeamFlow(){
  
    let xhr = new XMLHttpRequest();
    let jsonArray=null;
    let jsonObject=null;
    let teamName = null;
    let count =0;
document.getElementById("companyTicketPage").style="display:none";
document.getElementById("companyAddTeamsForm").style="display:none";
document.getElementById("viewDepartment").style="display:none";
document.getElementById("WarningMessageForAddTeams").style="display:none";
document.getElementById("companyAddAgentForm").style="display:none";
    document.getElementById("companyAgentMainPage").style="display:none";
document.getElementById("departmentFlow").style="display:block";

    document.getElementById("companyTeamList").innerHTML="";
  


xhr.onreadystatechange = function(){
	
	if(xhr.readyState==4 && xhr.status == 200){
		jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
		   teamName = jsonObject.teamName;
		   count = jsonObject.count;
		    document.getElementById("companyTeamList").innerHTML += "<div class="+"listOfTeam"+"><div class="+"listOfTeamLeft"+" onclick="+"showInsideTeam(this)"+"><p>"+teamName+"</p><p>count - "+count+"</p></div></div>";
		   
		}
		
	}
}
xhr.open("POST","ShowTeams",true);
xhr.send();

}
//
function showTickets(){
    document.getElementById("companyAddTeamsForm").style="display:none";
    document.getElementById("viewDepartment").style="display:none";
    document.getElementById("departmentFlow").style="display:none";
     document.getElementById("companyAddAgentForm").style="display:none";
          document.getElementById("companyAgentMainPage").style="display:none";
          	document.getElementById("insideTheTicket").style="display:none";
    document.getElementById("companyTicketPage").style="display:block";
    
    //document.getElementById("selectTicket").value="open";
     document.getElementById("listOfTicket").innerHTML = "";
     document.getElementById('selectTicket').getElementsByTagName('option')[0].selected = 'selected';
     tickets();
    
}
//tickets();

function showOpenTicket(){
	 document.getElementById("listOfTicket").innerHTML = "";
	  let jsonArray=null;
    let jsonObject=null;
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
		    document.getElementById("listOfTicket").innerHTML += "<div class ="+"listOfTicketOnCompany"+"><div class="+"mailLogoInTicket"+"><i class=\"fa-regular fa-envelope\" ></i></div><div class = "+"secondBox"+" onclick=\"showInsideTicket(this)\"><div class="+"secondBoxInsideOne"+"><div class="+"ticketId"+">"+jsonObject.ticketId+"</div><div class="+"ticketName"+">"+jsonObject.ticketName+"</div></div><div class ="+"secondBoxInsideTwo"+"><div class="+"ticketOwnerName"+">"+jsonObject.ticketOwnerName+"</div><div class="+"ticketTime"+">"+jsonObject.ticketTime+"</div></div></div><div class="+"Box3status"+">"+jsonObject.ticketStatus+"</div>";
		}
		
		}
	}
	
	
	xhr.open("POST","SelectCompanyOpenTicket",true);
	xhr.send();
	 
}
function showOnholdTicket(){
	 document.getElementById("listOfTicket").innerHTML = "";
	  let jsonArray=null;
    let jsonObject=null;
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
		    document.getElementById("listOfTicket").innerHTML += "<div class ="+"listOfTicketOnCompany"+"><div class="+"mailLogoInTicket"+"><i class=\"fa-regular fa-envelope\" ></i></div><div class = "+"secondBox"+" onclick=\"showInsideTicket(this)\"><div class="+"secondBoxInsideOne"+"><div class="+"ticketId"+">"+jsonObject.ticketId+"</div><div class="+"ticketName"+">"+jsonObject.ticketName+"</div></div><div class ="+"secondBoxInsideTwo"+"><div class="+"ticketOwnerName"+">"+jsonObject.ticketOwnerName+"</div><div class="+"ticketTime"+">"+jsonObject.ticketTime+"</div></div></div><div class="+"Box3status"+">"+jsonObject.ticketStatus+"</div>";
		}
		
		}
	}
	
	
	xhr.open("POST","SelectCompanyOnholdTicket",true);
	xhr.send();
}
 function showEscalatedTicket(){
	 document.getElementById("listOfTicket").innerHTML = "";
	  let jsonArray=null;
    let jsonObject=null;
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
		    document.getElementById("listOfTicket").innerHTML += "<div class ="+"listOfTicketOnCompany"+"><div class="+"mailLogoInTicket"+"><i class=\"fa-regular fa-envelope\" ></i></div><div class = "+"secondBox"+" onclick=\"showInsideTicket(this)\"><div class="+"secondBoxInsideOne"+"><div class="+"ticketId"+">"+jsonObject.ticketId+"</div><div class="+"ticketName"+">"+jsonObject.ticketName+"</div></div><div class ="+"secondBoxInsideTwo"+"><div class="+"ticketOwnerName"+">"+jsonObject.ticketOwnerName+"</div><div class="+"ticketTime"+">"+jsonObject.ticketTime+"</div></div></div><div class="+"Box3status"+">"+jsonObject.ticketStatus+"</div>";
		}
		
		}
	}
	
	
	xhr.open("POST","SelectCompanyEscalatedTicket",true);
	xhr.send();
 }
 function showClosedTicket(){
	 document.getElementById("listOfTicket").innerHTML = "";
	  let jsonArray=null;
    let jsonObject=null;
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
		    document.getElementById("listOfTicket").innerHTML += "<div class ="+"listOfTicketOnCompany"+"><div class="+"mailLogoInTicket"+"><i class=\"fa-regular fa-envelope\" ></i></div><div class = "+"secondBox"+" onclick=\"showInsideTicket(this)\"><div class="+"secondBoxInsideOne"+"><div class="+"ticketId"+">"+jsonObject.ticketId+"</div><div class="+"ticketName"+">"+jsonObject.ticketName+"</div></div><div class ="+"secondBoxInsideTwo"+"><div class="+"ticketOwnerName"+">"+jsonObject.ticketOwnerName+"</div><div class="+"ticketTime"+">"+jsonObject.ticketTime+"</div></div></div><div class="+"Box3status"+">"+jsonObject.ticketStatus+"</div>";
		}
		
		}
	}
	
	
	xhr.open("POST","SelectCompanyClosedTickets",true);
	xhr.send();
 }
function tickets(){
	  let jsonArray=null;
    let jsonObject=null;
	let xhr = new XMLHttpRequest();
	   if(document.getElementById("listOfTicket")!=null)
	document.getElementById("listOfTicket").innerHTML = "";
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			
			jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
			if(document.getElementById("listOfTicket") != null)
		    document.getElementById("listOfTicket").innerHTML += "<div class ="+"listOfTicketOnCompany"+"><div class="+"mailLogoInTicket"+"><i class=\"fa-regular fa-envelope\" ></i></div><div class = "+"secondBox"+" onclick=\"showInsideTicket(this)\"><div class="+"secondBoxInsideOne"+"><div class="+"ticketId"+">"+jsonObject.ticketId+"</div><div class="+"ticketName"+">"+jsonObject.ticketName+"</div></div><div class ="+"secondBoxInsideTwo"+"><div class="+"ticketOwnerName"+">"+jsonObject.ticketOwnerName+"</div><div class="+"ticketTime"+">"+jsonObject.ticketTime+"</div></div></div><div class="+"Box3status"+">"+jsonObject.ticketStatus+"</div>";
		}
		
		}
	}
	
	
	xhr.open("POST","SelectTicket",true);
	xhr.send();
}
function showNewDepartments(){
    
    document.getElementById("viewDepartment").style="display:none";
    document.getElementById("companyTicketPage").style="display:none";
    document.getElementById("departmentFlow").style="display:none";
    	document.getElementById("insideTheTicket").style="display:none";
    document.getElementById("companyAddTeamsForm").style="display:block";
}

function addNewTeamInputs(){
    
   let teamName = document.getElementById("companyTextNameInputBox").value;
   let teamDesc = document.getElementById("companyTextDescInputBox").value;
 
    
  if(teamName=="" || teamDesc==""){
  document.getElementById("WarningMessageForAddTeams").style="display:block";
  }
  else{
    let xhr = new XMLHttpRequest();
    document.getElementById("companyTicketPage").style="display:none";
    document.getElementById("companyAddTeamsForm").style="display:none";
    document.getElementById("viewDepartment").style="display:none";
    document.getElementById("WarningMessageForAddTeams").style="display:none";
    document.getElementById("departmentFlow").style="display:block";
    
    xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			    
			     document.getElementById("companyTeamList").innerHTML += "<div class="+"listOfTeam"+"><div class="+"listOfTeamLeft"+" onclick="+"showInsideTeam(this)"+"><p>"+teamName+"</p><p>count - "+0+"</p></div></div>";

		}
	}
   
  
     xhr.open("POST","AddNewTeam");
     xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
     xhr.send("teamName="+teamName+"&teamDesc="+teamDesc);
     

  }
}
//
function showInsideTeam(element){
   let teamName =element.firstChild.innerHTML; 
  
   let desc = null;
   let xhr = new XMLHttpRequest();
   let jsonArray = null;
   let jsonObject = null;
    document.getElementById("companyTicketPage").style="display:none";
    document.getElementById("departmentFlow").style="display:none";
    document.getElementById("companyAddTeamsForm").style="display:none";
    
    document.getElementById("viewDepartment").style="display:block";
     document.getElementById("agentList").innerHTML="";
   
    
    xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			jsonArray = JSON.parse(xhr.responseText);
			document.getElementById("companyViewTeamsHeader2Left").innerHTML = "<p class="+"lableInsideViewTeam"+">Team name :</p>"+teamName;
			
			document.getElementById("companyViewTeamsHeader3Left").innerHTML = "<p class="+"lableInsideViewTeam"+">Team description : </p><p>"+jsonArray[0].teamDesc+"</p>";
			if(jsonArray[0].agentName != undefined){
				
			for(let i=0;i<jsonArray.length;i++){
				jsonObject = jsonArray[i];
				
				
				document.getElementById("agentList").innerHTML += "<div class="+"insideViewListOfAgent"+">"+jsonObject.agentName+"</div>";
			}	
			}
			
			
		}
	}
    
    xhr.open("POST","showInsideTeam");
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.send("teamName="+teamName);
    
    
 
}
//......
function showAgentFlow(){
	 let xhr = new XMLHttpRequest();
    let jsonArray=null;
    let jsonObject=null;
    //let agentName = null;
    let count =0;
    document.getElementById("companyTicketPage").style="display:none";
    document.getElementById("departmentFlow").style="display:none";
    document.getElementById("companyAddTeamsForm").style="display:none";
    document.getElementById("viewDepartment").style="display:none";
    document.getElementById("companyAddAgentForm").style="display:none";
      document.getElementById("companyAgentInsidePage").style="display:none";
      	document.getElementById("insideTheTicket").style="display:none";
    document.getElementById("companyAgentMainPage").style="display:block";
    
    document.getElementById("companyAgentList").innerHTML ="";
xhr.onreadystatechange = function(){
	
	if(xhr.readyState==4 && xhr.status == 200){
		jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
		    document.getElementById("companyAgentList").innerHTML += "<div class="+"listOfAgent"+"><div class="+"listOfAgentLeft"+" onclick="+"showInsideAgent(this)"+"><p>"+jsonObject.agentName+"</p><p>Email - "+jsonObject.agentMail+"</p></div></div>";
		   
		}
		
	}
}
xhr.open("POST","ShowAgent",true);
xhr.send();

}

function show(ar){
	if(ar == "open"){
		showOpenTicket();
	}
	else if(ar == "onHold"){
		showOnholdTicket();
	}
	else if(ar == "escalated"){
		showEscalatedTicket();
	}
	else if(ar == "closed"){
		showClosedTicket();
	}
	else if(ar == "all"){
	tickets();	
	}
}

function showInsideAgent(event){
	
    document.getElementById("companyAgentMainPage").style="display:none";
    document.getElementById("companyAgentInsidePage").style="display:block";
    let xhr = new XMLHttpRequest();
    let detail = event.lastChild.innerText.split(" "); 
    let email =detail[2] ;
  
    
     let name;
     let team;
     let countOfticket;
     let jsonObject;
	 document.getElementById("showInsideAgent").innerHTML = "";
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			   jsonObject = JSON.parse(xhr.responseText);
			   name = jsonObject.agentName;
			    team = jsonObject.agentteam;
				countOfticket  =  jsonObject.ticketCount ;
			console.log(name+"-"+team+"-"+email+"-"+countOfticket);
			   
			    document.getElementById("showInsideAgent").innerHTML += "<div class = "+"listOfDivInsideAgent"+"><p id="+"textNameInsideAgent"+">Name : "+name+"</p><p id="+"textemailInsideAgent"+">Email : "+email+"</p><p id="+"textTeamInsideAgent"+">team : "+team+"</p><p id="+"textInsideAgent"+">Count of ticket : "+countOfticket+"</p></div>" ;
		
		}
		
	}
    

   xhr.open("POST","InsideAgent");
   xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   xhr.send("agentEmail="+email);
   

}

function showNewAgent(){
	//This function will add the teams in the select tag.
	let xhr = new XMLHttpRequest();   
    document.getElementById("companyTicketPage").style="display:none";
    document.getElementById("departmentFlow").style="display:none";
    document.getElementById("companyAddTeamsForm").style="display:none";
    document.getElementById("viewDepartment").style="display:none";
    document.getElementById("companyAgentMainPage").style="display:none";
    document.getElementById("WarningMessageForAddAgent").style="display:none";
    	document.getElementById("insideTheTicket").style="display:none";
    document.getElementById("companyAddAgentForm").style="display:block";
    
    document.getElementById("agentTeamInputBox").options.length = 0;
    
    
    
xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
		jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
			let ele = document.createElement("option");
		    ele.value = jsonObject.teamName;
		    ele.innerText = jsonObject.teamName;
		    document.getElementById("agentTeamInputBox").appendChild(ele);
		
		}
		
	}
}
xhr.open("POST","AddDepartmentInAgentForm",true);
xhr.send();


    
   
}

function addAgentSubmitButton(){
    let name =document.getElementById("agentTextNameInputBox").value;
    let email =document.getElementById("agentTextEmailInputBox").value;
    //let password =document.getElementById("agentTextPasswordInputBox").value;
    let team = document.getElementById("agentTeamInputBox").value;
    
    let xhr = new XMLHttpRequest();
    
   let obj ={
	   "name":name,
	   "email":email,
	   "team":team
   };
   
   

   
        let regexEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

    if(name != "" && email != ""){
	
   if(email.match(regexEmail)){
	    xhr.onreadystatechange = function(){
			if(xhr.status == 200 && xhr.readyState == 4){
			//	 document.getElementById("companyAddAgentForm").style="display:none";
              //   document.getElementById("companyAgentMainPage").style="display:block";
              //var json = JSON.parse(xhr.responseText);
             
                 //document.getElementById("companyAgentList").innerHTML += "<div class="+"listOfAgent"+"><div class="+"listOfAgentLeft"+" onclick="+"showInsideAgent(this)"+"><p>"+json.agentName+"</p><p>Email - "+json.agentEmail+"</p></div></div>";
                 
                 window.alert("Invitation sent");
			}
		}
        
        
        
        xhr.open("POST","AddNewAgent");
    xhr.setRequestHeader("Content-Type","application/json");
    xhr.send(JSON.stringify(obj));
   }else{
	        document.getElementById("WarningMessageForAddAgent").style="display:block";
	        document.getElementById("WarningMessageForAddAgent").innerText="*enter the mail properly.";

   }
       
    }
    else{
			
     document.getElementById("WarningMessageForAddAgent").style="display:block";
     document.getElementById("WarningMessageForAddAgent").innerText=" *Fill all the input boxes.";
                                                             
        
      
    }
    
 
}
function showInsideTicket(element){
	let xhr = new XMLHttpRequest(); 
	let id;
	let json = null;
	 let status = null;
	 let priority = null;
	 let classification = null; 
	document.getElementById("companyTicketPage").style="display:none";
	document.getElementById("insideTheTicket").style="display:flex";
    document.getElementsByClassName("contentPageForInsideRight")[0].style = "display:block"
	document.getElementsByClassName("footerForInsideRight")[0].style = "display:block";
		document.getElementsByClassName("historyList")[0].style = "display:none";
	id =  element.firstChild.firstChild.innerText;
	
	xhr.onreadystatechange = function(){
		
		if(xhr.status == 200 && xhr.readyState == 4){
			 json = JSON.parse(xhr.responseText);
			//console.log(json);
       document.getElementsByClassName("contactInfoOwnerName")[0].innerText = json.ticketOwner;	
       document.getElementsByClassName("contactInfoOwnerMail")[0].innerText = json.ticketOwnerEmail;	
       status = json.ticketStatus;
     
	  
         document.getElementsByClassName("selectStatusForTheTicket")[0].value = status;
         if(status == "CLOSED"){
			 document.getElementsByClassName("CloseTicket")[0].innerText = "Open Ticket";
		 }else{
		 document.getElementsByClassName("CloseTicket")[0].innerText = "Close Ticket"; 
		 }
         //
	   if(json.ticketDate != null)
	   document.getElementById("dueDateInputBox").value = json.ticketDate;
	   priority = json.ticketPriority;
	   document.getElementsByClassName("selectPriorityForTheTicket")[0].value = priority;
	   classification = json.ticketClassification;   
      document.getElementsByClassName("selectClasificationForTheTicket")[0].value = classification;
      document.getElementsByClassName("ticketIdInsideTicket")[0].innerText = json.ticketId;
      document.getElementsByClassName("ticketNameInsideTicket")[0].innerText = json.ticketName;
     
       
         insideTicket2(id,json);
		}
	}
	
	
	 xhr.open("POST","TicketInformation");
   xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   xhr.send("id="+id);
}
//
function insideTicket2(id,jsonObject){
	
	let xhr = new XMLHttpRequest();
	let jsonObjectt = null;
	
	  document.getElementsByClassName("conversationContent")[0].innerHTML ="";

																																																																												
    xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4) {
			
			
			  let  jsonArr = JSON.parse(xhr.responseText);
			    for(let i = 0;i<jsonArr.length;i++){
					jsonObjectt = jsonArr[i];
					 let name = jsonObjectt.name.split("");
			    
          //	document.getElementsByClassName("conversationContent")[0].innerHTML ="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+name[0]+name[1]+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+jsonObjectt.name+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
			 if(jsonObjectt.who == "visitor"){
	document.getElementsByClassName("conversationContent")[0].innerHTML +="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+name[0]+name[1]+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+jsonObjectt.name+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
				}
				else{
	document.getElementsByClassName("conversationContent")[0].innerHTML +="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+"A"+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+"Agent"+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
				}
				}
			insideTicket3(id,jsonObject);
		}
	}
	
	
	
	xhr.open("POST","GetDescription");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("ticketId="+id);
}

function insideTicket3(id,json){
	let xhr = new XMLHttpRequest();
	
	
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			
		    let jsonArray = JSON.parse(xhr.responseText);
		  
		 for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
			let ele = document.createElement("option");
		    ele.value = jsonObject.AgentEmail;
		    ele.innerText = jsonObject.AgentName;
		    document.getElementsByClassName("selectAgentForTheTicket")[0].appendChild(ele);
		     
		}
		     document.getElementsByClassName("selectAgentForTheTicket")[0].value = json.ticketAgentEmail;
		}
	}
	
	
	xhr.open("POST","GetAgent",true);
	xhr.send();
}


function updateStatus(element){
	
	let id = document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
	let xhr = new XMLHttpRequest();
	xhr.open("POST","UpdateStatus");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id+"&value="+element.value);

	
}
//
function updatePriority(element){
	let id = document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
	let xhr = new XMLHttpRequest();
	let email = document.getElementsByClassName("selectAgentForTheTicket")[0].value;
	xhr.open("POST","UpdatePriority");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id+"&value="+element.value+"&email="+email);
	
}
//
function updateClassification(element){
	let id = document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
	let xhr = new XMLHttpRequest();
	xhr.open("POST","UpdateClassification");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id+"&value="+element.value);
}
//
function updateAssigndTo(element){
	
	let id = document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
	let xhr = new XMLHttpRequest();
	xhr.open("POST","UpdateAssignedTo");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id+"&value="+element.value);
}
//
function changeTheCloseTicket(element){
		let id = document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
	let xhr = new XMLHttpRequest();
	
	if(element.innerText == "Close Ticket"){
		document.getElementsByClassName("CloseTicket")[0].innerText = "Open Ticket";
	       document.getElementsByClassName("selectStatusForTheTicket")[0].value = "CLOSED";
	    xhr.open("POST","UpdateStatus");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id+"&value="+"CLOSED");
	}
	else{
				document.getElementsByClassName("CloseTicket")[0].innerText = "Close Ticket";
    document.getElementsByClassName("selectStatusForTheTicket")[0].value = "OPEN";
    xhr.open("POST","UpdateStatus");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id+"&value="+"OPEN");
	}
}
//
function submitButtonSetPassword(){
	let xhr = new XMLHttpRequest();
	let email = window.location.href.substring(window.location.href.indexOf("=")+1);
	let password = document.getElementById("name").value;
	
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			
          window.location.href = "AgentSignIn.html";
		}
	}
	
		
		
		xhr.open("POST","setPasswordForAgent");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("email="+email+"&password="+password);
	
	
	
}
function showHistory(){
	let xhr = new XMLHttpRequest();
	let id=document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
	document.getElementsByClassName("contentPageForInsideRight")[0].style = "display:none"
	document.getElementsByClassName("footerForInsideRight")[0].style = "display:none";
		document.getElementsByClassName("historyList")[0].style = "display:block";
		document.getElementsByClassName("historyList")[0].innerHTML = "";
		xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4) {
			  let jsonArr = JSON.parse(xhr.responseText);
			    for(let i = 0;i<jsonArr.length;i++){
					jsonObjectt = jsonArr[i];
					//Want to create a div and append in the history div.
					document.getElementsByClassName("historyList")[0].innerHTML+="<div id="+"historyDiv"+"><h4>"+jsonObjectt.ticketHistory+"</h4><p id="+"historyTime"+">"+jsonObjectt.ticketTime+"</p></div>";
			    
				}
		}
	}
		
	xhr.open("POST","ShowHistory");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("id="+id);
		
		
}

function showConversation(){
	document.getElementsByClassName("contentPageForInsideRight")[0].style = "display:block"
	document.getElementsByClassName("footerForInsideRight")[0].style = "display:block";
		document.getElementsByClassName("historyList")[0].style = "display:none";
}



















