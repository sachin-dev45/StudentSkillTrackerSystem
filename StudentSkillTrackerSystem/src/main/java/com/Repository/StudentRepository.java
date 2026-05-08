package com.Repository;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.Student;
import com.Projection.StudentSkillProjection;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	public List<Student> findByName(String name);
	
	@Query(value="select * from Student where experiance=:experiance",nativeQuery=true)
	public List<Student> findByExperiance(@Param ("experiance") String experiance);
	
	public Page<Student> findAll(Pageable p);

	@Query(value="select s.name as name,sk.skillName as skillName,sk.level as level "
			+ "from Student s join skills sk")
	public List<StudentSkillProjection> getAllStudentNameSkilllevel();
	
	
	

}
