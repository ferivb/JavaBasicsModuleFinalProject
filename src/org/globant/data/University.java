package org.globant.data;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private List<Professor> teacherList;
    private List<Student> studentList;
    private List<Course> courseList;

    public University(String name) {
        this.name = name;
        this.teacherList = new ArrayList<Professor>();
        this.studentList = new ArrayList<Student>();
        this.courseList = new ArrayList<Course>();
    }
}
