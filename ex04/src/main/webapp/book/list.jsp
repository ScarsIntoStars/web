<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col">
		<h1 class="text-center">도서목록</h1>
	</div>
</div>

<script>
	$.ajax({
		type:"get",
		url:"/book/list.json",
		dataType:"json",
		data:{page:3},
		success:function(data){
			console.log(data);
		}
	});
</script>