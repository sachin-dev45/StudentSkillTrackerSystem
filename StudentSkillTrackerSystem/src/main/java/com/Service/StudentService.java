package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Entity.Skill;
import com.Entity.Student;
import com.Projection.StudentSkillProjection;
import com.Repository.SkillRepository;
import com.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired 
	StudentRepository studrepo;
	
	@Autowired
	SkillRepository skillrepo;
	
	public String addStudents(Student s)
	{
		for(Skill k:s.getSkills())
		{
			k.setStudent(s);
		}
		studrepo.save(s);
		return "Student records save sucessfully....";
	}
	
	public Student findById(Long id)
	{
		return studrepo.findById(id).orElse(null);
	}
	
	public String deleteById(long id)
	{
		Student extStudent=studrepo.findById(id).orElse(null);
		if(extStudent==null)
		{
			return "No record found for given id.....";
		}
		else
		{
			studrepo.deleteById(id);
		}
		
		return "Record deleted sucessfully...";
	}
	
	public List<Student>findByName(String name)
	{
		return studrepo.findByName(name);
	}
	
	public List<Student> findByExperiance(String experiance)
	{
		return studrepo.findByExperiance(experiance);
	}
	
	public Page<Student> findAll(int pageindex,int pagesize,String column,String order)
	{
		Sort s=order.equalsIgnoreCase("asc")?Sort.by(column).ascending():Sort.by(column)
				.descending();
		Pageable p=PageRequest.of(pageindex, pagesize, s);
		return studrepo.findAll(p);
				
	}
	
	public List<StudentSkillProjection>getStudentNameSkillLevel()
	{
		return studrepo.getAllStudentNameSkilllevel();
	}
	
	public String updateStudent(long id,Student news)
	{
		Student extStudent=studrepo.findById(id).orElse(null);
		
		if(extStudent==null)
		{
			return "No record found for given id";
		}
		if(news.getName()==null&&news.getEmail()==null&&news.getExperiance()==null&&news.getSkills().isEmpty())
		{
			return "No data provided for updation";
		}
		
		if(news.getName()!=null)
		{
			extStudent.setName(news.getName());
		}
		
		if(news.getEmail()!=null)
		{
			extStudent.setEmail(news.getEmail());
		}
		
		if(news.getExperiance()!=null)
		{
			extStudent.setExperiance(news.getExperiance());
		}
		
		if(!news.getSkills().isEmpty())
		{
			for(Skill k:news.getSkills())
			{
				if(k.getSkillId()!=0)
				{
					Skill extSkill=skillrepo.findById(k.getSkillId()).orElse(null);
					
					if(extSkill==null)
					{
						return "No record found for given skillId";
					}
					else
					{
						if(k.getSkillName()!=null)
						{
							extSkill.setSkillName(k.getSkillName());
						}
						
						if(k.getLevel()!=null)
						{
							extSkill.setLevel(k.getLevel());
						}
						//extSkill.setSkillName(k.getSkillName());
						//extSkill.setLevel(k.getLevel());
					}
					
				}
				else
				{
					k.setStudent(extStudent);
					extStudent.getSkills().add(k);
					
				}
			}
		}
		studrepo.save(extStudent);
		return "Record updated sucessfully";
	}
	
	
	
	
	

}
