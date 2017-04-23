
function initHeader(){
	var headerContainer = document.getElementById('header_container');
	headerContainer.innerHTML = headerHtml();

	var Obanner = document.getElementById('banner');
 			var Opoint = document.getElementById('point_box');
 			var Opoint_li = Opoint.getElementsByTagName('li');
 			var Obanner_li = Obanner.getElementsByClassName('banner_li');
 			var Oheader = document.getElementsByClassName("header")[0];

 			var style = document.getElementById("style");
 			//var Ow = document.getElementById('w');

 			//getElementsByTagName('li');
		 	var img_time=2; //banner几张图片
		 	var owidth=0;
		 	var page=0;
		 	var timer=0;
		 	var imgOpacity;
		 	var header_height=0;
		 	var banner_height=0;
		 	var headeriframe=0;
		 	//window.parent['headeriframe'].setAttribute('style','height:800px');
		 	function getStyle(obj,attr){//obj.style.width这种是取行间样式。为了能在任何情况下能取到值！
			    if(obj.currentStyle){
			        return obj.currentStyle[attr];
			    }else{
			        return getComputedStyle(obj,false)[attr];
			    }
			}
			$(".nav a").each(function(){
				var href = $(this).attr('href');
				if(window.location.pathname.search(href)!=-1){
					$(this).addClass('active');
				};

			})
			header_height=getStyle(Oheader,'height');
			banner_height=getStyle(Obanner,'height');		
			headeriframe=parseInt(banner_height.split("px")[0])+parseInt(header_height.split("px")[0]);
			//alert(headeriframe);
			//window.parent['headeriframe'].setAttribute('style','height:'+headeriframe+'px');
		 	timer = setInterval(bannerList,3000);

		 	for(var i=1; i<=img_time ; i++){
		 		var banner_li = document.createElement('li');
		 		Obanner.appendChild(banner_li);
		 		banner_li.setAttribute('style',"background:url("+resRoot+"/images/background"+i+".jpeg) 50% 0 no-repeat;");   
		 		banner_li.setAttribute('class', 'banner_li');

		 		var point_li = document.createElement('li');
		 		Opoint.appendChild(point_li);
				owidth=owidth+24;
		 	}
		 	Opoint.style.width=owidth+'px';
		 	Opoint.style.marginLeft=-(owidth/2)+'px';
		 	Opoint_li[0].setAttribute('class','active');

		 	initPointEvent();
			
		function bannerList(){
			page++;
			if(page<0){
				page=Opoint_li.length-1;
			}else if(page>Opoint_li.length-1){
				page=0;
			}
			bannerMove();
			imgOpacity();
			//alert('1111');

		}
		function bannerMove(){
			//console.info(page);
			Opoint_li[page].click();
		}
		function initPointEvent(){
			 	for(var i=0; i<Opoint_li.length ;i++){
			 		Opoint_li[i].setAttribute('index',i);
			 		Opoint_li[i].onclick = function(){
			 			clearInterval(timer);
			 			page=this.getAttribute('index');
			 			for(var j=0; j<Opoint_li.length ;j++){
			 				Opoint_li[j].className=Opoint_li[j].className.replace('active','');
			 				Obanner_li[j].style.display = 'none';

			 			}
				 		this.className=this.className+' active';
				 		Obanner_li[page].style.display = 'block';
				 		timer = setInterval(bannerList,3000);
			 		}

			 	}
		 }

		function imgOpacity(){
			style.innerHTML="@keyframes gradient{0%{ opacity:0.4; filter:alpha(opacity:40);}\n"
						+"30%{opacity: 1; filter:alpha(opacity:100);}\n"
						+"100%{opacity: 1; filter:alpha(opacity:100);}\n"
						+"}\n"
						+"@-ms-@keyframes gradient{0%{ opacity:0.4;filter:alpha(opacity:40);}\n"
						+"30%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"100%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"}\n"
						+"@-o-@keyframes gradient{0%{ opacity:0.4;filter:alpha(opacity:40);}\n"
						+"30%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"100%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"}\n"
						+"@-moz-@keyframes gradient{0%{ opacity:0.4;filter:alpha(opacity:40);}\n"
						+"30%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"100%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"}\n"
						+"@-webkit-@keyframes gradient{0%{ opacity:0.4;filter:alpha(opacity:40);}\n"
						+"30%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"100%{opacity: 1;filter:alpha(opacity:100);}\n"
						+"}"

	//alert('111');
		}
}

function headerHtml(){
	var html='';
	html += '<style id="style"></style>';
	html += '<div id="header" class="header" style="heigth:94px;" >';
	html += '	<div class="logo">';
	html += '		<img src="'+resRoot+'/images/LOGO3.png">';
	html += '	</div>';
	html += '	<div class="nav">';
	html += '		<ul>';
	html += '			<li><a href="index">首页</a></li>';
	html += '			<li><a href="product_display">产品展示</a></li>';
	html += '			<li><a href="about-us">关于我们</a></li>';
	html += '			<li><a href="contact-us">联系我们</a></li>';
	html += '		</ul>';
	html += '	</div>';
	html += '</div> ';
	html += '<ul id="banner" class="banner" style="height:641px;">';
	html += '	<ul id="point_box" class="point_box">';
	html += '	</ul>';
	html += '</ul>';

	return html;
}
initHeader();