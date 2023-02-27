package com.app.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardVO;
import com.app.mybatis.config.MyBatisConfig;

public class BoardDAO {
	public SqlSession sqlSession;
	
	public BoardDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	게시글 목록
	public List<BoardDTO> selectAll(Map<String, Object> pageMap){
		return sqlSession.selectList("board.selectAll", pageMap);
	}
	
//	게시글 총 개수
	public Long getTotal(Map<String, Object> searchMap) {
		return sqlSession.selectOne("board.getTotal", searchMap);
	}
	
//	게시글 조회
	public BoardDTO select(Long boardId) {
		return sqlSession.selectOne("board.select", boardId);
	}
	
}























