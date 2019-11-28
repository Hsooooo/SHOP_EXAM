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
		alert("�ִ� 10�� ����");
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
				<td>��ǰ��</td>
				<td><input type="text" id="prdt_name" name="prdt_name"></td>
			</tr>
			<tr>
				<td>��ǰ ���� ����</td>
				<td><input type="file" id="prdt_desc_pic" name="prdt_desc_pic"></td>
			</tr>
			
			<tr>
				<td>��ǰ ��з�</td>
				<td>
					<select id="bDivCode" name="bDivCode">
						<option value="">����</option>
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
				<td>��ǰ �Һз�</td>
				<td>
					<select id="sDivCode" name="sDivCode">
						<option value="">����</option>
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
				<td>��ǰ Ÿ��</td>
				<td>
					<select id="prdt_type" name="prdt_type">
						<option value="">����</option>
						<option value="1">�Ż�</option>				
						<option value="2">����</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>��ǰ ���ǻ���</td>
				<td><textarea id="prdt_warn" name="prdt_warn"></textarea></td>
			</tr>
			<tr>
				<td>��ǰ ����</td>
				<td><input type="text" name="prdt_amt" id="prdt_amt"></td>
			</tr>
			<tr>
				<td>��ǰ ����</td>
				<td><input type="text" name="prdt_price" id="prdt_price"></td>
			</tr>
			<tr>
				<td>�귣��</td>
				<td></td>
			</tr>
			<tr>
				<td>��ǰ ����</td>
				<td><input type="file" id="prdt_pic_1" name="prdt_pic_1"><button type="button" id="addBtn" name="addBtn">+</button><button type="button" id="delBtn" name="delBtn">-</button></td>
			</tr>
		</tbody>
	</table>
	<button type="submit">Ȯ��</button>
</form>
</body>
</html>