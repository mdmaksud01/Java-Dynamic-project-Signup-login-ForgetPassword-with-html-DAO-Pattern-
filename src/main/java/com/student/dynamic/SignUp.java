package com.student.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentDAO.StudentDAOImp;
import com.studentDAO.StudentDAO;
import com.studentDTO.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		Student s=new Student();
		StudentDAO st=new StudentDAOImp();
		PrintWriter out=res.getWriter();
		s.setName(req.getParameter("name"));
		/* set phone 
		String ph=req.getParameter("phone");
		long l=Long.parseLong(ph);
		s.setPhone(l);*/
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setEmail(req.getParameter("email"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		String pass=req.getParameter("password");
		String confirm=req.getParameter("confirm");
		
		if(pass.equals(confirm)) {
			s.setPassword(pass);
			if(st.insertStudent(s)) {
				out.println("<h1> data saved successfully</h1>");
			}
			else {
				out.println("<h2>data failed successfull</h2>");
			}
			
		}
		else {
			out.println("<h2>registration failed</h2>");
		}
	}
}
