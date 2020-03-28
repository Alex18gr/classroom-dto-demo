package io.alexc.classroomdtodemo.controller;

import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.dto.StudentDto;
import io.alexc.classroomdtodemo.entity.Classroom;
import io.alexc.classroomdtodemo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface StudentController {

    public Page<StudentDto> getStudents(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size);

    public StudentDto getStudent(@PathVariable Integer id);

    public ClassroomDto getStudentsClassrooms(@PathVariable Integer id);

}
