//this will only work with jquery plugin for cookie
//jquery.cookie.js from https://github.com/carhartl/jquery-cookie

//Add image to panier
$('.addPanier').on('click', function(){
	var imgSrc = $(this + '>img').attr('src');
	var imgName = $(this + '>img').attr('id');
	//creating the cookie that expires in one day
	$.cookie(imgName, imgSrc, { expires: 1 });
});


//Delete all img cookies
$('#delteAllImgCookies').on('click', function(){
	var cookies = $.cookie();
	//TODO: check if this works
	for(var cookie in cookies) {
	   var wasDeleted = $.removeCookie(cookie);
	   console.log('Was deleted: ' + wasDeleted);
	}
});

//Delete specific img cookie
$('.deleteImgCookie').on('click', function(){
	var wasDeleted = $.removeCookie($(this).attr('id'));
	console.log('Was deleted: ' + wasDeleted);
});

//Get all images and add them to the panier liste
$(document).ready(function(){
	$.each($.cookie(), function(cookie_name, cookie_url){
		var img = $('<img id="' + cookie_name +'">');
		img.attr('src', cookie_url);
		img.appendTo('#imgPanierContainer');
	});
});
