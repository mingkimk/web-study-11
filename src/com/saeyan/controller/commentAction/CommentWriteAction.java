package com.saeyan.controller.commentAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardListAction;
import com.saeyan.dao.BoardCommentDAO;
import com.saeyan.dto.BoardCommentVO;

public class CommentWriteAction implements CommentAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardCommentVO bVo = new BoardCommentVO();
		
		HttpSession session = request.getSession();
		//String iid = (String)session.getAttribute("userid");
		int num = Integer.valueOf(request.getParameter("num"));
		
		bVo.setNum(num);
	
		bVo.setId((String)session.getAttribute("id"));
		bVo.setName(request.getParameter("name"));
		bVo.setSubtitle(request.getParameter("subtitle"));
		BoardCommentDAO bDao = BoardCommentDAO.getInstance();
		bDao.insertCommentBoard(bVo);
	
		//new CommentListAction().execute(request, response);
		
		response.sendRedirect("http://localhost:8080/web-study-11/commentServlet?CommentServlet?command=Comment_Write&num="+num);

		
	}
}
