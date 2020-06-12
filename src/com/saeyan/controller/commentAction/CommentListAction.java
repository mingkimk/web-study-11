package com.saeyan.controller.commentAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardCommentDAO;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardCommentVO;
import com.saeyan.dto.BoardVO;

public class CommentListAction implements CommentAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/comment/CommentList.jsp";
		BoardCommentDAO bDao = BoardCommentDAO.getInstance();
		List<BoardCommentVO> List = bDao.selectAllBoards();
		if(List != null) {
			request.setAttribute("List", List);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
