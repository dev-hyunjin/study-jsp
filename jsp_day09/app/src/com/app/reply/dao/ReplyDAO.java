package com.app.reply.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.reply.domain.ReplyDTO;
import com.app.reply.domain.ReplyVO;

public class ReplyDAO {
public SqlSession sqlSession;
	
	public ReplyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	댓글 추가
	public void insert(ReplyVO replyVO) {
		sqlSession.insert("reply.insert", replyVO);
	}
	
//	댓글 목록
	public List<ReplyDTO> selectAll(Map<String, Object> pageMap) {
		return sqlSession.selectList("reply.selectAll", pageMap);
	}
	
//	다음 페이지 유무(더보기)
	public boolean isNextPage(Map<String, Object> pageMap) {
		return sqlSession.selectList("reply.isNextPage", pageMap).size() != 0;
	}
}











