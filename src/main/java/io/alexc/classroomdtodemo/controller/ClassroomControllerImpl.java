package io.alexc.classroomdtodemo.controller;


import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.dto.StudentDto;
import io.alexc.classroomdtodemo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("classrooms")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"}, maxAge = 3600)
public class ClassroomControllerImpl implements ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomControllerImpl(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ClassroomDto> getClassrooms() {
        return this.classroomService.findAllClassrooms();
    }

    @Override
    public ClassroomDto postClassroom(ClassroomDto classroom) {
        return null;
    }

    @Override
    public ClassroomDto getClassroom(Integer id) {
        return null;
    }

    @Override
    public ClassroomDto putClassroom(ClassroomDto classroom, Integer id) {
        return null;
    }

    @Override
    public void deleteClassroom(Integer id) {

    }

    @Override
    public Collection<StudentDto> getClassroomStudents(Integer classroomId) {
        return null;
    }

    @Override
    public StudentDto postClassroomStudent(Integer classroomId, StudentDto student) {
        return null;
    }

    @Override
    public StudentDto getClassroomStudentById(Integer classroomId, Integer studentId) {
        return null;
    }

    @Override
    public StudentDto putClassroomStudent(Integer classroomId, Integer studentId, StudentDto student) {
        return null;
    }

    @Override
    public void deleteClassroomStudent(Integer classroomId, Integer studentId) {

    }
}
