package com.example.school;

import com.example.school.config.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient client;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(School.builder().name("NOT_FOUND").email("NOT_FOUND").build());
        // find all the students from the student micro-service
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder().name(school.getName()).email(school.getEmail()).students(students).build();
    }
}
