/**
	front_end：前端样式
*/
function MyPublic(objs){
	this.obj=objs||obj;
	if(objs.webp){
		this.obj.format='/format/webp'
	}
}
MyPublic.prototype.run=function(){
	this.front_end();
}
MyPublic.prototype.front_end=function(){
	
	$(".my-header .state li").mouseover(function(){
		var Num=$(this).index();
		if(Num==0){
			$(this).siblings(".slider").css("left","50%");
			$(this).children("a").css("color","#fff");
			$(this).siblings(".my-register").children("a").css("color","#0ec5a1");
		}else{
			$(this).siblings(".slider").css("left","0");
			$(this).children("a").css("color","#fff");
			$(this).siblings(".my-login").children("a").css("color","#0ec5a1");
		}
	})
	
}
function getMyPublic(obj){
	return new MyPublic(obj);
}
