package io.alexc.classroomdtodemo.mapper;

import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ClassroomMapper {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // private static ClassroomMapper instance;

    // private ClassroomMapper() { }

//    public static ClassroomMapper getInstance() {
//        if (instance == null) instance = new ClassroomMapper();
//        return instance;
//    }

    private final StudentMapper studentMapper;

    public ClassroomMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public ClassroomDto toDto(Classroom c) {
        ClassroomDto dto = new ClassroomDto();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setStudents(studentMapper.toDtoList(c.getStudents()));
        c.getStudents().forEach((stud) -> {
            dto.getStudents().add(studentMapper.toDto(stud));
        });
        return dto;
    }

    public List<ClassroomDto> toDtoList(Collection<Classroom> classrooms) {
        List<ClassroomDto> dtos = new ArrayList<>(classrooms.size());
        classrooms.forEach((c) -> dtos.add(toDto(c)));
        return dtos;
    }

    public Classroom toEntity(ClassroomDto dto) {
        Classroom c = new Classroom();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setStudents(new ArrayList<>());
        dto.getStudents().forEach((studentDto) -> {
            c.getStudents().add(studentMapper.toEntity(studentDto));
        });
        return c;

    }



}
