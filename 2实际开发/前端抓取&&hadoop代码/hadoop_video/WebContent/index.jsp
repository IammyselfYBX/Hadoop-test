<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="hadoop.video.service.impl.Video"%>
<%@page import="hadoop.video.util.GetLine"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
div.center {
	position: absolute;
	left: 280px;
	top: 100px
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>hadoop_video</title>
</head>
<body>
	<p id="1">
	</p>
	<p id="2">
	</p>
	<center>
		<div class="center">
		<video id="v1" width="1200" height="600" controls="controls">
		<source src="test.mp4" type="video/mp4"></video>
	</div>
	</center>
	<script type="text/javascript">
		var startFlag = 0;
		var endFlag = 0;
		var mStartTime = 0;
		var mEndTime = 0;
		var controFlag = 0;
		var my_video = document.getElementById("v1");
		my_video.addEventListener("mousedown", mouseDown);
		my_video.addEventListener("mouseup", mouseUp);
		function mouseType(elmnt, clr) {
			elmnt.style.color = clr;
		}
		function mouseDown() {
			startFlag = 0;
			my_video.addEventListener("seeking", getSeekStart);
		}
		function mouseUp() {
			endFlag = 0;
			getSeekEnd();
		}
		function getSeekStart() {
			if ((my_video.seeking) && (startFlag != 1)) {
				mStartTime = my_video.currentTime;
				document.getElementById("1").innerHTML = mStartTime;
				controFlag = 1;
				returnParam();
				startFlag = 1;
			}
		}
		function getSeekEnd() {
			if (endFlag != 1) {
				mEndTime = my_video.currentTime;
				document.getElementById("2").innerHTML = mEndTime;
				endFlag = 1;
			}
		}
		function returnParam(){
			if(controFlag == 1){
				//传值：Url,Speed,StartTime,EndTime
				video_request = false;
				if (window.XMLHttpRequest) {
					video_request = new XMLHttpRequest();
				} else if (window.ActiveXObject) {
					try {
						video_request = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						try {
							video_request = new ActiveXObject(
									"Microsoft.XMLHTTP");
						} catch (e) {}
					}
				}
				video_request.open('POST',"/hadoop_video/ReturnServlet",true);
				video_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
				<%
					StringBuilder sb = new StringBuilder(request.getRemoteAddr().toString());
					for(int i=0;i<sb.length();i++){
						if(sb.charAt(i)==':'){
							sb.setCharAt(i, '.');
							}
						}
					String ip = sb.toString();
				%>
				var ip = "<%=ip%>";
				var param = new String();
					param="url="+window.location.href;
					param+="&id="+ip;
					param+="&length="+my_video.duration;
					param+="&startTime="+mEndTime;
					param+="&endTime="+mStartTime;
					param+="&speed="+my_video.defaultPlaybackRate;
				video_request.send(param);
				controFlag = 0;
			}
		}
	</script>
</body>
</html>
