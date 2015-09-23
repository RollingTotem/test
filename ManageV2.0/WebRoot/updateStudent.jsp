<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <html>
    <style type="text/css">
	  body{
	  	background:url("/picture/scut.jpg");
		background-size:1380px 768px;
		background-repeat: repeat-y; 
	  }
	</style>
		<body style="background-color: #fffff5;background-image: url('/picture/picture1.jpg');">
		<div align="right"> 
				<div style="float: left;margin-left: 30px;margin-top: 50px">
						<br><br>
						<jsp:include page="/test_left.jsp"/>
				</div>
					<br><br>
				<div style="float: left;margin-left: 30px">
						<jsp:include page="/test_top.jsp"></jsp:include>
						<br>
				</div>
		</div>
			<div style="float: left;margin-left: 30px">
				<table border="1" width="500px" style="background-image: url('/picture/picture4.jpg');">
					<tr><td>
					<form action="/manage/studentaction!updateStudent.action?updatemode=1" style="margin-left: 10px" method="post">
						学            号<input type="text" value="${singlestudent.stu_no }" name="singlestudent.stu_no"> 
						姓        名<input type="text" value="${singlestudent.stu_name }" name="singlestudent.stu_name"><br>
						学            院<input type="text" value="${singlestudent.maj_no }" name="singlestudent.maj_no">  
						身份证号<input type="text" value="${singlestudent.stu_idnum }" name="singlestudent.stu_idnum"><br>
						<hr>
						性            别<input type="text" value="${singlestudent.stu_gender }" name="singlestudent.stu_gender"> 
						出生年月<input type="date" value="${singlestudent.stu_birth }" name="singlestudent.stu_birth"><br>
						籍        贯<input type="text" value="${singlestudent.stu_home }" name="singlestudent.stu_home"> 
						通讯号码<input type="text" value="${singlestudent.stu_phone }" name="singlestudent.stu_phone"><br>
						登录密码<input type="text" value="${singlestudent.stu_psw }" name="singlestudent.stu_psw"> <br>
						<hr>
						<input type="reset" value="清除" style="margin-left: 360px">
						<input type="submit" value="提交"><br>
					</form>
					</td></tr>
				</table>
			</div>
		</body>
	</html>