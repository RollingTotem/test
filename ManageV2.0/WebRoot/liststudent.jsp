<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<style type="text/css">
	  body{
	  	background:url("/scut.jpg");
		background-size:1380px 768px;
		background-repeat: repeat-y; 
	  }
	</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>华南理工大学学生管理系统</title>
	</head>
	<body style="background-color: #fffff5;background-image: url('/picture/picture8.jpg');">
		<h3>华南理工大学教务处管理系统</h3>
		<div>
			<div style="width:100% ;float: left">
				<div style="float: left;margin-left: 30px">
					<br><br><br>
					<jsp:include page="/test_left.jsp"/>
				</div>
				<div style="position: relative ;left:80px;">
					<jsp:include page="/test_top.jsp"></jsp:include>
				</div>
				<br>
				<div style="position: relative ;left:80px;">
					<form action="/manage/studentaction!execute.action?searchmode=2" method="post">
						<!-- <table border="1" style="width: 150px"> -->
						<table border="1" width="800px" style="background-image: url('/picture/picture3.jpg');">
							<tr><td>
								学号<input type="text" name="searchno" style="width: 80px">
								姓名<input type="text" name="searchname" style="width: 80px" >
								学院<input type="text" style="width: 80px">
								籍贯<input type="text" name="searchhome" style="width: 80px">
								<input type="reset" value="清除" style="width: 50px">
								<input type="submit" value="查询" style="width: 50px">
								<input type="button" value="增加" onclick="window.location.href='/manage/studentaction!addStudent.action?addmode=0'" style="width: 50px">
							</td></tr>
							</table>
						<!-- </table> -->
					</form>
				</div>
				<br>
				<div style="position: relative ;left:80px;">
					<table border="1" width="800px" style="background-image: url('/picture/table_background.jpg');">
						<tr>
							<td width="100" height="40px">学号</td>
							<td width="80" height="40px">姓名</td>
							<td width="80" height="40px">现居地</td>
							<td width="40" height="40px">性别</td>
							<td width="80" height="40px">操作</td>
						</tr>
						<c:forEach var="t" items="${students}" varStatus="stauts">
							<tr style="width: 160px">
								<td style="width: 60px">
										${t.stu_no}</td>
								<td>${t.stu_name}</td>
								<td>${t.stu_home}</td>
								<td><c:if test="${t.stu_gender=='1'}">女</c:if>
									<c:if test="${t.stu_gender=='0'}">男</c:if> </td>
								<td><input type="button" value="删除" onclick="doDel(${t.stu_no});">
									<input type="button" value="修改" onclick="doUpdate(${t.stu_no});"></td>
							</tr>
						</c:forEach>
					</table>
					<table border="1" width="800px" height="60px" style="position: absolute; ;left:180px;">
						<tr><td>
								<form action="/manage/studentaction.action?yema=1" method="post" style="margin-left: 350px">
									每页显示<input type="text" name="yeshu" style="width: 30px" value="${yeshu }">
									<input type="submit" value="确定">
									<input type="button" onclick="window.location.href='/manage/studentaction.action?yema=1&&yeshu=${yeshu }'" value="首页">
									<input type="button" onclick="window.location.href='/manage/studentaction.action?yema=${yema+1 }&&yeshu=${yeshu }'" value="下一页">
									第${yema }页
									<input type="button" onclick="window.location.href='/manage/studentaction.action?yema=${yema-1 }&&yeshu=${yeshu }'" value="上一页">
								</form>
						</td></tr>
					</table>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			function doDel(id){
			  alert("确定删除?");
			  window.location.href="/manage/studentaction!deleteStudent.action?stu_no="+id;
			}
			
			function doUpdate(id){
				//alert("确定更新？");
				window.location.href="/manage/studentaction!updateStudent.action?updatemode=0&&stu_no="+id;
			}
		</script>
		<br><br>
	</body>
</html>