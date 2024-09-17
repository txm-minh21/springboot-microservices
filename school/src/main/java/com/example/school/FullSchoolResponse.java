package com.example.school;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
    private String name;

    private String email;

    private List<Student> students;
}
