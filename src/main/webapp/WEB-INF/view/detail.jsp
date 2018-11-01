<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/decorator/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${root}/css/home.css" />
<script type="text/javascript">
</script>
<title>博客</title>
</head>
<body>

<%@ include file="/WEB-INF/view/decorator/head.jsp" %>
<article>
	<div class="container">
		<div class="blog">
			<iframe id="blogFrame" class="bframe" onload="blogFrame.height=blogFrame.contentDocument.body.scrollHeight" src="${root}/article/${article.year}/${article.month}/${article.code}.html"></iframe>
		</div>
	</div>
</article>

<%@ include file="/WEB-INF/view/decorator/foot.jsp" %>
</body>
</html>