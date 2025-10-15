package com.studentDAO;
import java.util.ArrayList;
import com.studentDTO.Student;
public interface StudentDAO {
	public boolean insertStudent(Student s);//DML
	public boolean updateStudent(Student s);//DML
	public Student getStudent(String email);
	public Student getStudent(String email,String password);
	public ArrayList<Student> getAllStudents();
}
