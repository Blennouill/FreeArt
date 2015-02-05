/*

	For this to work correctly the structure of the page has to be of the following:
	
	#panier
		#itemCount
		#imgPanierContainer
			#itemCount
			#panierImgs
				.img_in_panier
					<img in small>
					.deleteImgCookie
				//repeat
			#deleteAllImgCookies

	.addPanier
		<img>

	updateCount(int) //=> 0 sets the count to 0, -1 removes one from count, 1 adds 1 to count
*/

$(document).ready(function(){
	if(are_cookies_enabled()){
		//an image has to be  a child of this container
		$('.addPanier').on('click', function(e){
			e.preventDefault();
			var img = $(this).parent().parent().children("img")
			var imgSrc = $(img).prop('src');
			var imgId = $(img).prop('id');

			//adding it as a cookie that expires in one day
			$.cookie(imgId, imgSrc, { expires: 1 });
			updatePanier(imgId, imgSrc);
		});
		//delete all cookies and empty panier
		$('#deleteAllImgCookies').on('click', function(){
			var cookies = $.cookie();
			//looping through all the cookies and deleting them
			for(var cookie in cookies){
				var wasDeleted = $.removeCookie(cookie);
				console.log('Was deleted: ' + wasDeleted);
			}
			$('#panierImgs').empty();
			showCount();
		});
		$('.deleteImgCookie').on('click', function(){
			var imgId = $(this).parent().children('img').prop('id');
			var wasDeleted = $.removeCookie(imgId.split('_')[1]);
			console.log('Was deleted: ' + wasDeleted);
			//Removing the img in panier
			$(this).parent().remove();
			showCount();
		});
		//initial load to fill the panier
		loadPanier();
	}else{
		alert('Vous devez autoriser les cookies pour que le panier fonctionne');
		$('#itemCount').text('Autoriser les cookies pour ajouter des images aux panier !');
	}
	
});

function showCount(){
	var msg = "Vous avez " + getItemCount() + " images dans votre panier";
	$('#itemCount').text(msg);	
}
function getItemCount(){
	//returns 0 if it doesn't exist
	return $.cookie().length || 0;
}
function updatePanier(id, src){
	var img = $('<img id="panier_' + id + '" class="panierImg">');
	var div = $('<div class="img_in_panier"></div>');
	//update img to remove
	var del = $('<a href="#" class="deleteImgCookie"><span class="lsf-icon" title="remove"></span></a>');
	$(img).attr('src', src);
	$([$(img), $(del)]).appendTo($(div));
	$(div).appendTo($('#panierImgs'));
}
function loadPanier(){
	//checking to see if it exists
	if($('#imgPanierContainer').length){
		//looping through all the cookies
		$.each($.cookie(), function(id, src){
			updatePanier(id, src);
		});
		showCount();
	}
}
function are_cookies_enabled()
{
    var cookieEnabled = (navigator.cookieEnabled) ? true : false;

    if (typeof navigator.cookieEnabled == "undefined" && !cookieEnabled)
    { 
        document.cookie="testcookie";
        cookieEnabled = (document.cookie.indexOf("testcookie") != -1) ? true : false;
    }
    return (cookieEnabled);
}
