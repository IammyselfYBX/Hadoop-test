package hadoop.video.servlet;

import hadoop.video.service.impl.Video;
import hadoop.video.util.GetLine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ReturnServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// doGet
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// doPost
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		int flag_video = 0;
		if(request.getParameter("url")!=null){
			video.setUrl(request.getParameter("url"));
			flag_video++;
		}
		if(request.getParameter("id")!=null){
			video.setId(request.getParameter("id"));
			flag_video++;
		}
		if(request.getParameter("length")!=null){
			video.setLength(Double.parseDouble(request.getParameter("length")));
			flag_video++;
		}
		if(request.getParameter("startTime")!=null){
			video.setStartTime(Double.parseDouble(request.getParameter("startTime")));
			flag_video++;
		}
		if(request.getParameter("endTime")!=null){
			video.setEndTime(Double.parseDouble(request.getParameter("endTime")));
			flag_video++;
		}
		if(request.getParameter("speed")!=null){
			video.setSpeed(Double.parseDouble(request.getParameter("speed")));
			flag_video++;
		}
		if(flag_video==6){
			GetLine.newInstase().getLine(video);
			flag_video=0;
		}
	}
}
