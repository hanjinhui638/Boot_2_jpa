<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
<div class = "container">

	<div>
		<a href="./${board}Write" class = "btn btn-danger">글쓰기</a>
	</div>

	<table class = "table table-condensed ">
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
			<!-- <td>File</td> -->
		</tr>
		<c:forEach items="${list.pageList.content}" var = "vo">
			<tr>
				<td>${vo.num}</td>
				<td><a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>	
			<%-- 	<td>
					<c:forEach items="${vo.noticeFilesVOs}" var = "f">
					 	${f.fname}
					</c:forEach>
				</td>	 --%>
			</tr>		
		</c:forEach>
	
	</table>
	
	<div class= "contents">
		
		<c:if test="${pager.curBlock > 1}">
			<a href="./${board}List?curPage=${pager.startNum-1}">[이전]</a>
		
		</c:if>
		
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<a href="./${board}List?curPage=${i}">${i}</a>
		</c:forEach>
		
		
		<c:if test = "${pager.curBlock < pager.totalBlock}">
			<a href="./${board}List?curPage=${pager.lastNum+1}">[다음]</a>
			
		</c:if>
	</div>
	
 	<div> <!-- 검색창 -->
	  		<form id="frm" action="./${board}List">
	  			<input type="hidden" id="curPage" value="1" name="curPage">
	  			<select name="kind">
	  				<option id="kT" value="kT">Title</option>
	  				<option id="kW" value="kW">Writer</option>
	  				<option id="kC" value="kC">Contents</option>
	  			</select>
	  			
	  			<input type="text" name="search" value="${pager.search}">
	  			<button>Search</button>
	  		</form>
	  	</div>


</div> 



 <script type="text/javascript">
	 	var kind = '${pager.kind}';
		if(kind == ''){
				kind = "kT";
			}
		$("#"+kind).prop("selected", true);
	
		$('.list').click(function(){
			$("#curPage").val($(this).attr("id"));
			$("#frm").sumit();
			
			}); 
		
	</script>

</body>
</html>