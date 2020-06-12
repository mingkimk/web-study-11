package com.saeyan.controller.commentAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardCommentDAO;
import com.saeyan.dto.BoardCommentVO;

public class CommentViewAction implements CommentAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/comment/CommentView.jsp";
		String num = request.getParameter("num");
		
		BoardCommentDAO bDao = BoardCommentDAO.getInstance();
		bDao.updateReadCount(num);
		
		
		BoardCommentVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
