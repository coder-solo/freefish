<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/decorator/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${root}/css/home.css" />
<script type="text/javascript">

$(function(){

	$(".cg-flip").on("click", function(e) {
		var selectedCg = $("input[name='cgRdo']:checked").val();
		
		var url = "${root}/article/list?categoryId=" + selectedCg;
		$.get(url, function(data){
			pickArticleList(data);
		});
	});
});

function pickArticleList(articleList) {
	var blogTimeUL = $("#blogTimeList");
	var content = "";
	
	for(var i = 0; i < articleList.length; i++) {
		var article = articleList[i];
		content += '<li><time class="blogTime"><span>' + article.month + '-' + article.day + '</span><span>' + article.year + '</span></time>';
		content += '<div class="blogTimeIcon"></div>';
		content += '<div class="blogTimeLabel" data-scroll-reveal="enter right over 1s" >';
		content += '<h2>' + article.title + '</h2><p>' + article.preview + '</p>';
		content += '<a href="${root}/article/' + article.year + '/' + article.month + '/' + article.code + '}" class="readmore">阅读全文&gt;&gt;</a></div></li>';
	}
	blogTimeUL.html(content);
}
</script>
<title>祥子·KEN的私房菜</title>
</head>
<body>

<%@ include file="/WEB-INF/view/decorator/head.jsp" %>
<article>
	<div class="container">
		<ul class="categoryList">
			<li>
				<input class="cg-flip" name="cgRdo" id="cg0" value="" type="radio" checked="checked"/>
				<label class="cg-btn" for="cg0" data-tg-off="全部" data-tg-on="全部"></label>
			</li>
			<c:forEach var="category" items="${categoryList}">
				<li>
					<input class="cg-flip" name="cgRdo" id="cg${category.id}" value="${category.id}" type="radio"/>
					<label class="cg-btn" for="cg${category.id}" data-tg-off="${category.name}" data-tg-on="${category.name}"></label>
				</li>
			</c:forEach>
		</ul>
		<ul id="blogTimeList" class="blogTimeList">
			<c:forEach var="article" items="${articleList}">
				<li>
					<time class="blogTime"><span>${article.month}-${article.day}</span><span>${article.year}</span></time>
					<div class="blogTimeIcon"></div>
					<div class="blogTimeLabel" data-scroll-reveal="enter right over 1s" >
						<h2>${article.title}</h2>
						<p>${article.preview}</p>
						<a href="${root}/article/${article.year}/${article.month}/${article.code}" class="readmore">阅读全文&gt;&gt;</a>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</article>

<%@ include file="/WEB-INF/view/decorator/foot.jsp" %>
</body>
</html>