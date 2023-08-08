<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row my-5">
	<div class="col">
		<h1 class="text-center">상품등록</h1>
		<form name="frm" class="card p-3" method="post" action="/goods/insert" enctype="multipart/form-data">
			<div class="input-group mb-3">
				<span class="input-group-text">상품이름</span>
				<input name="title" class="form-control">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">상품가격</span>
				<input name="price" class="form-control" oninput="isNumber(this)">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">제&nbsp;조&nbsp;사</span>
				<input name="maker" class="form-control">
			</div>
			<div class="input-group mb-3">
				<input name="image" type="file" class="form-control" accept="image/*">
			</div>
			<div>
				<img src="http://via.placeholder.com/100x50" width="100%" id="image">
			</div>
			<div class="text-center my-3">
				<input type="submit" value="상품등록" class="btn btn-primary">
				<input type="reset" value="등록취소" class="btn btn-secondary">
				
			</div>
		</form>
	</div>
</div>

<script>
	$(frm).on("submit", function(e){
		e.preventDefault();
		const title=$(frm.title).val();
		const price=$(frm.price).val();
		const image=$(frm.image).val();
		if(title=="" || price=="" || image=="") {
			alert("상품이름, 상품가격, 상품이미지를 꼭 입력하세요");
			$(frm.title).focus();
		} else {
			if(confirm("등록한 상품을 저장하실래요?")) {
				// 저장
				frm.submit();
			}
		}
	})


	// 이미지 미리보기
	$(frm.image).on("change", function(e) {
		$("#image").attr("src", URL.createObjectURL(e.target.files[0])); // 이미지가 들어있는 url을 만들어서 파일[0]에 대한 것을 src에 넣으줌
	});
	
	
	// 리셋인 경우
	$(frm).on("reset", function(){
		$("#image").attr("src", "http://via.placeholder.com/100x50")
	})
	
</script>