function insertAfter(newNode,targetNodes){
	if(targetNodes.parentNode.lastNodes===targetNodes){
		targetNodes.parentNode.appendChild(newNode)
	}else{		
		targetNodes.parentNode.insertBefore(newNode, targetNodes.nextSibling);
	}
}
window.onload= function(){
	var photos = document.createElement("IMG");

	photos.setAttribute("src","");
	photos.setAttribute("alt",'请选择要显示的图片');
	photos.setAttribute("width","500px");
	photos.setAttribute("height","300px");
	photos.setAttribute('id','pho')
	
	document.body.appendChild(photos);
	var description = document.createElement('p');
	description.setAttribute('id',"description");
	var text1 = document.createTextNode("图片描述");
	description.appendChild(text1);
	insertAfter(description,photos);
	
	var items =document.getElementsByTagName("a");
	for(var i=0;i<items.length;i++){
		items[i].onclick=function(){
			var href = this.href;
			document.getElementById('pho').setAttribute('src', href);
			//document.getElementById("description").childNodes[0].nodeValue=this.title;
			document.getElementById("description").firstChild.nodeValue=this.title;
			return false;
		}
	}
}

