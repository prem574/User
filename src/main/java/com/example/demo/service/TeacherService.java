package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TeacherRepository;
import com.example.demo.entity.Teacher;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher newTeacher) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher existingTeacher = optionalTeacher.get();
            existingTeacher.setUser(newTeacher.getUser());
            existingTeacher.setQualification(newTeacher.getQualification());
            existingTeacher.setExperience(newTeacher.getExperience());
            existingTeacher.setSubjectTaught(newTeacher.getSubjectTaught());
            existingTeacher.setSpecialization(newTeacher.getSpecialization());
            return teacherRepository.save(existingTeacher);
        } else {
            // Handle error, teacher not found
            return null;
        }
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
    
    public Teacher getTeacherByUserId(Long userId) {
        return teacherRepository.findByUserId(userId);
    }
}
