package com.study.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.common.util.ConnectionProvider;
import com.study.exception.DaoDuplicateKeyException;
import com.study.exception.DaoException;
import com.study.member.vo.MemberVO;

public class MemberDaoOracle implements IMemberDao {
	private static MemberDaoOracle memberDao = new MemberDaoOracle();
	private MemberDaoOracle() {};
	public static MemberDaoOracle getInstance() {
		return memberDao;
	}

	@Override
	public List<MemberVO> getMemberList(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			StringBuffer sb=new StringBuffer();
			sb.append("select mem_id   ,mem_pass  ,mem_name    ");
			sb.append("       ,to_char(mem_bir,'YYYY-MM-DD') AS mem_bir   ");
			sb.append("       ,mem_zip ,mem_add1  ,mem_add2    ");
			sb.append("       ,mem_hp  ,mem_mail  ,mem_job     ");
			sb.append("       ,mem_like ,mem_mileage  ,mem_del_yn  ");
			sb.append("from member                             ");
			
			pstmt=conn.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			
			List<MemberVO> memberList=new ArrayList<MemberVO>();
			while(rs.next()){
				MemberVO member=new MemberVO();
				member.setMemId(rs.getString("mem_id"));
				member.setMemPass(rs.getString("mem_pass"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemBir(rs.getString("mem_bir"));
				member.setMemZip(rs.getString("mem_zip"));
				member.setMemAdd1(rs.getString("mem_Add1"));
				member.setMemAdd2(rs.getString("mem_Add2"));
				member.setMemHp(rs.getString("mem_hp"));
				member.setMemJob(rs.getString("mem_job"));
				member.setMemLike(rs.getString("mem_like"));
				member.setMemMileage(rs.getInt("mem_mileage"));
				member.setMemDelYn(rs.getString("mem_del_yn"));
				memberList.add(member);
			}
			return memberList;
		}catch (SQLException e){
			throw new DaoException(e.getMessage(),e);
		}finally{
			if (rs != null)try {rs.close();} catch (Exception e) {}
			if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
			if (conn != null)try {	conn.close();} catch (Exception e) {}
		}
	}

	@Override
	public MemberVO getMember(Connection conn, String memId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			sb.append("select mem_id,     mem_pass,     mem_name,          ");
			sb.append("       to_char(mem_bir,'YYYY-MM-DD') AS mem_bir,  mem_zip,      mem_add1,          ");
			sb.append("       mem_add2,   mem_hp,       mem_mail,          ");
			sb.append("       mem_job,   mem_like,       mem_mileage,      ");
			sb.append("       mem_del_yn                                   ");
			sb.append("from member                                         ");
			sb.append("where mem_id=    ? ");

			//pstmt객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			//pstmt ? 값 설정
			pstmt.setString(1, memId);
			//쿼리실행 
			rs = pstmt.executeQuery();
			MemberVO member=null;
			if (rs.next()) {
				member = new MemberVO();
				member.setMemId(rs.getString("mem_id"));
				member.setMemPass(rs.getString("mem_pass"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemBir(rs.getString("mem_bir"));
				member.setMemZip(rs.getString("mem_zip"));
				member.setMemAdd1(rs.getString("mem_add1"));
				member.setMemAdd2(rs.getString("mem_add2"));
				member.setMemHp(rs.getString("mem_hp"));
				member.setMemMail(rs.getString("mem_mail"));
				member.setMemJob(rs.getString("mem_job"));
				member.setMemLike(rs.getString("mem_like"));
				member.setMemMileage(rs.getInt("mem_mileage"));
				member.setMemDelYn(rs.getString("mem_del_yn"));
			}
			return member;
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		} finally {
			if (rs != null)try {rs.close();} catch (Exception e) {}
			if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
			if (conn != null)try {	conn.close();} catch (Exception e) {}
		}
	}

	@Override
	public int updateMember(Connection conn, MemberVO member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			sb.append("update member set      ");
			sb.append("mem_pass= ?             ,");  
			sb.append("mem_name= ?             ,");
			sb.append("mem_bir= ?             ,");
			sb.append("mem_zip= ?             ,");
			sb.append("mem_add1= ?             ,");
			sb.append("mem_add2= ?             , ");
			sb.append("mem_hp= ?             ,   ");
			sb.append("mem_mail= ?             , ");
			sb.append("mem_job= ?             ,  ");
			sb.append("mem_like= ?               ");
			sb.append("where  mem_id = ?         ");
			
			pstmt = conn.prepareStatement(sb.toString());
			
			int i =1;
			pstmt.setString(i++, member.getMemPass());
			pstmt.setString(i++, member.getMemName());
			pstmt.setString(i++, member.getMemBir());
			pstmt.setString(i++, member.getMemZip());
			pstmt.setString(i++, member.getMemAdd1());
			pstmt.setString(i++, member.getMemAdd2());
			pstmt.setString(i++, member.getMemHp());
			pstmt.setString(i++, member.getMemMail());
			pstmt.setString(i++, member.getMemJob());
			pstmt.setString(i++, member.getMemLike());
			pstmt.setString(i++, member.getMemId());
			//쿼리실행 
			int cnt=pstmt.executeUpdate();
			return cnt;
	
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		} finally {
			if (rs != null)try {rs.close();} catch (Exception e) {}
			if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
			if (conn != null)try {	conn.close();} catch (Exception e) {}
		}
	}

	@Override
	public int deleteMember(Connection conn, MemberVO member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			sb.append("update member set mem_del_yn= 'Y', ");
			sb.append("              mem_mileage=0 ");
			sb.append("where mem_id =?   ");

			//pstmt객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			//pstmt ? 값 설정
			pstmt.setString(1, member.getMemId());
			//쿼리실행 
			int cnt = pstmt.executeUpdate();
			
			return cnt;
		
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(),e);
		} finally {
			if (rs != null)try {rs.close();} catch (Exception e) {}
			if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
			if (conn != null)try {	conn.close();} catch (Exception e) {}
		}
	}

	@Override
	public int insertMember(Connection conn, MemberVO member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			StringBuffer sb = new StringBuffer();
			sb.append("insert into member values(   ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("?   , ");
			sb.append("0  , ");
			sb.append("'N'    ");
			sb.append(")");
			
			

			//pstmt객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			//pstmt ? 값 설정
			int i =1;
			
			pstmt.setString(i++, member.getMemId());
			pstmt.setString(i++, member.getMemPass());
			pstmt.setString(i++, member.getMemName());
			pstmt.setString(i++, member.getMemBir());
			pstmt.setString(i++, member.getMemZip());
			pstmt.setString(i++, member.getMemAdd1());
			pstmt.setString(i++, member.getMemAdd2());
			pstmt.setString(i++, member.getMemHp());
			pstmt.setString(i++, member.getMemMail());
			pstmt.setString(i++, member.getMemJob());
			pstmt.setString(i++, member.getMemLike());
			//쿼리실행 
			int cnt=pstmt.executeUpdate();
			
			return cnt;

		} catch (SQLException e) {
			if(e.getErrorCode()==1) throw new DaoDuplicateKeyException("중복된아이딘인데  여기서 말고 사실 서비스에서 잡지");
			throw new DaoException(e.getMessage(),e);
		} finally {
			if (rs != null)try {rs.close();} catch (Exception e) {}
			if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
			if (conn != null)try {	conn.close();} catch (Exception e) {}
		}
	}

}
