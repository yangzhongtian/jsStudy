//alert('ten three chapter');
window.onload=function(){
	addFun();
	
}
function addFun(){
	var items=document.getElementsByTagName('a');
	var preview = document.getElementById('preview');
	
	preview.style.position='absolute';
	preview.style.left='0px';
	preview.style.top='0px';
	
	items[0].onmouseover=function(){
		movep('preview',-100,0,10);
	}
	items[1].onmouseover=function(){
		movep('preview',-200,0,10);
	}
	items[2].onmouseover=function(){
		movep('preview',-300,0,10);
	}
	
}
function movep(id ,maxX,maxY,time){
	var p1 =document.getElementById(id);
	console.info(p1);
	var elm =document.getElementById(id);
	if(elm.movement){
		clearTimeout(elm.movement);
	}
	y=parseInt(p1.style.top);
	x=parseInt( p1.style.left);
	
	if(x==maxX&&y==maxY){
		return true;
	}
	if(x<maxX){
		x++;
	}
	if(y>maxY){
		y--;
	}
	if(x>maxX){
		x--;
	}
	if(y<maxY){
		y++;
	}
	
	
	
	p1.style.top=y+'px';
	
	p1.style.left=x+'px';
	
	elm.movement=setTimeout("movep('"+id +"',"+maxX+","+maxY+","+time+")",time); 
//"movep('"+id+"',"+maxX+","+maxY+","+time+","+flagx+","+flagy+")"
}