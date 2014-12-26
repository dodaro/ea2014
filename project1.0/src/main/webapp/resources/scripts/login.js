function passRemember(){
	$("#content").load("passRemember");
};

function signIn(){
	$("#content").load("signIn");					
};


$(function() {

	$("#passRememberLink").click(function() {
		passRemember();					   		
	});
	
	$("#signInLink").click(function(){
		signIn();
	});
;
});