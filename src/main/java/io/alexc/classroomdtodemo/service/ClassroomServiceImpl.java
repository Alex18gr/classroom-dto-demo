package io.alexc.classroomdtodemo.service;

import io.alexc.classroomdtodemo.dto.ClassroomDto;
import io.alexc.classroomdtodemo.entity.Classroom;
import io.alexc.classroomdtodemo.error.ClassroomNotFoundException;
import io.alexc.classroomdtodemo.mapper.ClassroomMapper;
import io.alexc.classroomdtodemo.repository.ClassroomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository, ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
        this.classroomMapper = classroomMapper;
    }

    @Override
    public List<ClassroomDto> findAllClassrooms() {
        return this.classroomMapper.toDtoList(this.classroomRepository.findAll());
    }

    @Override
    public ClassroomDto saveClassroom(ClassroomDto classroom) {
        return this.classroomMapper.toDto(this.classroomRepository.save(this.classroomMapper.toEntity(classroom)));
    }

    @Override
    public void deleteClassroom(ClassroomDto classroom) {
        this.classroomRepository.delete(this.classroomMapper.toEntity(classroom));
    }

    @Override
    public void deleteClassroomById(int id) {
        this.classroomRepository.deleteById(id);
    }

    @Override
    public ClassroomDto findById(Integer id) {
        return this.classroomMapper.toDto(this.classroomRepository.findById(id).orElseThrow(
                () -> new ClassroomNotFoundException(id)));
    }
}
