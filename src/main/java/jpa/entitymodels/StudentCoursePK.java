package jpa.entitymodels;

import jakarta.persistence.Id;

import java.io.Serializable;

public class StudentCoursePK implements Serializable {
    private String studentEmail;
    private Integer courseId;

    //@Column(name = "student_email")
    @Id
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    //@Column(name = "course_id")
    @Id
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCoursePK that = (StudentCoursePK) o;

        if (studentEmail != null ? !studentEmail.equals(that.studentEmail) : that.studentEmail != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentEmail != null ? studentEmail.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
