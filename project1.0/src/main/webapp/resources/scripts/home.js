function home(){
	$("#content").load("homeContent");
};

function chiSiamo(){
	$("#content").load("chiSiamoContent");					
};

function products(){
	$("#content").load("productsContent");
};

function services(){
	$("#content").load("servicesContent");
};

function login(){
	$("#content").load("loginContent");
};


$(function() {
	home();   				

	$("#homelink").click(function() {
		home();					   		
	});

	$("#chisiamolink").click(function(){
		chiSiamo();	
	});
	
	$("#prodottilink").click(function(){
		products();
	});
	
	$("#servizilink").click(function(){
		services();
	});
	
	$("#loginlink").click(function(){
		login();
	});
});