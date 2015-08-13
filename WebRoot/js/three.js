//alert('success')

function showPic(pic){
	
	var sourse = pic.getAttribute('href');
	var title = pic.getAttribute('title')
	picBed = document.getElementsByTagName('img');
	picBed[0].setAttribute('src',sourse);
	console.info(document.getElementById('description').childNodes[0].nodeValue)
	console.info(document.getElementById('description').lastChild.nodeValue=title)
}
window.onload=function(){
var items =document.getElementsByTagName('body')[0].childNodes;
console.log(items);
};