package io.alexc.classroomdtodemo.service;

import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.entity.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomService {

    public List<ClassroomDto> findAllClassrooms();

    public ClassroomDto saveClassroom(ClassroomDto classroom);

    public void deleteClassroom(ClassroomDto classroom);

    public void deleteClassroomById(int id);

    public ClassroomDto findById(Integer id);

}
