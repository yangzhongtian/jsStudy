
window.onload=function(){
	p1x =1 ;
p1y=1 ;
p2x =1 ;
p2y=1 ;
p3x =1 ;
p3y=1 ;
	movep('p1',300,200,30,p1x,p1y);
	
	movep('p2',600,200,80,p2x,p2y);
	
	movep('p3',600,200,40,p3x,p3y);
	
}
function movep(id ,maxX,maxY,time,flagx,flagy){
	var p1 =document.getElementById(id);
	console.info(p1);
	y=parseInt(p1.style.top);
	x=parseInt( p1.style.left);
	if(x>maxX){
		flagx=-1;
	}
	if(y>maxY){
		flagy=-1;
	}
	if(x<0){
		flagx=1;
	}
	if(y<0){
		flagy=1;
	}
	
	x =x+flagx;
	y =y+flagy;
	
	p1.style.top=y+'px';
	
	p1.style.left=x+'px';
	
	var flush=setTimeout("movep('"+id +"',"+maxX+","+maxY+","+time+","+flagx+","+flagy+")",time); 
//"movep('"+id+"',"+maxX+","+maxY+","+time+","+flagx+","+flagy+")"
}