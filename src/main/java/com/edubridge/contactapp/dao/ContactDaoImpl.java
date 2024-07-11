package com.edubridge.contactapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.contactapp.model.contact;
import com.edubridge.contactapp.util.DBUtils;

public class ContactDaoImpl implements ContactDao {

	@Override
	public int addContact(contact c) {
		String INSERT ="insert into contact(name,email,mobile)values(?,?,?)";
		Connection con=DBUtils.getConnection();
		int status=0;
		
	try {
		PreparedStatement ps=con.prepareStatement(INSERT);
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setLong(3, c.getMobile());
		
		status=ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<contact> getAllcontacts() {
		String SELECT ="select * from contact";
		Connection con=DBUtils.getConnection();
		List<contact> contacts=new ArrayList<contact>();
		
		try {
			PreparedStatement ps=con.prepareStatement(SELECT);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				contact c=new contact();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setMobile(rs.getLong("mobile"));
				contacts.add(c);
				
		}
			
	}catch (SQLException e) {
		e.printStackTrace();	
		}
		
		return contacts;
	}
	
	@Override

	public contact searchContacts(String name) {
	        
	        Connection con = DBUtils.getConnection();
	        contact c=null;
            String SELECT = "SELECT * FROM contact WHERE name=?";
            
	        try {
	           
	            PreparedStatement ps = con.prepareStatement(SELECT);
	            ps.setString(1, name);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                c = new contact();
	                c.setId(rs.getInt("id"));
	                c.setName(rs.getString("name"));
	                c.setEmail(rs.getString("email"));
	                c.setMobile(rs.getLong("mobile"));
	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return c ;
	    }

	public int updateContact(contact c) {
		String update = "UPDATE Contact SET email = ?, mobile = ? WHERE name = ?";
        Connection con = DBUtils.getConnection();
        int status = 0;
        try {
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, c.getEmail());
            ps.setLong(2, c.getMobile());
            ps.setString(3, c.getName());

            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
		

	@Override
	public void deleteAllContacts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public contact getContact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
