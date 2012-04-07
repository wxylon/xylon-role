var arr=[5,5,5,6];
var i=0,is;
//(function(){
//    if(typeof (is=arr.pop())=='number'){
//        i += is;
//        //返回正被执行的 Function 对象，也就是所指定的 Function 对象的正文
//        return arguments.callee();
//    }else{
//        alert(i);
//    }
//})();



//function argcall(t){
//	if(typeof(t) == 'number' && t < arr.length){
//		i += arr[t];
//		return arguments.callee(++t);
//	}else{
//		alert(i);
//	}
//}
//argcall(0);




//定义一个数组变量：
//var a=new Array();
//a[0] = 1;
//a[1] = 'dfdfd';
//alert(a);
//定义时指定大小：
//var b=new Array(20);

//定义时赋初值：
//var c=new Array('abc', 'def', 'ghi', 'opq');


//var d= [[1,2],[3,4]];
//alert(d);


//var  e  =  new  Array([1,2,3],[4,5,6],[7,8,9,10]); 
//alert(e);


var   f   =   new   Array(new   Array("1","1111"), new   Array("2222"),   new   Array("3","3333"),  new   Array("4","4444"));       
//alert(f[0][1]);


//var  e  =  new  Array([[-1,0],[1,2,3],4,5,6]); 
//alert(e[0][0][1]);

//合并2个数组
//alert(e.concat(f));
//指定分割库，将数组合并为字符串
//alert(f.join("."));

//document.write("<br />");
//document.write(e.join());
//document.write("<br />");
//document.write(e.join("."));


//var  arr  =  new  Array("George", "John", "Thomas"); 
//document.write("<br />");
//document.write(arr.join());
//document.write("<br />");
//document.write(arr.join("."));
//
//var  g  =  new  Array("1", "2", "3"); 
//document.write("<br />");
//document.write(g.join());
//document.write("<br />");
//document.write(g.join("."));
//
//
//var  g  =  new  Array(1, 2, 3); 
//document.write("<br />");
//document.write(g.join());
//document.write("<br />");
//document.write(g.join("."));
//
//
//var  g  =  new  Array([-1,0],[1,2]); 
//document.write("<br />");
//document.write(g.join());
//document.write("<br />");
//document.write(g.join("."));



var h = new Array(1, 2, 4, 255, 3, 3, 3, 2, 1);
var i  = new Array(5, 6, 7, 8);
var j = h.concat(i);
//alert("h = " + h +"; i = " + i + "; j = " + j);
//删除最后一个
//h.pop();
//末尾追加
//h.push(5, 6);
//返回一个元素顺序被反转的 Array 对象。 
//h.reverse();
//移除数组中的第一个元素并返回该元素。
//alert(h.shift());
//将指定的元素插入数组开始位置并返回该数组。
//alert("h = " + h +"; h.unshift([10, 11]) = " + h.unshift([10, 11]) + "; h = " + h);
//返回一个数组的一段。
//var ja = h.slice(0, 2);
//alert(ja);
function compaor(one, two){
	if(one > two){
		return 1;
	}else if(one < two){
		return -1;
	}else{
		return 0;
	}
}
//如果这个参数被省略，那么元素将按照 ASCII 字符顺序进行升序排列。
//alert(h.sort(compaor));

//alert(h.splice(0, 1, [0,0,0,0,0]) + "--->" + h.sort(compaor));
//alert(h.valueOf());

var jb = 255;
alert(jb.toString(2));



