<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row my-5">
	<div class="col mb-5">
		<h1 class="text-center mb-5">장바구니</h1>
		<div id="div_cart"></div>
	</div>
</div>

<!-- 카트목록 -->
<script id="temp_cart" type="text/x-handlebars-template">
	<table class="table">
			<tr>
				<td>상품코드</td>
				<td>썸네일</td>
				<td>상품명</td>
				<td>상품가격</td>
				<td>갯수</td>
				<td>가격<td>
				<td>삭제</td>
			</tr>

		{{#each .}}
			<tr class="tr" price={{price}}>
				<td class="gid">{{gid}}</td>
				<td><img src="{{image}}" width="50px"</td>
				<td>{{title}}</td>
				<td>{{sum price 1}}</td>
				<td><input class="qnt" value="{{qnt}}" size=5 oninput="isNumber(this)">&nbsp;<button class="btn btn-primary">수정</button></td>
				<td>{{sum price qnt}}</td>
				<td><button class="btn btn-danger btn-sm" gid="{{gid}}">삭제</button></td>
			</tr>
		{{/each}}
		<tr>
			<td colspan="7" class="text-end pe-5"><h5>총합계 : <span id="sum">0원</span></h5></td>
		</tr>
	</table>
</script>
<script>
	Handlebars.registerHelper("sum", function(price, qnt){
		const sum=price*qnt;
		return sum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	});
</script>
<script>
	getList();
	
	$("#div_cart").on("click", ".btn-primary", function(){
		const row=$(this).parent().parent();
		const gid=row.find(".gid").text();
		const qnt=row.find(".qnt").val();
		if(confirm(gid + "상품의 수량을 " + qnt +"로 변경하실래요?")){
			$.ajax({
				type:"get",
				url:"/cart/update",
				data:{gid:gid, qnt:qnt},
				success:function(){
					getList();
				}
				
			})
		}
		
	})
	
	
	//숫자인 경우에만 입력
	function isNumber(item){
	    item.value=item.value.replace(/[^0-9]/g,'');
	}
	
	
	$("#div_cart").on("click", ".btn-danger", function(){
		const gid=$(this).attr("gid");
		if(confirm(gid+"번 상품을 삭제하실래요?")){
			$.ajax({
				type:"get",
				url:"/cart/delete",
				data:{gid:gid},
				success:function(){
					getList();
				}
			})
			
		}
	})
	
	
	function getList(){
		$.ajax({
			type:"get",
			url:"/cart/list.json",
			dataType:"json",
			success:function(data){
				const temp=Handlebars.compile($("#temp_cart").html());
				$("#div_cart").html(temp(data));
				getSum();
			}
		})
	}

	
	function getSum(){
		let sum=0;
		$("#div_cart .tr").each(function(){
			const price=$(this).attr("price");
			const qnt=$(this).find(".qnt").val();
			sum += price*qnt;
			console.log(price, qnt);
		});
		$("#sum").html(sum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
	}
</script>