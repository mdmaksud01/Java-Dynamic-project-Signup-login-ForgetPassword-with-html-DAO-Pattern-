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

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		Student s=null;
		StudentDAO st=new StudentDAOImp();
		PrintWriter out=res.getWriter();
		//String email=req.getParameter("email");
		//String password=req.getParameter("password");
		s=st.getStudent(req.getParameter("email"), req.getParameter("password"));
		if (s!=null) {
			out.println("login success");
			out.println("welcome "+s);
		}else {
			out.println("login failed");
		}
	}

}
