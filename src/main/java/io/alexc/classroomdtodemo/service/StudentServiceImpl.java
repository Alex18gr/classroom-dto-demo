package io.alexc.classroomdtodemo.service;


import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.dto.StudentDto;
import io.alexc.classroomdtodemo.entity.Student;
import io.alexc.classroomdtodemo.error.StudentNotFoundException;
import io.alexc.classroomdtodemo.mapper.ClassroomMapper;
import io.alexc.classroomdtodemo.mapper.StudentMapper;
import io.alexc.classroomdtodemo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ClassroomMapper classroomMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, ClassroomMapper classroomMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.classroomMapper = classroomMapper;
    }

    @Override
    public StudentDto save(StudentDto student) {
        return this.studentMapper.toDto(this.studentRepository.save(this.studentMapper.toEntity(student)));
    }

    @Override
    public void deleteStudent(StudentDto student) {
        this.studentRepository.delete(this.studentMapper.toEntity(student));
    }

    @Override
    public void deleteStudentById(int id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public StudentDto findStudentById(int id) {
        return this.studentMapper.toDto(this.studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id)));
    }

    @Override
    public StudentDto findStudentByIdAndClassroomId(int classroomId, int id) {
        return this.studentMapper.toDto(this.studentRepository.findByClassroom_IdAndId(classroomId, id)
        .orElseThrow(() -> new StudentNotFoundException(classroomId, id)));
    }

    @Override
    public Page<StudentDto> findAll(Integer page, Integer size) {

        if (page != null && size != null) {
            Pageable p = PageRequest.of(page, size);
            return this.studentRepository.findAll(p).map((this.studentMapper::toDto));
        }

        return this.studentRepository.findAll(PageRequest.of(0, Integer.MAX_VALUE)).map((this.studentMapper::toDto));
    }

    @Override
    public ClassroomDto findStudentClassroomById(Integer studentId) {
        return this.classroomMapper.toDto(this.studentRepository.findById(studentId).orElseThrow(
                () -> new StudentNotFoundException(studentId)).getClassroom());
    }
}
