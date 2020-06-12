package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardCommentVO;

import util.DBManager;

public class BoardCommentDAO {
	private BoardCommentDAO() {
	}

	private static BoardCommentDAO instance = new BoardCommentDAO();

	public static BoardCommentDAO getInstance() {
		return instance;
	}
	
	public List<BoardCommentVO> selectAllBoards(String num) {
		String sql = "select * from commentboard where num=? order by num desc ";
		List<BoardCommentVO> List = new ArrayList<BoardCommentVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardCommentVO bVo = new BoardCommentVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setId(rs.getString("id"));
				bVo.setName(rs.getString("name"));
				bVo.setSubtitle(rs.getString("subtitle"));
				bVo.setCdate(rs.getTimestamp("cdate"));
				List.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return List;
	}

	public void insertCommentBoard(BoardCommentVO bVo) {
		String sql = "insert into Commentboard (num,id,name,subtitle) values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("여기");
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bVo.getNum());
			pstmt.setString(2, bVo.getId());
			pstmt.setString(3, bVo.getName());
			pstmt.setString(4, bVo.getSubtitle());
			pstmt.executeQuery();
			System.out.println("dudud");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void updateReadCount(String num) {
		// TODO Auto-generated method stub
		
	}

	public BoardCommentVO selectOneBoardByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BoardCommentVO> selectAllBoards() {
		// TODO Auto-generated method stub
		return null;
	}
}
