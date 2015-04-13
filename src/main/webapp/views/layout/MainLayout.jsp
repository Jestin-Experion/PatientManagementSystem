	<%@ include file="/views/common/taglibs.jsp"%>
	<%
	    response.setHeader("Pragma","no-cache"); //HTTP 1.0
	    response.setDateHeader ("Expires",0); //prevents caching at the proxy server
	    response.setHeader("Cache-Control","no-store");
	%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<!DOCTYPE html>
<html lang="en">
	<head>
	<!--[if IE]>
		<style type="text/css">
			.main {
				margin-top: 10px;
			}
		</style>
	<![endif]-->

<link rel="shortcut icon" href="../favicon-1.ico" type="image/x-icon"/>
<title>PMS - Patient Management System</title>

	</head>
	<body topmargin="0" >
	
		<div class="wrapper">
			<div class="aligner">
				<div class="container">
					<tiles:insertAttribute name="header" />
					<tiles:insertAttribute name="menu" />
					<tiles:insertAttribute name="mainBody" />
					<tiles:insertAttribute name="footer" />
				</div><!-- /container -->
			</div><!-- /aligner -->
		</div><!-- /wrapper -->
	</body>
</html>
