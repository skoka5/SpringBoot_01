package com.dxc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dxc.repository.StudentRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class Demo01MongoDbApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Demo01MongoDbApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{
		studentRepository.save(new Student(101,"sai"));
		studentRepository.save(new Student(102,"karthik"));
		
		System.out.print("Inserted successfully");
		List<Student> students = studentRepository.findAll();
		for(Student student : students) {
			System.out.println(student);
		}
		
		System.out.println();
		studentRepository.getByName("karthik");
		
		System.out.println("\nEnd of the program");
	}

}
