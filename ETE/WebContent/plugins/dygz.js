
	
	
//隔行换色		
$("ul").find("li").addClass("odd");
$("ul").find("li:even").addClass("even");


//单位五险二金
$(".dw").hide();
//隐藏显示部分内容
$(".dwAll").click(function(){
	$(".dw").toggle(1000);
});


//个人五险二金
$(".ge").hide();
$(".geAll").click(function(){
	
	$(".ge").toggle(1000);
});


//津贴
$(".jin").hide();
//隐藏显示部分内容
$(".jinAll").click(function(){
	$(".jin").toggle(1000);
});


//绩效奖金
$(".jxjj").hide();
//隐藏显示部分内容
$(".jxjjAll").click(function(){
	$(".jxjj").toggle();
});


//补贴福利
$(".btfl").hide();
//隐藏显示部分内容
$(".btflAll").click(function(){
	$(".btfl").toggle(1000);
});


