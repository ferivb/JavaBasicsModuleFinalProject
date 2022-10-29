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

    // --------------- GETTERS --------------------

    public List<Professor> getTeacherList() {
        return teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }


    // --------------- METHODS --------------------

    public void addProfessor(Professor professor){
        this.teacherList.add(professor);
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public void addCourse(Course course){
        this.courseList.add(course);
    }

    public Professor findProfessorById(int id) {
        Professor professor = new Professor("null", "null", 0) {
            @Override
            public double calculateRealSalary() {
                return 0;
            }
        };
        Professor.resetCounter();
        professor.setId(-1);

        if (id > 0 && id <= teacherList.size()) {
            for (Professor value : teacherList) {
                if (value.getId() == id) {
                    professor = value;
                }
            }
        }

        return professor;
    }

    public Student findStudentInUniversity(int studentId){
        Student student = new Student("null", 0);
        student.setId(-1);
        Student.resetCounter();

        if (studentId > 0 && studentId <= studentList.size()){
            for (Student value : studentList) {
                if (value.getId() == studentId) {
                    student = value;
                }
            }
        }
        return student;
    }

    public int retrieveProfessorIdFromCourseList(int index){
        return courseList.get(index).retrieveProfessorId();
    }

    public String retrieveCourseName(int index){
        return courseList.get(index).getName();
    }

    public Course findCourseById(int id){
        Course course = new Course("null", -1);
        course.setId(-1);
        Course.resetCounter();

        if (id > 0 && id <= courseList.size()){
            for (Course value : courseList){
                if(value.getId() == id){
                    course = value;
                }
            }
        }
        return course;
    }

}
