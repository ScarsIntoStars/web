<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row my-5">
	<div class="col">
		<h1 class="text-center">상품수정</h1>
		<form name="frm" class="card p-3" method="post" action="/goods/update" enctype="multipart/form-data">
			<div class="input-group mb-3">
				<span class="input-group-text">상품코드</span>
				<input name="gid" class="form-control" value="${vo.gid}" readonly>
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">상품이름</span>
				<input name="title" class="form-control" value="${vo.title}">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">상품가격</span>
				<input name="price" class="form-control" oninput="isNumber(this)" value="${vo.price}">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">제&nbsp;조&nbsp;사</span>
				<input name="maker" class="form-control" value="${vo.maker}">
			</div>
			<div class="input-group mb-3">
				<input name="image" type="file" class="form-control" accept="image/*">
				<input name="oldImage" value="${vo.image}" type="hidden">
			</div>
			<div>
				<img src="${vo.image}" width="100%" id="image">
			</div>
			<div class="text-center my-3">
				<input type="submit" value="상품수정" class="btn btn-primary">
				<input type="reset" value="수정취소" class="btn btn-secondary">
				
			</div>
		</form>
	</div>
</div>

<script>
	const oldImage="${vo.image}";


	$(frm).on("submit", function(e){
		e.preventDefault();
		const title=$(frm.title).val();
		const price=$(frm.price).val();
		if(title=="" || price=="") {
			alert("상품이름, 상품가격을 꼭 입력하세요");
			$(frm.title).focus();
		} else {
			if(confirm("등록한 상품정보를 수정하실래요?")) {
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
		$("#image").attr("src", oldImage)
	})
	
</script>