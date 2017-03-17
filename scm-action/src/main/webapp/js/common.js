function valueToText(str,value){
	str = str.substring(1, str.length-1);//把前后连个大括号去掉
	var array = str.split(",");
	for(var i = 0 ; i < array.length ; i++){
		//alert(array[i]); //3=普通供应商                   2=二级供应商                    1=一级供应商
		str2 = array[i];
		var array2 = str2.split("=");
		if($.trim(value)==$.trim(array2[0])){
			return array2[1];
		}
	}
}