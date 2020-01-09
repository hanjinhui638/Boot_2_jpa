<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
>
<div class="container">
	  <h2>${board} Write Form</h2>
	  <form action="${board}Write" method="post" enctype="multipart/form-data">
	  	
	    <div class="form-group">
	      <label for="title">Title:</label>
	      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="writer">Writer:</label>
	      <input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
	    </div>
	    
	    <div class="form-group">
	      <label for="contents">Contents:</label>
	      <textarea  rows="20" cols="50" class="form-control" id="contents" placeholder="Enter Contents" name="contents"></textarea>
	    </div>
	    
	       <div id = "files">
	    	<div class = "form-group" title = "parent" >
	    	 	 <label for="file" class = "control-label col-sm-2" >File:</label>
	     	 <div class = "col-sm-9">
	      			<input type="file" class="form-control " id="file" name="files">
	      	</div>
	     	 <div class = "col-sm-1">
	      		<input type="button" class="form-control btn btn-danger del" value="del">
	     	 </div>
	    	</div>
	    </div>
	    
	   
			<input type="button" class = "btn btn-success" value="Add File" id = "add">
	    
	    
	     <button class="btn btn-info">Submit</button>
	    </form>
	</div>

<script type="text/javascript">

		var files = $("#files").html();  //click event 밖에 선언 
			$("#files").empty(); 	
			var count =0; 					//안에 선언하면 초기화
			var index =0;	//index선언
		
		$("#files").on("click",".del",function(){
			//$(this).parent().parent().remove();
			$(this).parents(".form-group").remove(); 
			count--;
		});
			
		
		$("#add").click(function () {
				if(count<5){
					
				//var files = '<div id = "f'+index+''"><input><input type="button" title="f"></div>';
				$("#files").append(files);
				count++;
				//connt++
				//index++ 자신과 상관 없는 속성 controll하기 
				}else{
					alert("최대 5개 가능");
				}
		});
</script>		

</body>
</html>