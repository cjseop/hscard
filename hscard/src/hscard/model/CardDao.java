package hscard.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hscard.bean.HsNameIma;
import hscard.bean.Hscard;
import hscard.bean.HscardValue;

public class CardDao extends SuperDao {
	
	public int InsertCard(Hscard cardBean){
		PreparedStatement pstmt = null;
		int cnt = -99999;
		try {
				super.conn = super.getConnection();
				super.conn.setAutoCommit(false);
				String sql = "insert into HSCARD (name, cost, grade, job, kind, effect, content, cardset, image) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = super.conn.prepareStatement(sql);
				pstmt.setString(1, cardBean.getCardName());
				pstmt.setInt(2, cardBean.getCost());
				pstmt.setInt(3, cardBean.getGrade());
				pstmt.setInt(4, cardBean.getJob());
				pstmt.setInt(5, cardBean.getKind());
				pstmt.setString(6, cardBean.getEffect());
				pstmt.setString(7, cardBean.getContent());
				pstmt.setInt(8, cardBean.getCardSet());
				pstmt.setString(9, cardBean.getImage());
				cnt = pstmt.executeUpdate();
				conn.commit();
		} catch (SQLException e) {
			SQLException err = (SQLException)e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
				super.closeConnection();
		}
		return cnt;
	}
	
	public HscardValue getCardByCardName(String cardName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HscardValue cardBean = new HscardValue();
		try {
				super.conn = super.getConnection();
				String sql = "select * from hscard where name = ?";
				pstmt = super.conn.prepareStatement(sql);
				pstmt.setString(1, cardName);
				rs = pstmt.executeQuery();
				while(rs.next()){
				cardBean.setCardName(rs.getString("name"));
				cardBean.setCardSet(rs.getString("cardset"));
				cardBean.setContent(rs.getString("content"));
				cardBean.setCost(rs.getInt("cost"));
				cardBean.setEffect(rs.getString("effect"));
				cardBean.setGrade(rs.getString("grade"));
				cardBean.setImage(rs.getString("image"));
				cardBean.setJob(rs.getString("job"));
				cardBean.setKind(rs.getString("kind"));
				//System.out.println("card" + cardBean);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeConnection();
		}
		return cardBean;
	}
	
	public List<HsNameIma> getNameImagebyjob(int jobNumber) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HsNameIma> list = new ArrayList<HsNameIma>();
		try {
			super.conn = super.getConnection();
			String sql = "select name, image from hscard where job = ? order by cost";
			pstmt = super.conn.prepareStatement(sql);
			pstmt.setInt(1, jobNumber);
			rs = pstmt.executeQuery();
			while(rs.next()){
			HsNameIma bean = new HsNameIma();
			bean.setCardName(rs.getString("name"));
			bean.setImage(rs.getString("image"));
			list.add(bean);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		super.closeConnection();
	}
	return list;
	}

	public List<HsNameIma> getNameImagebySearch(int searchJob, int searchCost, int searchCardset, String searchName, int begin, int end) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HsNameIma> list = new ArrayList<HsNameIma>();
		try {
			super.conn = super.getConnection();
			String sql = "select name, image, ranking from (";
					sql += " select name, image, ROW_NUMBER() OVER(order by cost) as ranking from hscard where job = " + searchJob;
			if(searchCost > -1){
				if(searchCost >= 7){
					sql += " and cost >= "+ searchCost;	
				}else{
					sql += " and cost = "+ searchCost;
				}
			}
			if(searchCardset > 0){
				sql += " and cardset = " + searchCardset;
			}
			searchName.trim();
			if(searchName.length() > 0){
				sql += " and name like '%" + searchName + "%'";
			}
				sql += " ) where ranking between " + begin + " and " + end;
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
			HsNameIma bean = new HsNameIma();
			bean.setCardName(rs.getString("name"));
			bean.setImage(rs.getString("image"));
			list.add(bean);
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		super.closeConnection();
	}
	return list;
	}

	public int getTotalCountByContidion(int searchJob, int searchCost, int searchCardset, String searchName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int toTalcount = 0;
		try {
			super.conn = super.getConnection();
			String sql = "select count(*) as cnt from hscard where job = " + searchJob;
			if(searchCost > -1){
				if(searchCost >= 7){
					sql += " and cost >= "+ searchCost;	
				}else{
					sql += " and cost = "+ searchCost;
				}
			}
			if(searchCardset > 0){
				sql += " and cardset = " + searchCardset;
			}
			searchName.trim();
			if(searchName.length() > 0){
				sql += " and name like '%" + searchName + "%'";
			}
			pstmt = super.conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				toTalcount = rs.getInt("cnt");
			}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		super.closeConnection();
	}
	return toTalcount;
	}

	public int DeleteCard(String cardName) {
		PreparedStatement pstmt = null;
		int cnt = -99999;
		try {
				super.conn = super.getConnection();
				super.conn.setAutoCommit(false);
				String sql = "delete HSCARD where name = ?";
				pstmt = super.conn.prepareStatement(sql);
				pstmt.setString(1, cardName);
				cnt = pstmt.executeUpdate();
				conn.commit();
		} catch (SQLException e) {
			SQLException err = (SQLException)e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
				super.closeConnection();
		}
		return cnt;
	}

	public int updateCard(Hscard cardBean) {
		PreparedStatement pstmt = null;
		int cnt = -99999;
		try {
				super.conn = super.getConnection();
				super.conn.setAutoCommit(false);
				String sql = "update HSCARD set cost = ?, grade = ?, job = ?, kind = ?, effect = ?, content = ?, cardset = ?, image = ? where name = ?";
				pstmt = super.conn.prepareStatement(sql);
				pstmt.setInt(1, cardBean.getCost());
				pstmt.setInt(2, cardBean.getGrade());
				pstmt.setInt(3, cardBean.getJob());
				pstmt.setInt(4, cardBean.getKind());
				pstmt.setString(5, cardBean.getEffect());
				pstmt.setString(6, cardBean.getContent());
				pstmt.setInt(7, cardBean.getCardSet());
				pstmt.setString(8, cardBean.getImage());
				pstmt.setString(9, cardBean.getCardName());
				cnt = pstmt.executeUpdate();
				conn.commit();
		} catch (SQLException e) {
			SQLException err = (SQLException)e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
				super.closeConnection();
		}
		return cnt;
	}
}
