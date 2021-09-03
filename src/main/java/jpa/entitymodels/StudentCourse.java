package jpa.entitymodels;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Course", schema = "school_mgmt")
@IdClass(StudentCoursePK.class)
public class StudentCourse {
    private String studentEmail;
    private Integer courseId;
    private Student studentByStudentEmail;
    private Course courseByCourseId;

    @Id
    @Column(name = "student_email")
    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Id
    @Column(name = "course_id")
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

        StudentCourse that = (StudentCourse) o;

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

    @Override
    public String toString() {
        return "StudentCourse{" +
                "studentEmail='" + studentEmail + '\'' +
                ", courseId=" + courseId +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "student_email", referencedColumnName = "email", nullable = false)
    public Student getStudentByStudentEmail() {
        return studentByStudentEmail;
    }

    public void setStudentByStudentEmail(Student studentByStudentEmail) {
        this.studentByStudentEmail = studentByStudentEmail;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    public Course getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(Course courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
