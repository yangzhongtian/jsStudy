window.onload= function(){
	var photos = document.createElement("IMG");

	photos.setAttribute("src","");
	photos.setAttribute("alt",'请选择要显示的图片');
	photos.setAttribute("width","500px");
	photos.setAttribute("height","300px");
	
	document.body.appendChild(photos);
	var description = document.createElement('p')
	description.setAttribute('id',"description");
	var text1 = document.createTextNode("图片描述");
	photos.parentNode.insertBefore(description,photos);
}

function insertAfter(){
	
}