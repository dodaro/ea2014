$(function(){
	
	alert("start");
	
	var utype = ' ${role} ';
	
		if(utype == "ADMIN"){
			$("#divmenu").append('resources/template/adminMenu.html');
			alert(utype);
		}else{
			alert(utype);
		}
	});