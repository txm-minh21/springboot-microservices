package com.example.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void save(@RequestBody School school) {
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }
}
