package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Student;
import com.Projection.StudentSkillProjection;
import com.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studser;
	
	@PostMapping("/addstudents")
	public String addStudents(@RequestBody Student s)
	{
		return studser.addStudents(s);
	}
	
	@DeleteMapping("/deletebyid")
	public String deletById(@RequestParam long id)
	{
		return studser.deleteById(id);
	}
	
	@GetMapping("/findbyid")
	public Student findById(@RequestParam long id)
	{
		return studser.findById(id);
	}
	
	@GetMapping("/findbyname")
	public List<Student> findByName(@RequestParam String name)
	{
		return studser.findByName(name);
	}
	
	@GetMapping("/findbyexperiance")
	public List<Student> findByExperiance(@RequestParam String experiance)
	{
		return studser.findByExperiance(experiance);
	}
	
	@GetMapping("/findall")
	public Page<Student> findAll(@RequestParam int pageindex,@RequestParam int pagesize,
			@RequestParam String column,@RequestParam String order)
	{
		return studser.findAll(pageindex, pagesize, column, order);
		
	}
	@GetMapping("/getallstudentnameskilllevel")
	public List<StudentSkillProjection> getAllStudentNameSkilllevel()
	{
		return studser.getStudentNameSkillLevel();
	}
	
	@PutMapping("/updatestudent")
	public String updateStudent(@RequestParam long id,@RequestBody Student s)
	{
		return studser.updateStudent(id, s);
	}

}
