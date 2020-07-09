package com.austin.dao;

import com.austin.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

@Repository
public class StudentDao {
	private static Map<Integer, Student> students;

	static {
		students = new HashMap<Integer, Student>() {
			private static final long serialVersionUID = 1L;

			{
				put(1, new Student(1, "Said", "Computer Science"));
				put(2, new Student(2, "Alex U", "Finance"));
				put(3, new Student(3, "Anna", "Maths"));
			}
		};
	}

	public Collection<Student> getAllStudents() {
		return students.values();
	}

	public Student getStudentById(int id) {
		return this.students.get(id);
	}

	public void removeStudentById(int id) {
		this.students.remove(id);
	}

	public void updateStudent(Student student) {
		Student s = students.get(student.getId());
		s.setCourse(student.getCourse());
		s.setName(student.getName());
		students.put(student.getId(), student);
	}

	public void insertStudentToDb(Student student) {
		this.students.put(student.getId(), student);;
	}


}
