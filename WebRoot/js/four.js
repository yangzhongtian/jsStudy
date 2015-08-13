//function popWin(winUrl){
//	window.open(winUrl,'百度','width:300,height:300');
//	
//}
//window.onload= function(){
//	//window.open('http://www.baidu.com','百度','width:300,height:300');
//	var pops = document.getElementsByClassName('popWin');
//	for(var i =0;i<pops.length;i++){
//		pops[i].onmouseover=function tes(){
//			popWin(this.href);
//			return false;
//		}
//		
//	}
//	
//}

//if(!document.getElementById|| !document.getElementsByName) return false;

window.onload = function(){
	var sel = document.getElementsByTagName('a');
	for(var i =0;i<sel.length;i++){
		sel[i].onclick=function(){
			console.info(this);
			document.getElementsByTagName('img')[4].setAttribute('src',this.href)
			return false;
		}
		//sel[i].onkeyup = sel[i].onclick;
	}

}
