package io.alexc.classroomdtodemo.service;



import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.dto.StudentDto;
import io.alexc.classroomdtodemo.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public StudentDto save(StudentDto student);

    public void deleteStudent(StudentDto student);

    public void deleteStudentById(int id);

    public StudentDto findStudentById(int id);

    public StudentDto findStudentByIdAndClassroomId(int classroomId, int id);

    public Page<StudentDto> findAll(Integer page, Integer size);

    public ClassroomDto findStudentClassroomById(Integer studentId);

}
