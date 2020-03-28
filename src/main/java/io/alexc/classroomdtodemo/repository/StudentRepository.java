package io.alexc.classroomdtodemo.repository;

import io.alexc.classroomdtodemo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Override
    Page<Student> findAll(Pageable pageable);

    Optional<Student> findByClassroom_IdAndId(int classroom_id, int id);
}
