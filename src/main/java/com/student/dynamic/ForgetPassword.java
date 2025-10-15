package com.student.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import com.studentDAO.StudentDAO;
import com.studentDAO.StudentDAOImp;
import com.studentDTO.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/forgetPassword")
public class ForgetPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		Student s=null;
		StudentDAO st=new StudentDAOImp();
		PrintWriter out=res.getWriter();
		s=st.getStudent(req.getParameter("email"));
		//s.setId(s.getId());
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			if(s.getPassword().equals(req.getParameter("password"))) {
				out.println("the password is already use");
			}
			else {
				s.setPassword(req.getParameter("password"));
				if(st.updateStudent(s)) {
					out.println("password change suceessfully");
				}else{
					out.println("somthing went wrong");
				}
			
			}
		}else {
			out.print("password mismatch");
		}
	}
}
