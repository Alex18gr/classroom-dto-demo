package io.alexc.classroomdtodemo.controller;

import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.dto.StudentDto;
import io.alexc.classroomdtodemo.entity.Classroom;
import io.alexc.classroomdtodemo.entity.Student;
import io.alexc.classroomdtodemo.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "students")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"}, maxAge = 3600)
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    public StudentControllerImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<StudentDto> getStudents(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        return this.studentService.findAll(page, size);
    }

    @Override
    public StudentDto getStudent(Integer id) {
        return null;
    }

    @Override
    public ClassroomDto getStudentsClassrooms(Integer id) {
        return null;
    }
}
