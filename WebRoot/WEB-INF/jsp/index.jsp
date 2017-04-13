<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>望苑茗茶</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<jsp:include page="comm/header.jsp"></jsp:include>
	<div class="layout">
		<div class="content">
			<div class="item index-item item-img-right">
				<div class="item-content">
					<div class="item-info">
						<div class="item-info-title">
							<span>关于我们</span>
						</div>
						<div class="item-info-text">
							<p><span>汕头市兰亭茶业有限公司追求味觉的享受和顶尖的料理享受，最新鲜的食材，最具特色的厨师，一心打造老饕盛宴。</span></p>
							<p class="wrap"></p>
							<p><span>这里起源于最优美的十四行诗，新鲜罗勒和阳关海岸；</span></p>
							<p><span>这里源自于清淡幽雅的俳句，极致的清淡鲜美与味至顶点的酽重；</span></p>
							<p><span>这里脱胎于包罗万象的历史文华，无与伦比的盛宴和家常小菜都做到极致。</span></p>
							<p class="wrap"></p>
							<p><span>烟火气同诗句，打造最为美味的享受。</span></p>
						</div>
					</div>
					<img src="${resRoot}/images/index/index-img1.png">
				</div>
			</div>
		</div>
		<div class="view-banner">
			<img src="${resRoot}/images/index/view-banner.jpeg">
		</div>
	</div>
</body>
</html>
