window.onload=function(){
	var headers = document.getElementsByTagName('h1');
	for(var  i=0;i<headers.length;i++){
		
		console.log(headers.nextSibling);
		nextSiblings(headers[i]).style.fontSize='20px';
		nextSiblings(headers[i]).style.fontWeight='bold';
		nextSiblings(headers[i]).style.color='lightblue';
		
	}
	
	function nextSiblings(node){
		if(node.nextSibling.nodeType===1){
			return node.nextSibling;
		}
		if(node.nextSibling.nextSibling){
			return node.nextSibling.nextSibling;
		}
		return null;
	}
}