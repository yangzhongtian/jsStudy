//alert('eight hello')
window.onload=function(){
//	var ones = document.getElementById('tes');
//	console.info(ones);
//	console.info(ones.lastChild.firstChild.nodeValue)
	var abrr = document.getElementsByTagName('abbr');
	var defs = new Array();
	if(abrr.length<1){
		return false;
	}else{
		for(var i=0;i<abrr.length;i++){
			var title= abrr[i].getAttribute('title');
			var key = abrr[i].firstChild.nodeValue;
			defs[key] = title;
		}
		var dl = document.createElement('dl')
		for(key in defs){
			var defines = defs[key];
			 var dt = document.createElement("dt");
			 var ddtext = document.createTextNode(key);
			 dt.appendChild(ddtext);
			 var dd = document.createElement('dd')
			 var dltext = document.createTextNode(defines);
			 dd.appendChild(dltext);
			 dl.appendChild(dt);
			 dl.appendChild(dd)
		}
		header2 = document.createElement('h2');
		header2.style.color='green';
		texthead =document.createTextNode('Abbrestive');
		header2.appendChild(texthead);
		document.body.appendChild(header2)
		document.body.appendChild(dl);
	}
}