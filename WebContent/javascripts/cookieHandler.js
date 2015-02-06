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
			if(! $.cookie(imgId)){
				//adding it as a cookie that expires in one day
				$.cookie(imgId, imgSrc, { expires: 1 });
				updatePanier(imgId, imgSrc);
				showCount();
			}
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
		$(document).on('click','.deleteImgCookie', function(){
			var imgId = $(this).parent().children('img').prop('id');
			var wasDeleted = $.removeCookie(imgId.split('_')[1]);
			console.log('Was deleted: ' + wasDeleted);
			//Removing the img in panier
			$(this).parent().remove();
			showCount();
		});
		$('#download').on('click', function(){
			download();
		});
		//initial load to fill the panier
		loadPanier();
	}else{
		alert('Vous devez autoriser les cookies pour que le panier fonctionne');
	}
	
});

function showCount(){
	$('.itemCount').text(getItemCount());	
}
function getItemCount(){
	//returns 0 if it doesn't exist
	return Object.keys($.cookie()).length;
}
function updatePanier(id, src){
	var img = $('<img id="panier_' + id + '" class="panierImg">');
	var div = $('<div class="img_in_panier"></div>');
	//update img to remove
	var del = $('<button class="deleteImgCookie"><span class="lsf-icon" title="remove"></span></button>');
	$(img).attr('src', src);
	$([$(img), $(del)]).appendTo($(div));
	$(div).appendTo($('#panierImgs'));
}
function loadPanier(){
	//checking to see if it exists
	//looping through all the cookies
	$.each($.cookie(), function(id, src){
		updatePanier(id, src);
	});
	showCount();
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

function download(){
	var list = [];
	$.each($.cookie(), function(id, src){
		list.push(src);
	});
	try{
		var send = JSON.stringify(list);
		$.fileDownload('/download/?string=' + send)
		    .done(function () { alert('File download a success!'); })
		    .fail(function () { alert('File download failed!'); });
	}catch(e){
		console.log("parsing error: " + e);
	}
}
