package com.studentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connectror.Connector;
import com.studentDTO.Student;

public class StudentDAOImp implements StudentDAO {
	Connection con=null;
	public StudentDAOImp() {
		this.con=Connector.getConnection();
	}
	

	@Override
	public boolean insertStudent(Student s) {
		int res=0;
		String query="insert into student values(0,?,?,?,?,?,?,sysdate())";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getEmail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLoc());
			ps.setString(6,s.getPassword());
			
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		int res=0;
		String query = "UPDATE student SET password=? WHERE sid=?";
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,s.getPassword());
			ps.setInt(2, s.getId());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student getStudent(String email, String password) {
		ResultSet rs=null;
		Student s=null;
		String query="select * from student where email=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2,password);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setName(rs.getString("sname"));
				s.setPhone(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setId(rs.getInt("sid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(s!=null) {
			return s;
		}else {
			return null;
		}
	}
	@Override
	public ArrayList<Student> getAllStudents() {
		ArrayList<Student> students=new ArrayList<>();
		ResultSet rs=null;
		String query="select * from student where sid!=5";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				Student s = new Student();
	            s.setId(rs.getInt("sid"));
	            s.setName(rs.getString("sname"));
	            s.setPhone(rs.getLong("phone"));
	            s.setEmail(rs.getString("email"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            students.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return students;
	}


	@Override
	public Student getStudent(String email) {
		Student s=new Student();
		String query="select * from student where email=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s.setId(rs.getInt("sid"));
	            s.setName(rs.getString("sname"));
	            s.setPhone(rs.getLong("phone"));
	            s.setEmail(rs.getString("email"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s;
		
	}

}
