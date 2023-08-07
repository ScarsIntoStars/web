<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row my-5">
	<div class="col">
		<h1 class="text-center mb-5">수강신청</h1>
		<div class="card p-3">
			<div class="row">
				<div class="col">학생번호: ${vo.scode}</div>
				<div class="col">학생이름: ${vo.sname}</div>
				<div class="col">학생학과: ${vo.dept}</div>
				<div class="col">지도교수: ${vo.pname} (${vo.advisor})</div>
			</div>
		</div>
		<hr>
		<div id="div_enroll"></div>
	</div>
</div>
<!-- 수강신청목록 템플릿 -->
<script id="temp_enroll" type="text/handlebars-template">
	<table class="table">
		<tr>
			<th>강좌번호</th><th>강좌이름</th><th>점수</th><th>시수</th>
			<th>신청일</th><th>강의실</th><th>담당교수</th><th>신청/최대</th>
		</tr>
		{{#each .}}
		<tr>
			<td>{{lcode}}</td>
			<td>{{lname}}</td>
			<td>{{grade}}</td>	
			<td>{{edate}}</td>
			<td>{{hours}}</td>
			<td>{{room}}</td>
			<td>{{pname}}</td>
			<td>{{persons}}/{{capacity}}</td>
		</tr>
		{{/each}}
	</table>
</script>
<script>
	const scode="${vo.scode}";
	getList();
	function getList(){
		$.ajax({
			type:"get",
			url:"/stu/enroll.json",
			data:{scode:scode},
			dataType:"json",
			success:function(data){
				console.log(data);
				const temp=Handlebars.compile($("#temp_enroll").html());
				const html=temp(data);
				$("#div_enroll").html(html);
			}
		});
	}
</script>