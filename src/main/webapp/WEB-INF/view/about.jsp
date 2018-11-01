<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/view/decorator/common.jsp" %>
<link rel="stylesheet" type="text/css" href="${root}/css/about.css" />
<script type="text/javascript">
$(function(){
});
</script>
<title>祥子·KEN的私房菜</title>
</head>
<body>

<%@ include file="/WEB-INF/view/decorator/head.jsp" %>
<article>
	<div class="container">
		<div class="memorial_day">
			<div class="time_axis"></div>
			<ul>
				<li class="n1"><span>第一份工作</span>
					<div class="dateview">2012</div>
				</li>
				<li class="n2"><span>第一篇博客</span>
					<div class="dateview">2015-07</div>
				</li>
				<li class="n3"><span>个人博客上线</span>
					<div class="dateview">2018-03</div>
				</li>
				<li class="n4"><span>持续装修中。。。</span>
					<div class="dateview">2018-XX</div>
				</li>
			</ul>
		</div>
		<div class="about left">
			<h2>About Me</h2>
			<p>Ken,一个居于二线城市的IT人，每天重复着增删改查的工作，趋于平淡。</p>
			<p>但，平淡中亦有梦想，愿此博客像种子一样，生根发芽···</p>

			<h2>About Blog</h2>
			<p>此博客于2018年03月上线，但持续进行装修中。后续计划持续添加博客内容、留言板、常用工具、知识图谱等。</p>
			
			<p>博客前端：参考<a href="http://www.yangqq.com/" target="_blank">杨青青博客模板</a>（我知道画虎不成反类犬:D）</p>
			<p>博客后端：SpringMVC + sqlite</p>
			<p>服务器：<a href="https://www.aliyun.com/" target="_blank">阿里云服务器</a></p>

			<p>特别感谢: <a href="http://www.freefish.wang/saber" target="_blank">Heen</a></p>
		</div>
	</div>
</article>

<%@ include file="/WEB-INF/view/decorator/foot.jsp" %>
</body>
</html>