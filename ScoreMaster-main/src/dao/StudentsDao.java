package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import bean.Student;
import bean.Subject;

public interface StudentsDao {

	@Select("SELECT student_id FROM students WHERE name = #{name} AND grade = #{grade} AND class_name = #{className}")
	Integer getStudentId(Student student);

	@Insert("INSERT INTO students (name, grade, class_name) VALUES (#{name}, #{grade}, #{className})")
	@Options(useGeneratedKeys = true, keyProperty = "studentId")
	void insertStudent(Student student);

	@Select("SELECT subject_id FROM subjects WHERE subject_name = #{subjectName}")
	Integer getSubjectId(Subject subject);

	@Insert("INSERT INTO subjects (subject_name) VALUES (#{subjectName})")
	@Options(useGeneratedKeys = true, keyProperty = "subjectId")
	void insertSubject(Subject subject);
}
