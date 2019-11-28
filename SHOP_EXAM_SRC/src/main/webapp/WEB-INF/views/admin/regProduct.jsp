<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="exam.shop.dto.ShopMenuDto"  %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
	@SuppressWarnings("unchecked")
	List<ShopMenuDto> bigDivList = (List<ShopMenuDto>)request.getAttribute("bigDivList");

	@SuppressWarnings("unchecked")
	List<ShopMenuDto> smlDivList = (List<ShopMenuDto>)request.getAttribute("smlDivList");
%>  

<script src="<%=request.getContextPath() %>/js/jquery.js">
	
</script>
<script type="text/javascript">
var g_count = 2;
$(document).ready(function(){
	$("#addBtn").on("click",function(e){
		e.preventDefault();
		fn_fileAdd();
	})
})
/* $("#addBtn").click(function(){
	var picAmt = $("#picAmt").val();
	var addNum = picAmt+1;
	
	$("#productTb > tbody:last").append('<tr><td>'+addnum+'</td><td><input type="file" id="prdt_pic_'+addnum+'" name="prdt_pic_'+addnum+'"></td>' );
	
}); */

function fn_fileAdd(){
	if(g_count == 10){
		alert("최대 10개 까지");
		return;
	}
	var str = "<tr><td></td><td><input type='file' name='prdt_pic_"+(g_count++)+"'/></td></tr>";
	$("#productTb > tbody:last").append(str);
}

</script>
</head>
<body>
<input type="hidden" id="picAmt" name="picAmt" value="1">
<form action="/admin/regProductAf.do" name="uploadFrm" id="uploadFrm" method="post" enctype="multipart/form-data">
	<table id="productTb">
		<tbody>
			<tr>
				<td>상품명</td>
				<td><input type="text" id="prdt_name" name="prdt_name"></td>
			</tr>
			<tr>
				<td>상품 설명 사진</td>
				<td><input type="file" id="prdt_desc_pic" name="prdt_desc_pic"></td>
			</tr>
			
			<tr>
				<td>상품 대분류</td>
				<td>
					<select id="bDivCode" name="bDivCode">
						<option value="">선택</option>
						<%
						for(ShopMenuDto dto : bigDivList){
							%>
							<option value="<%=dto.getbDivCode() %>"><%=dto.getbDivName() %></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>상품 소분류</td>
				<td>
					<select id="sDivCode" name="sDivCode">
						<option value="">선택</option>
						<%
						for(ShopMenuDto dto : smlDivList){
							%>
							<option value="<%=dto.getsDivCode() %>"><%=dto.getsDivName() %></option>
							<%
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>상품 타입</td>
				<td>
					<select id="prdt_type" name="prdt_type">
						<option value="">선택</option>
						<option value="1">신상</option>				
						<option value="2">구제</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>상품 주의사항</td>
				<td><textarea id="prdt_warn" name="prdt_warn"></textarea></td>
			</tr>
			<tr>
				<td>상품 수량</td>
				<td><input type="text" name="prdt_amt" id="prdt_amt"></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><input type="text" name="prdt_price" id="prdt_price"></td>
			</tr>
			<tr>
				<td>브랜드</td>
				<td></td>
			</tr>
			<tr>
				<td>상품 사진</td>
				<td><input type="file" id="prdt_pic_1" name="prdt_pic_1"><button type="button" id="addBtn" name="addBtn">+</button><button type="button" id="delBtn" name="delBtn">-</button></td>
			</tr>
		</tbody>
	</table>
	<button type="submit">확인</button>
</form>
</body>
</html>