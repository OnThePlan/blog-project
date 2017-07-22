<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<link rel="stylesheet" href="/css/login.css" type="text/css" media="screen" charset="utf-8"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery -->
<script type="text/javascript">
	$(document)	.ready(function() {
		$("#loginbtn").click(function() {
			fn_check();
		});

		$("input").keydown(function (event) {
	        if (event.which === 13) {    //enter
	        	fn_check();
	        }
	    });
	});
	
	function fn_check(){
		if ($("#loginid").val() == "") {
			alert("로그인 아이디를 입력해주세요");
			$("#loginid").focus();
		} else if ($("#loginpwd").val() == "") {
			alert("로그인 비밀번호를 입력해주세요");
			$("#loginpwd").focus();
		} else {
			var str = "/j_spring_security_check";
			$("#loginfrm")
					.attr("action",
							"<c:url value='"+str+"'/>");
			$("#loginfrm").submit();
		}
	}
	
</script>
</head>
<body class="w3-theme-l3">
	<h1 class="w3-padding w3-text-white" >Login </h1> 
	<div id="login"  class="w3-display-middle ">
		<div class="login w3-white w3-card-4 w3-round-large w3-theme-l5" style="display: inline-block;">
			<div id="nextpage_info" class=" w3-card-2 w3-blue-gray">
			<i class="glyphicon glyphicon-user w3-panel w3-border w3-circle w3-padding-16" style="font-size:200%"></i> 
				<h1 class="" style="font-size:120%; "> USER LOGIN</h1>
			</div> 
			<br>
			<form id="loginfrm" name="loginfrm" method="POST" 	action="${ctx}/j_spring_security_check">
				<table style="margin:0% auto;  text-align:center;">
					<tr style="width: 70%; ">
						<td align="left" style=" color: #646363; font-size:80%; text-align:left; padding-left:1%;  min-width:80px;">
							사용자ID :
						</td>
						<td >
							<input class="w3-input w3-border w3-light-gray " style="margin:right:1%;" type="text" id="loginid" name="j_username" placeholder="아이디를 입력해 주세요" tabindex="1"/>
						</td>
					</tr>
					<tr>
						<td align="right" style="color: #646363; font-size:80%; text-align:left; padding-left:1%;">비밀번호 :</td>
						<td>
							<input class="w3-input w3-border w3-light-gray "  style="margin-top:10%; margin:right:1%;"	type="password" id="j_password" name="j_password" placeholder="비밀번호를 입력해 주세요" tabindex="2"/>
						</td>
					</tr>
					<!-- <tr>
						<td colspan="2" class=" w3-text-black "  style="text-align:right; font-size:90%;">	
							<a onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-text-gray">회원가입</a>
						</td>
					</tr> -->
					<c:if test="${not empty param.fail}">
						<tr>
							<td colspan="2" style="text-align:center; font-size:70%; "><font color="red"> 로그인에 실패했습니다.<br />
									정확한 사용자 정보를 입력해 주세요.
							</font> <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" />
							</td>
						</tr>
					</c:if>
				</table>
				<br>
				<p><button class="w3-btn w3-blue-gray w3-round-large  w3-margin" style="width:50%;">로그인</button></p>
			</form>
		</div>
	</div>
	</body>
</html>