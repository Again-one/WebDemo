function CategoryAction(){
	
	obj.domain='categoryPage';
	this.obj=obj;
	MyPublic.call(this,obj);
	this.obj=obj;
	if(obj.webp){
		this.fromat='/format/webp'
	}
	
}
CategoryAction.prototype=getMyPublic(obj);
var category=new CategoryAction();
category.run();
