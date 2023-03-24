/**
 * 
 */
function logInSubmitButton(){
	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;
	//console.log(email+"--"+password);
	 let xhr = new XMLHttpRequest();
	if(email != "" && password != ""){
		
		 xhr.onreadystatechange = function(){
			  if(xhr.readyState == 4 && xhr.status == 200 ){
				  if(xhr.responseText == 200){
	    window.location.href = "AgentHomePage.html";
	     
				  }
				  else{
	document.getElementById("invalidAgent").innerText = "*Invalid email or password";
				  }
			  }
		  }
		
		  xhr.open("POST","AgentSignIn");
		  xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
          xhr.send("agentEmail="+email+"&agentPassword="+password);
		}
}
 function logOut(){
	 let xhr = new XMLHttpRequest();
	 
	  xhr.onreadystatechange = function(){
		  if(xhr.status == 200 && xhr.readyState == 4){
			   window.location.href = "AgentSignIn.html";
		  }
	  }
	 
	 
	 
	 
	 xhr.open("POST","AgentLogOut",true);
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
	
	
	xhr.open("POST","SelectTicketForAgent");
	//xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.send();
	
	
}
//
function showTickets(){
     document.getElementById("insideTheTicket").style="display:none";
     document.getElementById("companyTicketPage").style="display:block";
     document.getElementById("listOfTicket").innerHTML = "";
     document.getElementById('selectTicket').getElementsByTagName('option')[0].selected = 'selected';
     tickets();
    
}


function show(ar){
	if(ar == "open"){
		agentShowOpenTicket();
	}
	else if(ar == "onHold"){
		agentShowOnholdTicket();
	}
	else if(ar == "escalated"){
		agentShowEscalatedTicket();
	}
	else if(ar == "closed"){
		agentShowClosedTicket();
	}
	else if(ar == "all"){
	tickets();	
	}
}
//

function agentShowOpenTicket(){
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
	
	
	xhr.open("POST","SelectAgentOpenTicket",true);
	xhr.send();
	 
}
function agentShowOnholdTicket(){
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
	
	
	xhr.open("POST","SelectAgentOnholdTicket",true);
	xhr.send();
}
 function agentShowEscalatedTicket(){
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
	
	
	xhr.open("POST","SelectAgentEscalatedTicket",true);
	xhr.send();
 }
 function agentShowClosedTicket(){
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
	
	
	xhr.open("POST","SelectAgentClosedTickets",true);
	xhr.send();
 }
 //
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
	   console.log(priority);
	 document.getElementsByClassName("selectPriorityForTheTicket")[0].value = priority;

	  
	   classification = json.ticketClassification;
     document.getElementsByClassName("selectClasificationForTheTicket")[0].value = classification;

	  /* if(classification == "NONE"){
		  document.getElementsByClassName("selectClasificationForTheTicket")[0].value = "none";
	   }
	   else if(classification == "QUESTION"){
		   document.getElementsByClassName("selectClasificationForTheTicket")[0].value = "question";
	   }
	   else if(classification == "PROBLEMS"){
		    document.getElementsByClassName("selectClasificationForTheTicket")[0].value = "probleams";
	   }
	   else if(classification == "FEATURES"){
		   document.getElementsByClassName("selectClasificationForTheTicket")[0].value = "features";
	   }*/
      
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
			
			
			    jsonArr = JSON.parse(xhr.responseText);
			    for(let i=0;i<jsonArr.length;i++){
					jsonObjectt = jsonArr[i];
			    let name = jsonObjectt.name.split("");
          //	document.getElementsByClassName("conversationContent")[0].innerHTML ="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+name[0]+name[1]+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+jsonObjectt.name+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
			
			 if(jsonObjectt.who == "visitor"){
	document.getElementsByClassName("conversationContent")[0].innerHTML +="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+name[0]+name[1]+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+jsonObjectt.name+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
	
				}
				else{
	document.getElementsByClassName("conversationContent")[0].innerHTML +="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+"A"+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+"Agent"+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
				}
			
			
			
			
      document.getElementById("selectAgentForTheTicket").innerText = jsonObject.ticketAgentEmail;
		}
		}
	}
	
	
	
	xhr.open("POST","GetDescription");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("ticketId="+id);
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
	let email = selectAgentForTheTicket.innerText;
	let xhr = new XMLHttpRequest();
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

function replyBox(){
	document.getElementsByClassName("conversationContent")[0].innerHTML = "";
	document.getElementsByClassName("conversationContent")[0].innerHTML ="<textarea id="+"replayBoxContent"+"></textarea>";
	document.getElementsByClassName("conversationContent")[0].innerHTML += "<div id="+"SubmitbuttonForTheReply"+" onclick="+"sendMail()"+">Send</div>";

}

function sendMail(){
	//	console.log(document.getElementById("replayBoxContent").value);
	     let xhr = new XMLHttpRequest();
	     let id = document.getElementsByClassName("ticketIdInsideTicket")[0].innerText;
		if(document.getElementById("replayBoxContent").value != ""){
			
			xhr.onreadystatechange = function(){
			if(xhr.status == 200 && xhr.readyState == 4){
				insideTicketDesc(id);
			}	
			}
			
			xhr.open("POST","AddReply");
	        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	        xhr.send("ticketId="+id+"&desc="+document.getElementById("replayBoxContent").value);
		}


	
}
/*function descList(id){
	document.getElementsByClassName("conversationContent")[0].innerHTML = "";
	
}*/
function insideTicketDesc(id){
let xhr = new XMLHttpRequest();
	let jsonObjectt = null;
	
	  document.getElementsByClassName("conversationContent")[0].innerHTML ="";

																																																																												
    xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4) {
			
			
			    jsonArr = JSON.parse(xhr.responseText);
			    for(let i=0;i<jsonArr.length;i++){
					jsonObjectt = jsonArr[i];
			    let name = jsonObjectt.name.split("");
			    if(jsonObjectt.who == "visitor"){
	document.getElementsByClassName("conversationContent")[0].innerHTML +="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+name[0]+name[1]+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+jsonObjectt.name+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
	
				}
				else{
	document.getElementsByClassName("conversationContent")[0].innerHTML +="<div class="+"conversationDivList"+"><div class="+"insideconversationDiv1"+"><div class="+"insideConversationCircle"+">"+"A"+"</div><div class = "+"insideConversationRight"+"><h4 class="+"insideConversationRightName"+">"+"Agent"+"</h4><p class="+"insideConversationRightTime"+">"+jsonObjectt.time+"</p></div></div><div class="+"insideconversationDiv2"+">"+jsonObjectt.desp+"</div> </div>";
				}
			
     
		}
		}
	}
	
	
	
	xhr.open("POST","GetDescription");
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xhr.send("ticketId="+id);
}
//Want to write the show history function.
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


		  
	