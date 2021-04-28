package com.study.free.dao;

import java.sql.Connection;
import java.util.List;


import com.study.free.vo.FreeBoardVO;

public interface IFreeBoardDao {
	
	

	
	
  public List<FreeBoardVO> getBoardList(Connection conn) ;
  public FreeBoardVO getBoard(Connection conn, int boNo);
  public int increaseHit(Connection conn, int boNo);
  public int updateBoard(Connection conn, FreeBoardVO board);
  public int deleteBoard(Connection conn, FreeBoardVO board);
  public int insertBoard(Connection conn, FreeBoardVO board);
  
}
