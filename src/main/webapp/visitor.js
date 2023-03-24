
/**
 * 
 */
function showdetail(element){
	 document.getElementById("inside_visitor_complain_box_2_1").style="display:flex";
    element.style.display="none";
    let showdiv=document.getElementById("animate_div");
    showdiv.style.display="block";
    let insidediv=document.getElementById("visitor_complain_box");
    insidediv.style.transform="translateY(0px)";
    
    }
    
    function showHelp(){
        document.getElementById("animate_div").style.display="none";
           document.getElementById("logoFooter").style="display:none";
           document.getElementById("brandName").style="display:block";
           document.getElementById("send_button").style="display:block";
        let showdiv=document.getElementById("help_box");
        showdiv.style.display="grid";
    
        document.getElementById("inside_visitor_complain_box_2_2").style="display:none";
        document.getElementById("inputName").value="";
         document.getElementById("inputMail").value="";
          document.getElementById("description_area").value="";
           document.getElementById("warning").innerText="";
    }
    
    function ticketCheck(){
        let name = document.getElementById("inputName").value;
        let email = document.getElementById("inputMail").value;
        let desc = document.getElementById("description_area").value;
        let xhr = new XMLHttpRequest();
        let regexEmail = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
         if((name != "")&&(email != "") && (desc!="")){
             if(email.match(regexEmail)){
                  //window.alert("sent successfully");
                  xhr.onreadystatechange = function(){
                      if(xhr.readyState == 4 && xhr.status == 200){
                           document.getElementById("inside_visitor_complain_box_2_1").style="display:none";
                           document.getElementById("inside_visitor_complain_box_2_2").style="display:block";
                           document.getElementById("brandName").style="display:none";
                           document.getElementById("send_button").style="display:none";
                            document.getElementById("logoFooter").style="display:block";
                           

                     
                      }
                  }
                  
                  
                  
                  xhr.open("POST","GenerateATicket");
                   xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                  // console.log("Desc = "+desc);
                  xhr.send("name="+name+"&email="+email+"&desc="+desc);
                  
                  
             }
             else{
                  document.getElementById("warning").innerText="*enter the mail properly.";
             }
            
             
         }
         else{
             document.getElementById("warning").innerText="*Fill all the inputs.";
         }
    
    }
    function loadDept(){
		let xhr = new XMLHttpRequest();
		//Want to hit the servlet a d add all the dept in tha select tag
		
		xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
		jsonArray = JSON.parse(xhr.responseText);
		for(let i=0;i<jsonArray.length;i++){
			jsonObject = jsonArray[i];
			let ele = document.createElement("option");
		    ele.value = jsonObject.teamName;
		    ele.innerText = jsonObject.teamName;
		    document.getElementById("departmentSelectTag").appendChild(ele);
		
		}
		
	}
}
		
		
		
		  xhr.open("POST","AddDepartmentInAgentForm"); 
          xhr.send();
	}
	function SubmitForTheClientportel(){
		let xhr = new XMLHttpRequest();
		let dept = document.getElementById("departmentSelectTag").value;
		let name =document.getElementById("name").value ;
		let email = document.getElementById("email").value;
		let subject = document.getElementById("subject").value;
		let desp =document.getElementById("desc").value ;
		let classification = document.getElementById("classification").value ; 
		  let priority = "NONE";
		  if(classification == "problems"){
			priority = document.getElementById("priority").value;  
			}
		if(name != "" && email !="" && subject != "" && desp != "") {
		
		document.getElementById("name").value = "";
		document.getElementById("email").value = "";
		document.getElementById("subject").value = "";
		document.getElementById("desc").value = "";
		 
		window.alert("Ticket Added");	
		
		
		
		
		xhr.open("POST","GenerateATicketForClientPortel");
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xhr.send("name="+name+"&email="+email+"&desc="+desp+"&dept="+dept+"&subject="+subject+"&classification="+classification+"&priority="+priority);
        
        
		
		}
		else{
			window.alert("Fill all the input box.");
		}
		
		
		
	}
//
function showPriority(element){
	if(element.value == "problems"){
		document.getElementById("input7").style="display:block";
	}
	else{
				document.getElementById("input7").style="display:none";
	}
}