<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/decorator/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${root}/css/home.css" />
<script type="text/javascript">
$(function(){
/* 	$("figure a img").mouseover(function(){
		$(this).parent().next("figcaption").show();
	});
	$("figure figcaption").mouseout(function(){
		$(this).parent().next("figcaption").hide();
	}); */
});
</script>
<title>祥子·KEN的私房菜</title>
</head>
<body>

<%@ include file="/WEB-INF/view/decorator/head.jsp" %>
<article>
	<div class="container">
		<!-- <canvas id="bgCav"></canvas> -->
		<div class="blog" data-scroll-reveal="enter top" >
			<figure>
				<a href="${root}/index"><img src="images/home/pc05.jpg" style="width: 300px; height: 212px"></a>
				<figcaption>人生中有些事你不竭尽所能去做，你永远不知道你自己有多出色<br><b style="float: right;">-- 罗罗诺亚·索隆 《海贼王》</b></figcaption>
			</figure>
			<figure>
				<a href="${root}/index"><img src="images/home/pc07.jpg" style="width: 300px; height: 158px;"></a>
			</figure>
			<figure>
				<a href="${root}/index"><img src="images/home/pc01.jpg" style="width: 300px; height: 185px"></a>
				<figcaption>这个世界并不是掌握在那些嘲笑者的手中，而恰恰掌握在能够经受得住嘲笑与批评仍不断往前走的人手中<br><b style="float: right;">--《海贼王》</b></figcaption>
			</figure>
		</div>
		<ul class="blogTimeList">
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