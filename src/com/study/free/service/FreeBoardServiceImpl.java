package com.study.free.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.study.common.util.ConnectionProvider;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.BizPasswordNotMatchedException;
import com.study.exception.DaoException;
import com.study.free.dao.FreeBoardDaoOracle;
import com.study.free.dao.IFreeBoardDao;
import com.study.free.vo.FreeBoardVO;

public class FreeBoardServiceImpl  implements IFreeBoardService{
	
	//private로 싱글턴 패턴 만들어줌 free에서 new로 되어있던 것들 다 FreeBoardServiceImpl.getInstance();로 바꿔줌
	private static FreeBoardServiceImpl freeBoardService = new FreeBoardServiceImpl(); 
	private FreeBoardServiceImpl() {}
	public static FreeBoardServiceImpl getInstance() {
		return freeBoardService; 
	}
	
	IFreeBoardDao freeBoardDao= FreeBoardDaoOracle.getInstance(); 
	
	@Override
	public List<FreeBoardVO> getBoardList() {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
			return freeBoardDao.getBoardList(conn);			
		}catch (SQLException e) {
			throw new DaoException("getBoardList", e); 
		}finally {
			if(conn!=null) try {conn.close();} catch(Exception e) {
				
			}
		}
	}
	
	@Override
	public FreeBoardVO getBoard(int boNo) throws BizNotFoundException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		
		FreeBoardVO free=freeBoardDao.getBoard(conn,boNo);
		if(free==null) {
			throw new BizNotFoundException();
		}
		return free;
		
		}catch (SQLException e) {
			throw new DaoException("getBoardList", e); 
		}finally {
			if(conn!=null) try {conn.close();} catch(Exception e) {
			}
			}
	}
	
		
		
		
	@Override
	public void increaseHit(int boNo) throws BizNotEffectedException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
			//conn.setAutoCommit(false);
			int cnt=freeBoardDao.increaseHit(conn, boNo);
			if(cnt<1) {
				throw new BizNotEffectedException();
			}
			//int cnt2=freeBoardDao.increaseMoney(); 
//			if(cnt2<1) {
//				conn.rollback();
//			throw new BizNotEffectedException(); 
//			}
		}catch (SQLException e) {
			throw new DaoException("increaseHit", e); 
		}finally {
			if(conn !=null)try {conn.close();} catch(Exception e2) {
				
			}
		}
	}
	
	@Override
	public void modifyBoard(FreeBoardVO free)
			throws BizNotFoundException, BizPasswordNotMatchedException, BizNotEffectedException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 		

		FreeBoardVO board=freeBoardDao.getBoard(conn, free.getBoNo());
		if(board==null) throw new BizNotFoundException();
		//board는 db안에 있는거,  free는 edit에서 입력한 값으로 저장된 거
		
		if(board.getBoPass().equals(free.getBoPass())) {
			int cnt=freeBoardDao.updateBoard(conn, free);
			if(cnt<1) throw new BizNotEffectedException();
		}else {
			throw new BizPasswordNotMatchedException();
		}
		
		
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}
	
	@Override
	public void removeBoard(FreeBoardVO free)
			throws BizNotFoundException, BizPasswordNotMatchedException, BizNotEffectedException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		FreeBoardVO board=freeBoardDao.getBoard(conn, free.getBoNo());
		if(board==null) throw new BizNotFoundException();
		//board는 db안에 있는거,  free는 edit에서 입력한 값으로 저장된 거
		
		if(board.getBoPass().equals(free.getBoPass())) {
			int cnt=freeBoardDao.deleteBoard(conn, free);
			if(cnt<1) throw new BizNotEffectedException();
		}else {
			throw new BizPasswordNotMatchedException();
		}
		
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}
	
	@Override
	public void registBoard(FreeBoardVO free)  throws BizNotEffectedException{
		
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		int cnt=freeBoardDao.insertBoard(conn, free);
		if(cnt<1) {
			throw new BizNotEffectedException();
		}
		
		}catch (SQLException e) {
			throw new DaoException("getBoardList", e); 
		}
		finally {
			if(conn!=null) try {conn.close();} catch(Exception e) {
				
			}
		}
	}
}
	
	
