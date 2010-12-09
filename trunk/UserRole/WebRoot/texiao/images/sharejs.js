var isIe = window.attachEvent ? true : false;
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr;
  for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++){
	  x.src=x.oSrc;
  }
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

function setCategoryEnsureVisible(oDiv, sType, isChange){
	if(sType == 'In'){
		if(isChange != 1) document.images['IMG_TOP_CATEGORY_MENU'].src="http://image.babosarang.co.kr/v2/topmenu/navvy/navi_r.gif";
		document.getElementById("IDS_TOP_CATEGORY_MENU").style.display = "block";
	}else{
		if(isChange != 1) document.images['IMG_TOP_CATEGORY_MENU'].src="http://image.babosarang.co.kr/v2/topmenu/navvy/navi.gif";
		document.getElementById("IDS_TOP_CATEGORY_MENU").style.display = "none";
	}
}

function swapLayer(sById1, sById2){
	var div1	= document.getElementById(sById1);
	var div2	= document.getElementById(sById2);
	if(div1 == null || div2 == null) return;
	if(div1.style.display == 'none'){
		div1.style.display = "block";
		div2.style.display = "none";
	}else{
		div1.style.display = "none";
		div2.style.display = "block";
	}
}
function swapImageLayerTrans(oImg, sSrc, sById){
	var objLayer = document.getElementById(sById);
	if(window.pickImg != null || window.pickLayer != null){
		if(window.pickImg ==oImg || objLayer == window.pickLayer) return;
		if( pickImg != null) if( pickImg.getAttribute('xwzAlreadySrc') != null) pickImg.src = pickImg.getAttribute('xwzAlreadySrc');
		if( pickLayer !=null) pickLayer.style.display = 'none';
	}

	if( oImg.getAttribute('xwzAlreadySrc') == null) oImg.setAttribute('xwzAlreadySrc', oImg.src);
	oImg.src = sSrc;
	objLayer.style.display = '';
	pickLayer = objLayer;	
	pickImg = oImg;
}

/* ================================================
마우스 Over 또는 Out 시 이미지 변경 함수 
oImg = 대상 이미지 객체, bType = true(1) : 이미지 변경, false(0) : 원래 이미지, sSrc = 변경될 이미지 경로
<img onMouseOver=xwzImgRollOver(this, '/path/src/sample.gif') onMouseOut=xwzImgRollOver(this)
================================================ */
function xwzImgOverTrans(oImg, sSrc){
	if(typeof(sSrc) =='string'){
		if( oImg.getAttribute('xwzAlreadySrc') == null) oImg.setAttribute('xwzAlreadySrc', oImg.src);
		oImg.src = sSrc;
	}else{
		if( oImg.getAttribute('xwzAlreadySrc') != null) oImg.src = oImg.getAttribute('xwzAlreadySrc');
	}
}

function xwzImgRollOver(oImg, bType, sSrc){
	if(bType == true){
		if( oImg.getAttribute('xwzAlreadySrc') == null) oImg.setAttribute('xwzAlreadySrc', oImg.src);
		oImg.src = sSrc;
	}else{
		if( oImg.getAttribute('xwzAlreadySrc') != null) oImg.src = oImg.getAttribute('xwzAlreadySrc');
	}
}
function subMenuVisable(obj, isVisable){
	var tables = obj.getElementsByTagName('TABLE');
	tables[0].style.display = isVisable === true ? '' : 'none';
}
/* ================================================
롤링 이벤트
================================================ */
function xwzRollingImageTrans(imageName, thumbnailName, eventName, winName){
	this.Index = 0;
	this.ListItem = new Array(0);
	this.Name = imageName;
	this.Thumbnail = thumbnailName;
	this.tmRotate = null;
	this.nInterval = 7000;
	this.eventName = eventName;
	this.winTarget = winName;
	
	if(window.xwzRollObject == null) window.xwzRollObject = new Array(0);
	window.xwzRollObject[this.Name] = this;

	//== 초기화 함수
	this.install = function(){
		window.document.images[this.Name].onclick=this.goLink;
		if(this.ListItem.length == 0) return;
		this.tmRotate = setTimeout("window.xwzRollObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
		var icons = document.getElementsByName(this.Thumbnail);
		for(var i = 0; i < icons.length; i++){
			if(this.eventName == 'over') icons[i].onmouseover=new Function("window.xwzRollObject['"+this.Name+"'].alterImage(" + i + ")");
			else icons[i].onclick=new Function("window.xwzRollObject['"+this.Name+"'].alterImage(" + i + ")");
		}
	}
	//== 해당 아이템 추가 
	this.addItem = function(Link, ImgSrc, Icon1, Icon2 ){
		var itmX = {Link : "", ImgSrc : "", DefIcon : "", OvrIcon : ""};
		itmX.Link = Link;
		itmX.ImgSrc = ImgSrc;
		itmX.DefIcon = Icon1;
		itmX.OvrIcon = Icon2;
		this.ListItem[this.ListItem.length] = itmX;
	}
	//== 수동 변경 
	this.alterImage = function(index){
		var icons = document.getElementsByName(this.Thumbnail);
		if(this.Index == index) return;
		if(this.ListItem[this.Index].DefIcon !="") icons[this.Index].src = this.ListItem[this.Index].DefIcon;

		this.Index = index;
		this.imgTrans();
		clearTimeout(this.tmRotate);
		this.tmRotate = null;
		this.tmRotate = setTimeout("window.xwzRollObject['" + this.Name + "'].rotateTrans()" , this.nInterval);

	}

	//== 링크 클릭
	this.goLink = function(){
		var name = this.getAttribute('name');
		var xwzRoll = window.xwzRollObject[name];
		clearTimeout(xwzRoll.tmRotate);
		xwzRoll.tmRotate = null;

		if(xwzRoll.winTarget == '' || xwzRoll.winTarget == null){
			window.location.href=xwzRoll.ListItem[xwzRoll.Index].Link;
		}else if(xwzRoll.winTarget.toLowerCase().indexOf("javascript") == 0){
			alert( winTarget.replace(/javascript:/gi,'') )
		}else{
			window.open(xwzRoll.ListItem[xwzRoll.Index].Link, xwzRoll.winTarget);
		}
	}

	//==
	this.rotateTrans = function(){
		var icons = document.getElementsByName(this.Thumbnail);
		var itmX = this.ListItem[this.Index];
		if(itmX.DefIcon !="") icons[this.Index].src = itmX.DefIcon;

		this.Index +=1;
		if(this.Index >= this.ListItem.length) this.Index = 0;

		this.imgTrans();
		
		clearTimeout(this.tmRotate);
		this.tmRotate = null;
		this.tmRotate = setTimeout("window.xwzRollObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
	}

	//==
	this.imgTrans = function(){
		var icons = document.getElementsByName(this.Thumbnail);
		var itmX = this.ListItem[this.Index];
		if(itmX.OvrIcon !=null  && itmX.OvrIcon !="") icons[this.Index].src = itmX.OvrIcon;
		try{
			document.images[this.Name].filters[0].apply();
			document.images[this.Name].src = itmX.ImgSrc;
			document.images[this.Name].filters[0].play();
		}catch(e){
			document.images[this.Name].src = itmX.ImgSrc;
		}
	}
}
/* ================================================
롤링 이벤트 LOW
================================================ */
function xwzRollingImageTransLow(imageName, thumbnailName, eventName, winName){
	this.Index = 0;
	this.ListItem = new Array(0);
	this.Name = imageName;
	this.Thumbnail = thumbnailName;
	this.tmRotate = null;
	this.nInterval = 13590;
	this.eventName = eventName;
	this.winTarget = winName;
	
	if(window.xwzRollObject == null) window.xwzRollObject = new Array(0);
	window.xwzRollObject[this.Name] = this;

	//== 초기화 함수
	this.install = function(){
		window.document.images[this.Name].onclick=this.goLink;
		if(this.ListItem.length == 0) return;
		this.tmRotate = setTimeout("window.xwzRollObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
		var icons = document.getElementsByName(this.Thumbnail);
		for(var i = 0; i < icons.length; i++){
			if(this.eventName == 'over') icons[i].onmouseover=new Function("window.xwzRollObject['"+this.Name+"'].alterImage(" + i + ")");
			else icons[i].onclick=new Function("window.xwzRollObject['"+this.Name+"'].alterImage(" + i + ")");
		}
	}
	//== 해당 아이템 추가 
	this.addItem = function(Link, ImgSrc, Icon1, Icon2 ){
		var itmX = {Link : "", ImgSrc : "", DefIcon : "", OvrIcon : ""};
		itmX.Link = Link;
		itmX.ImgSrc = ImgSrc;
		itmX.DefIcon = Icon1;
		itmX.OvrIcon = Icon2;
		this.ListItem[this.ListItem.length] = itmX;
	}
	//== 수동 변경 
	this.alterImage = function(index){
		var icons = document.getElementsByName(this.Thumbnail);
		if(this.Index == index) return;
		if(this.ListItem[this.Index].DefIcon !="") icons[this.Index].src = this.ListItem[this.Index].DefIcon;

		this.Index = index;
		this.imgTrans();
		clearTimeout(this.tmRotate);
		this.tmRotate = null;
		this.tmRotate = setTimeout("window.xwzRollObject['" + this.Name + "'].rotateTrans()" , this.nInterval);

	}

	//== 링크 클릭
	this.goLink = function(){
		var name = this.getAttribute('name');
		var xwzRoll = window.xwzRollObject[name];
		clearTimeout(xwzRoll.tmRotate);
		xwzRoll.tmRotate = null;

		if(xwzRoll.winTarget == '' || xwzRoll.winTarget == null){
			window.location.href=xwzRoll.ListItem[xwzRoll.Index].Link;
		}else if(xwzRoll.winTarget.toLowerCase().indexOf("javascript") == 0){
			alert( winTarget.replace(/javascript:/gi,'') )
		}else{
			window.open(xwzRoll.ListItem[xwzRoll.Index].Link, xwzRoll.winTarget);
		}
	}

	//==
	this.rotateTrans = function(){
		var icons = document.getElementsByName(this.Thumbnail);
		var itmX = this.ListItem[this.Index];
		if(itmX.DefIcon !="") icons[this.Index].src = itmX.DefIcon;

		this.Index +=1;
		if(this.Index >= this.ListItem.length) this.Index = 0;

		this.imgTrans();
		
		clearTimeout(this.tmRotate);
		this.tmRotate = null;
		this.tmRotate = setTimeout("window.xwzRollObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
	}

	//==
	this.imgTrans = function(){
		var icons = document.getElementsByName(this.Thumbnail);
		var itmX = this.ListItem[this.Index];
		if(itmX.OvrIcon !=null  && itmX.OvrIcon !="") icons[this.Index].src = itmX.OvrIcon;
		try{
			document.images[this.Name].filters[0].apply();
			document.images[this.Name].src = itmX.ImgSrc;
			document.images[this.Name].filters[0].play();
		}catch(e){
			document.images[this.Name].src = itmX.ImgSrc;
		}
	}
}

/* ================================================
롤링 이벤트
================================================ */
function xwzRollingMarqTrans(Name, eventName){
	this.Name = Name;
	this.Index = 0;
	this.ListItem = new Array(0);

	this.tmRotate = null;
	this.nInterval = 4500;
	this.eventName = eventName;

	if(window.xwzMarqObject == null) window.xwzMarqObject = new Array(0);
	window.xwzMarqObject[this.Name] = this;

	//== 초기화 함수
	this.install = function(){
		if(this.ListItem.length == 0) return;
		this.tmRotate = setTimeout("window.xwzMarqObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
		for(var i = 0; i < this.ListItem.length; i++){
			if(this.eventName == 'over') this.ListItem[i].Img.onmouseover=new Function("window.xwzMarqObject['"+this.Name+"'].alterTrans(" + i + ")");
			else this.ListItem[i].Img.onclick=new Function("window.xwzMarqObject['"+this.Name+"'].alterTrans(" + i + ")");
		}
	}
	//== 해당 아이템 추가 
	this.addItem = function(targetObj, targetImg, Icon1, Icon2 ){
		var itmX = {Objects : null, Imgs : null, DefaultSrc : "",OverSrc : ""};
		itmX.Object = targetObj;
		itmX.Img = targetImg;
		itmX.DefaultSrc = Icon1;
		itmX.OverSrc = Icon2;
		this.ListItem[this.ListItem.length] = itmX;
	}

	//== 수동 변경 
	this.alterTrans = function(index){
		if(this.Index == index) return;
		var itmX = this.ListItem[this.Index];
		if(itmX.DefaultSrc !="") itmX.Img.src = itmX.DefaultSrc;
		this.Index = index;
		this.objTrans();
		clearTimeout(this.tmRotate);
		this.tmRotate = null;
		this.tmRotate = setTimeout("window.xwzMarqObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
	}
	//==
	this.rotateTrans = function(){
		var itmX = this.ListItem[this.Index];
		if(itmX.DefaultSrc !="") itmX.Img.src = itmX.DefaultSrc;

		this.Index +=1;
		if(this.Index >= this.ListItem.length) this.Index = 0;

		this.objTrans();
		
		clearTimeout(this.tmRotate);
		this.tmRotate = null;
		this.tmRotate = setTimeout("window.xwzMarqObject['" + this.Name + "'].rotateTrans()" , this.nInterval);
	}

	//==
	this.objTrans = function(){
		var itmX = this.ListItem[this.Index];
		if(itmX.Img !=null  && itmX.OverSrc !="") itmX.Img.src = itmX.OverSrc;
		for(var i =0; i <  this.ListItem.length; i++) this.ListItem[i].Object.style.display = 'none';
		try{
			itmX.Object.filters[0].apply();
			itmX.Object.style.display='';
			itmX.Object.filters[0].play();
		}catch(e){
			itmX.Object.style.display='';
		}
	}
}
/* ================================================
롤링 이벤트2
var xrml=new xwzRollingMarqLayerTrans('mouseover');
xrml.add(document.getElementById('IDS_MAIN_DIARY0'), document.images['IMGS_T_DIARY0'], 'http://image.babosarang.co.kr/v2/newmain2/diary/roll_05.gif', 'http://image.babosarang.co.kr/v2/newmain2/diary/diary_05.gif');
xrml.add(document.getElementById('IDS_MAIN_DIARY1'), document.images['IMGS_T_DIARY1'], 'http://image.babosarang.co.kr/v2/newmain2/diary/diary_06.gif', 'http://image.babosarang.co.kr/v2/newmain2/diary/roll_06.gif');
xrml.add(document.getElementById('IDS_MAIN_DIARY2'), document.images['IMGS_T_DIARY2'], 'http://image.babosarang.co.kr/v2/newmain2/diary/diary_07.gif', 'http://image.babosarang.co.kr/v2/newmain2/diary/roll_07.gif');
xrml.play();
================================================ */
var xwzRollingMarqLayerTrans=function (eventName,nInterval){if(window.xwzRMLTS==null)window.xwzRMLTS=new Array(0);this.Index=xwzRMLTS.length;this.nNode=0;xwzRMLTS[this.Index] = this;this.Nodes=[];this.tmRotate=null;this.eventName = eventName||'click';this.nInterval=nInterval||4500;this.Observers=[];};
xwzRollingMarqLayerTrans.prototype={
	Event:{add:function(element,name,fpnotify,useCapture){if(element.attachEvent)element.attachEvent('on'+name, fpnotify);else if(element.addEventListener)element.addEventListener(name,fpnotify,useCapture||false);},remove:function(element,name,fpnotify,useCapture){if(element.detachEvent) element.detachEvent('on'+name,fpnotify);else if(element.removeEventListener)element.removeEventListener(name,fpnotify,useCapture||false);}},
	play:function(){if(this.Nodes.length==0) return;this.objTrans();this.tmRotate=setTimeout("xwzRMLTS["+this.Index+"].rotateToggle()",this.nInterval);for(var i=0;i<this.Nodes.length;i++){this.Observers[i]=new Function("xwzRMLTS["+this.Index+"].setToggle("+i+")");this.Event.add(this.Nodes[i].Icon,this.eventName,this.Observers[i]);}},
	add:function(target,img,src1,src2){return this.Nodes[this.Nodes.length]={Node:target,Icon:img,Src1:src1,Src2:src2};},
	setToggle:function(index){if(this.nNode==index) return;var oNode=null;oNode=this.Nodes[this.nNode];if(typeof oNode.Icon.src=='string'&&oNode.Src1!='') oNode.Icon.src=oNode.Src1;oNode.Node.style.display='none';this.nNode=index;this.objTrans();clearTimeout(this.tmRotate);this.tmRotate=null;this.tmRotate=setTimeout("xwzRMLTS["+this.Index+"].rotateToggle()",this.nInterval);	},
	rotateToggle:function(){clearTimeout(this.tmRotate);this.tmRotate=null;if(this.Nodes.length==0) return;var oNode=this.Nodes[this.nNode];oNode.Node.style.display='none';if(typeof oNode.Icon.src=='string'&&oNode.Src1!='')oNode.Icon.src=oNode.Src1;this.nNode+=1;if(this.nNode>=this.Nodes.length)this.nNode=0;this.objTrans();this.tmRotate=setTimeout("xwzRMLTS["+this.Index+"].rotateToggle()",this.nInterval);},
	objTrans:function(){var oNode = this.Nodes[this.nNode];if(typeof oNode.Icon.src=='string'&&oNode.Src2!="")oNode.Icon.src=oNode.Src2;oNode.Node.style.display='';try{oNode.Node.filters[0].apply();oNode.Node.filters[0].play();}catch(e){};}
};

function verticalWheel(id, height, nSec ){

	if(window.xwzWheelMarq == null) window.xwzWheelMarq = new Array(0);
	xwzWheelMarq[id]  = {
		install : function(id, height, nSec){
			this.id = id;
			this.div = document.getElementById('ID_DIV_KEYWORD');
			this.table = document.getElementById('ID_TABLE_KEYWORD');
			if(this.div == null) return;
			//this.div.style.cssText = "height:"+height+";position:relative;cursor:pointer;";
			this.div.style.cssText = "height:"+height+";overflow:hidden;position:relative;cursor:pointer;clip:rect(0 auto "+this.height+" 0);left:0;top:0";
			this.div.parentNode.style.position='relative'
			this.div.parentNode.onmouseover=function(){xwzWheelMarq[id].table.style.visibility ='visible';	xwzWheelMarq[id].nPause=true;}
			this.div.parentNode.onmouseout= function(){xwzWheelMarq[id].table.style.visibility ='hidden';xwzWheelMarq[id].nPause=false;}	

			this.index =0;
			this.height = height;
			this.items = new Array(0);
			this.tmID = null;
			this.nPause = false;
			this.nSec = nSec;
			var rows =this.table.tBodies[0].rows;
			for(var i = 0; i < rows.length; i++){
				this.items[i] = document.createElement("DIV");
				this.items[i].innerHTML=rows[i].innerHTML;
				this.items[i].style.padding="3";
				this.items[i].style.width="100%";
				this.items[i].style.height=this.height ;
				this.items[i].style.position="absolute";
				this.items[i].style.top = this.height*i;
				this.div.appendChild(this.items[i]);

				rows[i].cells[0].style.cssText="padding-left:5px;border-bottom:#CACACA 1px dotted;";
				rows[i].onmouseover=function(){this.style.backgroundColor="#FDF1F0";}
				rows[i].onmouseout=function(){this.style.backgroundColor="";}
				if(i >= rows.length -1){rows[i].cells[0].style.border="";}
			}
		},
		doWheel : function(){
			var itmN = this.items[this.index];
			var nSleep= 50;
			var nIndex= this.index+1 >=  this.items.length ? 0 :  this.index+1;
			clearTimeout(this.tmID); this.tmID = null;
			if(this.nPause != true){
				for(var i = 0; i < this.items.length; i++){
					this.items[i].style.top = parseInt(this.items[i].style.top)-1;
				}
				if(parseInt(itmN.style.top) <= this.height*-1){
					itmN.style.top = this.height*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
					nSleep= this.nSec;
				}
			}else{
				if(parseInt(itmN.style.top) < (this.height/2)*-1){
					itmN.style.top = this.height*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
				}

				for(var i = 0; i < this.items.length; i++){
					this.items[i].style.top =  this.height * (  (this.items.length -  this.index + i ) % this.items.length );
				}
				nSleep = 10;
			}

			
			this.tmID = setTimeout("xwzWheelMarq['" + this.id + "'].doWheel()", nSleep);
		}
	}


	xwzWheelMarq[id].install(id, height, nSec);
	xwzWheelMarq[id].tmID = setTimeout("xwzWheelMarq['" +id + "'].doWheel()", nSec);

	
	//
}
function verticalWheel_event(id, Height, nSec,wdth_height){
	if(window.xwzWheelMarq == null) window.xwzWheelMarq = new Array(0);
	xwzWheelMarq[id]  = {
		install : function(id, Height, nSec){
			this.id = id;
			this.div = document.getElementById('ID_DIV_' + id);
			this.table = document.getElementById('ID_TABLE_' + id);
//			alert(this.div.style.width)
			if(this.div == null) return;
			this.wdth_height = (wdth_height == null) ? "width:215px;height:187px;" : wdth_height;

			this.div.style.cssText = "position:relative;cursor:pointer;"+this.wdth_height+"overflow:hidden;clip:rect(0 auto "+this.height+" 0);left:0;top:0;";
			this.div.parentNode.style.position='relative'
			this.div.parentNode.onmouseover=function(){xwzWheelMarq[id].nPause=true;}
			this.div.parentNode.onmouseout= function(){xwzWheelMarq[id].nPause=false;}	

			this.index =0;
			this.height = Height;
			this.items = new Array(0);
			this.tmID = null;
			this.nPause = false;
			this.nSec = nSec;
			var rows =this.table.tBodies[0].rows;
			for(var i = 0; i < rows.length; i++){
				this.items[i] = document.createElement("DIV");
				this.items[i].innerHTML=rows[i].innerHTML;
				this.items[i].style.padding="3";
				this.items[i].style.height=this.height;
				this.items[i].style.position="absolute";
				this.items[i].style.top = this.height * i;
				this.div.appendChild(this.items[i]);

//				rows[i].cells[0].style.cssText="padding-left:5px;border-bottom:#CACACA 1px dotted;";
				rows[i].onmouseover=function(){this.style.backgroundColor="#FDF1F0";}
				rows[i].onmouseout=function(){this.style.backgroundColor="";}
//				if(i >= rows.length -1){rows[i].cells[0].style.border="";}
			}
		},
		doClick : function(n){
			if(!n)
			{
				var nSleep = 10;
				this.nPause=false;
				this.tmID = setTimeout("xwzWheelMarq['" + this.id + "'].doWheel()", nSleep);
				return;
			}
			
			this.index = this.index+n;
			var nIndex = this.index+1 >=  this.items.length ? 0 :  this.index+1;
			if(this.index< 0 ) this.index	= this.items.length-1;
			if(this.index > this.items.length-1) this.index=0;
			var itmN = this.items[this.index];
	
			clearTimeout(this.tmID); this.tmID = null;
	
			if(parseInt(itmN.style.top) < (this.height/2)*-1){
					itmN.style.top = this.height*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
			}
			for(var i = 0; i < this.items.length; i++){
				this.items[i].style.top =  this.height * (  (this.items.length -  this.index + i ) % this.items.length );
			}


	
			
		},
		doWheel : function(){
			var itmN = this.items[this.index];
			var nSleep= 20;
			var nIndex= this.index+1 >=  this.items.length ? 0 :  this.index+1;
			clearTimeout(this.tmID); this.tmID = null;


			if(this.nPause != true){
				for(var i = 0; i < this.items.length; i++){
					this.items[i].style.top = parseInt(this.items[i].style.top)-1;
				}
				if(parseInt(itmN.style.top) <= this.height*-1){
					itmN.style.top = this.height*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
					nSleep= this.nSec;
				}
			}else{
				if(parseInt(itmN.style.top) < (this.height/2)*-1){
					itmN.style.top = this.height*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
				}

				for(var i = 0; i < this.items.length; i++){
					this.items[i].style.top =  this.height * (  (this.items.length -  this.index + i ) % this.items.length );
				}
				nSleep = 10;
			}
	
			this.tmID = setTimeout("xwzWheelMarq['" + this.id + "'].doWheel()", nSleep);
		}
	}


	xwzWheelMarq[id].install(id, Height, nSec);
	xwzWheelMarq[id].tmID = setTimeout("xwzWheelMarq['" +id + "'].doWheel()", nSec);

	
	//
}
function horizontalWheel(id, width, nSec,wdth_height){
	if(window.xwzWheelHoriz == null) window.xwzWheelHoriz = new Array(0);
	xwzWheelHoriz[id]  = {
		install : function(id, width, nSec){
			this.id = id;
			this.div = document.getElementById('DIV_ID_NEWGOODS');
			this.table = document.getElementById('TBL_ID_NEWGOODS');
//			alert(this.div.style.width)
			if(this.div == null) return;
			this.wdth_height = (wdth_height == null) ? "width:690px;height:150px;" : wdth_height;

			this.div.style.cssText = "position:relative;cursor:pointer;"+this.wdth_height+"overflow:hidden;clip:rect(0 auto "+this.width+" 0);left:2;top:0;";
			this.div.parentNode.style.position='relative'
			this.div.parentNode.onmouseover=function(){xwzWheelHoriz[id].nPause=true;}
			this.div.parentNode.onmouseout= function(){xwzWheelHoriz[id].nPause=false;}	

			this.index =0;
			this.width = width;
			this.items = new Array(0);
			this.tmID = null;
			this.nPause = false;
			this.nSec = nSec;
			var cols =this.table.tBodies[0].rows[0].cells;
			for(var i = 0; i < cols.length; i++){
				this.items[i] = document.createElement("DIV");
				this.items[i].innerHTML=cols[i].innerHTML;
				this.items[i].style.padding="3";
				this.items[i].style.width=cols[i].width ;
				this.items[i].style.position="absolute";
				this.items[i].style.left = 1 + cols[i].width * i;
				this.div.appendChild(this.items[i]);

//				rows[i].cells[0].style.cssText="padding-left:5px;border-bottom:#CACACA 1px dotted;";
				cols[i].onmouseover=function(){this.style.backgroundColor="#FDF1F0";}
				cols[i].onmouseout=function(){this.style.backgroundColor="";}
//				if(i >= rows.length -1){rows[i].cells[0].style.border="";}
			}
		},
		doClick : function(n){
			if(!n)
			{
				var nSleep = 10;
				this.nPause=false;
				this.tmID = setTimeout("xwzWheelHoriz['" + this.id + "'].doWheel()", nSleep);
				return;
			}
			
			this.index = this.index+n;
			var nIndex = this.index+1 >=  this.items.length ? 0 :  this.index+1;
			if(this.index< 0 ) this.index	= this.items.length-1;
			if(this.index > this.items.length-1) this.index=0;
			var itmN = this.items[this.index];
	
			clearTimeout(this.tmID); this.tmID = null;
	
			if(parseInt(itmN.style.left) < (this.width/2)*-1){
					itmN.style.left = this.width*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
			}
			for(var i = 0; i < this.items.length; i++){
				this.items[i].style.left =  this.width * (  (this.items.length -  this.index + i ) % this.items.length );
			}


	
			
		},
		doWheel : function(){
			var itmN = this.items[this.index];
			var nSleep= 20;
			var nIndex= this.index+1 >=  this.items.length ? 0 :  this.index+1;
			clearTimeout(this.tmID); this.tmID = null;


			if(this.nPause != true){
				for(var i = 0; i < this.items.length; i++){
					this.items[i].style.left = parseInt(this.items[i].style.left)-1;
				}
				if(parseInt(itmN.style.left) <= this.width*-1){
					itmN.style.left = this.width*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
					nSleep= this.nSec;
				}
			}else{
				if(parseInt(itmN.style.left) < (this.width/2)*-1){
					itmN.style.left = this.width*(this.items.length-1);
					this.index = this.index+1 >=  this.items.length ? 0 :  this.index+1;
				}

				for(var i = 0; i < this.items.length; i++){
					this.items[i].style.left =  this.width * (  (this.items.length -  this.index + i ) % this.items.length );
				}
				nSleep = 10;
			}
	
			this.tmID = setTimeout("xwzWheelHoriz['" + this.id + "'].doWheel()", nSleep);
		}
	}


	xwzWheelHoriz[id].install(id, width, nSec);
	xwzWheelHoriz[id].tmID = setTimeout("xwzWheelHoriz['" +id + "'].doWheel()", nSec);

	
	//
}
function showTooltop(obj, isDisp){
	var elements = obj.getElementsByTagName("DIV");
	var objTooltip=null;
	for(var i = 0; i < elements.length; i++){
		if(elements[i].className !='cssTooltip') continue;
		objTooltip = elements[i];break;
	}
	
	if(objTooltip == null) return;
	var Tables = document.body.getElementsByTagName("TABLE");

	if(isDisp){
		var cX =  event.clientX +15, cY =  event.clientY +10;
		objTooltip.style.display='';
		objTooltip.style.zIndex = 10000;
		objTooltip.style.left=cX;
	}else{
		objTooltip.style.display='none';
		objTooltip.style.zIndex = -1;
	}
}

function getOffsetPos(obj){
	// 보여질 위치 자리 잡기
	var left = obj.offsetLeft;
	var top = obj.offsetTop;
	for (var pElement = obj.offsetParent; 'body' != pElement.tagName.toLowerCase(); pElement = pElement.offsetParent){
		if(pElement.style.position.toLowerCase() == 'absolute' || pElement.style.position.toLowerCase() == 'relative') continue;
		if(pElement.tagName.toLowerCase() != 'table'){left += pElement.clientLeft;top += pElement.clientTop;}
		if(parseInt(pElement.style.paddingLeft) > 0 ) left += parseInt(pElement.style.paddingLeft);
		if(parseInt(pElement.style.paddingTop) > 0 ) top += parseInt(pElement.style.paddingTop);

		if(parseInt(pElement.style.marginLeft ) > 0 ) left += parseInt(pElement.style.marginLeft );
		if(parseInt(pElement.style.marginTop ) > 0 ) top += parseInt(pElement.style.marginTop );

		left += pElement.offsetLeft; top += pElement.offsetTop;
	}
	this.posX = left; this.posY = top;
}

/* ================================================
롤링 자바스크립트 2007-01-02
-상단 Today HOT 부분
================================================ */
function na_restore_img_src(name, nsdoc)
{
  var img = eval((navigator.appName.indexOf('Netscape', 0) != -1) ? nsdoc+'.'+name : 'document.all.'+name);
  if (name == '')
    return;
  if (img && img.altsrc) {
    img.src    = img.altsrc;
    img.altsrc = null;
  } 
}

function na_preload_img()
{ 
  var img_list = na_preload_img.arguments;
  if (document.preloadlist == null) 
    document.preloadlist = new Array();
  var top = document.preloadlist.length;
  for (var i=0; i < img_list.length-1; i++) {
    document.preloadlist[top+i] = new Image;
    document.preloadlist[top+i].src = img_list[i+1];
  } 
}

function na_change_img_src(name, nsdoc, rpath, preload)
{ 
  var img = eval((navigator.appName.indexOf('Netscape', 0) != -1) ? nsdoc+'.'+name : 'document.all.'+name);
  if (name == '')
    return;
  if (img) {
    img.altsrc = img.src;
    img.src    = rpath;
  } 
}

function ToggleRoll(nItem , src, target,nTime) 
{
	this.index = 0;
	this.tempIndex= 0;
	this.items = new Array();
	this.nTime = nTime;
	this.nItem = document.getElementById(nItem);
	this.pause = false;
	this.init = function()
	{
		this.items[this.items.length] = document.getElementById(src);
		this.items[this.items.length] = document.getElementById(target);
	}
    this.setRolling =function(index)
	{
			
		
			this.index =index;
			this.index = ++this.index % 2;
			this.pause=true;
			
			
			this.nItem.filters[0].Apply();		
			this.items[index].style.visibility="visible"; 
			this.items[this.index].style.visibility="hidden";	
			this.nItem.filters[0].Play(duration=2);		
			
		if(this.tempIndex != index)
		{
			this.tempIndex = index;
			document.getElementById('IMGS_BEST_PRODUCT'+index).src = document.getElementById('IMGS_BEST_PRODUCT'+index).src.replace('best_','best_r_');
			document.getElementById('IMGS_BEST_PRODUCT'+this.index).src = document.getElementById('IMGS_BEST_PRODUCT'+this.index).src.replace('best_r_','best_');
		}
			
//			window.title = 'index:'+ index + ';index2:'+this.index;
	}
	this.rolling=function()
	{
		if(! this.pause)
		{
			var index = this.index;
			this.index = ++this.index % 2;
			
			this.nItem.filters[0].Apply();		
			this.items[index].style.visibility="visible"; 
			this.items[this.index].style.visibility="hidden";	
			this.nItem.filters[0].Play(duration=2);		
			
			document.getElementById('IMGS_BEST_PRODUCT'+index).src = document.getElementById('IMGS_BEST_PRODUCT'+index).src.replace('best_','best_r_');
			document.getElementById('IMGS_BEST_PRODUCT'+this.index).src = document.getElementById('IMGS_BEST_PRODUCT'+this.index).src.replace('best_r_','best_');
			
//			window.title = 'index:'+ index + ';index2:'+this.index;
		}
		setTimeout("tgRoll.rolling()",this.nTime);
	}
}

