//this will only work with jquery plugin for cookie
//jquery.cookie.js from https://github.com/carhartl/jquery-cookie
$(document).ready(function(){
	//Add image to panier
	$('.addPanier').on('click', function(){
		var imgSrc = $(this + '>img').attr('src');
		var imgName = $(this + '>img').attr('id');
		//creating the cookie that expires in one day
		$.cookie(imgName, imgSrc, { expires: 1 });
		updateItemCount(1);
	});
	//Delete all img cookies
	$('#deleteAllImgCookies').on('click', function(){
		var cookies = $.cookie();
		//TODO: check if this works
		for(var cookie in cookies) {
		   var wasDeleted = $.removeCookie(cookie);
		   console.log('Was deleted: ' + wasDeleted);
		}
		updateItemCount(-2);
		//Emptying the panier
		$('#panier').empty();
	});

	//Delete specific img cookie
	$('.deleteImgCookie').on('click', function(){
		var imgId = $(this).attr('id');
		var wasDeleted = $.removeCookie(imgId);
		console.log('Was deleted: ' + wasDeleted);
		//Removing the img in panier
		$('#img_in_panier_' + imgId).remove();
		updateItemCount(-1);
	});

	//Get all images and add them to the panier liste

	if($('#imgPanierContainer').length()){
		$.each($.cookie(), function(cookie_name, cookie_url){
			var img = $('<img id="' + cookie_name +'">');
			img.attr('src', cookie_url);
			img.appendTo('#imgPanierContainer');
		});
	}
	//===========add item count to element(s)==============
	//doesn't matter if these elements exist or not
	var msg = "Vous avez " + getItemCount() + " images dans votre panier";
	$('#itemCount').text(msg);
	$('.itemCount').text(msg);
});

function updateItemCount(n){
	var count = $.cooke("itemCount") || 0;
	if(n == -2){
		count = 0;
	}else{
		count += n;
	}
	$.cookie("itemCount", count, { expires: 1 });
}
function getItemCount(){
	//returns 0 if it doesn't exist
	return $.cookie("itemCount") || 0;
}
