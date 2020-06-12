package com.saeyan.controller.commentAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardCommentDAO;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardCommentVO;
import com.saeyan.dto.BoardVO;

public class CommentWriteFormAction implements CommentAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/comment/CommentWrite.jsp";
		String num = request.getParameter("num");
		BoardDAO bDao = BoardDAO.getInstance();
		
		HttpSession session = request.getSession();
		String iid = (String)session.getAttribute("userid");
		
		BoardCommentDAO bcDao = BoardCommentDAO.getInstance();
		List<BoardCommentVO> CommentboardList = bcDao.selectAllBoards(num);
		request.setAttribute("List", CommentboardList);		
		
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
