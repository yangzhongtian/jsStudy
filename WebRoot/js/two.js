window.onload=function(){
//	var ad=document.getElementsByClassName('buy first');  //document.getElementsByClassName('buy')
//	console.log(ad);
//	var a = document.getElementById('purchases');
//	var b = a.getElementsByClassName('buy');
//		console.log(b)	 
//	for(var i=0; i<b.length;i++){
//		console.info(b[i])
//	}
//	for(var i in b){
//		console.info(i)
//	}
//	console.info(Date())
//	var date = {a:'',b:'kdsl',c:'k'}
//	for(var  i in Date()){
//		console.log(i)
//	}
	
	var  adocument =document.getElementsByTagName('p')
//	adocument[1].setAttribute('title','tianjia');
	adocument[1].title ="tianjia2"
	for(var i=0;i<adocument.length;i++){
		var title =adocument[i].getAttribute('title');
		if(title){
			alert(title)
		}
	}
}