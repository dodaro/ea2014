function admin(){
	$("#content").load("logContent");
};

$(function(){
	$("#myPageLink").click(function(){
		admin();	
	});
});

