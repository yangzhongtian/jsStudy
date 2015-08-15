//var c=0;
// test2 =function (){
//		
// this.test3=	function (){
//			c++;
//			document.write(c+",");
//			
//	
//	}	
//		
//}
//var a = new test2()
// function test(){
// 	alert('hello');
//	setInterval(a.test3,200);
//}
window.onload=function(){
	var p1 =document.getElementById('p1');
	p1.style.position ='absolute';
	p1.style.top=0;
	p1.style.left =0;
	movep();
}
var flagx =1;
var flagy=1
function movep(){
	var p1 =document.getElementById('p1');
	y=parseInt(p1.style.top);
	x=parseInt( p1.style.left);
	if(x>250){
		flagx=-1;
	}
	if(y>100){
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
	
	var flush=setTimeout('movep()',50);
}