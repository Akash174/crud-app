package com.cruddemo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cruddemo.entities.Student;
import com.cruddemo.repository.StudentRepository;

@SpringBootTest
class CrudDemo1ApplicationTests {
    @Autowired
	private StudentRepository studentRepo;
	
	@Test
	void saveOneStudentRecord() {
	 Student s1 = new Student();	
	 s1.setName("ninad");
	 s1.setCourse("ITUS");
	 s1.setFee(3000);
	
	 studentRepo.save(s1);
	 
	}
	@Test
	void deleteOneStudentRecord() {
		studentRepo.deleteById(2L);
		}
	@Test
	void getOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student s = findById.get();
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getFee());
		System.out.println(s.getCourse());
		
	}
	@Test
	void updateOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(3L);
		Student s = findById.get();
		s.setCourse("electronics");
		studentRepo.save(s);

}
	@Test
	void getAllStudentRecord() {
		Iterable<Student> findAll = studentRepo.findAll();
		for (Student student : findAll) {
			System.out.println(student.getName());
			System.out.println(student.getId());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
	}
}