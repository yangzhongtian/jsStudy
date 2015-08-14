//alert('nineThree Chapter')Ext
window.onload=function(){
	var tables = document.getElementsByTagName('table');
	for(var i =0;i<tables.length;i++){
		//alert('hello');
		var  trs =tables[i].getElementsByTagName('tr');
		console.info(trs)
		for (var z = 0; z < trs.length; z++) {
			trs[z].id ='normal';
			trs[z].onmouseover =function(){
				//this.style.fontSize='20px';
				//this.style.backgroundColor='blue';
				this.style.fontWeight='bold'
				this.setAttribute('id','ids')
			}
			trs[z].onmouseout=function(){
				//this.style.fontSize='15px';
				//this.style.backgroundColor='green';
				this.style.fontWeight='normal',
				this.setAttribute('id','normal')
			}
		}
	}
	
}