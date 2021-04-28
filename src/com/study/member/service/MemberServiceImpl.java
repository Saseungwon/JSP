package com.study.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.study.common.util.ConnectionProvider;
import com.study.exception.BizDuplicateKeyException;
import com.study.exception.BizNotEffectedException;
import com.study.exception.BizNotFoundException;
import com.study.exception.DaoException;
import com.study.member.dao.IMemberDao;
import com.study.member.dao.MemberDaoOracle;
import com.study.member.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private static MemberServiceImpl memberService= new MemberServiceImpl(); 
	private MemberServiceImpl() {};
	public static MemberServiceImpl getInstance() {
		return memberService; 
	}
	
	IMemberDao memberDao= MemberDaoOracle.getInstance(); 
	
	@Override
	public List<MemberVO> getMemberList() {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		return memberDao.getMemberList(conn);
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}

	@Override
	public MemberVO getMember(String memId) throws BizNotFoundException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		MemberVO member=memberDao.getMember(conn, memId);
		if(member==null) {
			throw new BizNotFoundException();
		}
		return member;
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}

	@Override
	public void modifyMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		MemberVO vo=memberDao.getMember(conn, member.getMemId());
		if(vo==null) {
			throw new BizNotFoundException();
		}
		int cnt=memberDao.updateMember(conn, member);
		if(cnt<1) {
			throw new BizNotEffectedException();
		}
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}

	@Override
	public void removeMember(MemberVO member) throws BizNotEffectedException, BizNotFoundException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		MemberVO vo=memberDao.getMember(conn, member.getMemId());
		if(vo==null) {
			throw new BizNotFoundException();
		}
		int cnt=memberDao.deleteMember(conn, member);
		if(cnt<1) {
			throw new BizNotEffectedException();
		}
		
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}

	@Override
	public void registMember(MemberVO member) throws BizNotEffectedException,BizDuplicateKeyException {
		Connection conn = null; 
		try {
			conn = ConnectionProvider.getConnection(); 
		MemberVO vo=memberDao.getMember(conn, member.getMemId());
		if(vo!=null) throw new BizDuplicateKeyException();
		int cnt=memberDao.insertMember(conn, member);
		if(cnt<1) throw new BizNotEffectedException();
	}catch (SQLException e) {
		throw new DaoException("getBoardList", e); 
	}finally {
		if(conn!=null) try {conn.close();} catch(Exception e) {
			
		}
	}
}

	

}
