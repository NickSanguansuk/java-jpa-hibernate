package jpa.entitymodels;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Student", schema = "school_mgmt")
@NamedQueries({
        @NamedQuery(name = "getAllStudentsQuery", query = "SELECT s FROM Student s"),
        @NamedQuery(name = "getStudentByEmailQuery", query = "SELECT s FROM Student s WHERE s.email = :emailValue")
})
public class Student {
    private String email;
    private String name;
    private String password;
    private Collection<StudentCourse> studentCoursesByEmail;

    @Id
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                //", studentCoursesByEmail=" + studentCoursesByEmail +
                '}';
    }

    @OneToMany(mappedBy = "studentByStudentEmail")
    public Collection<StudentCourse> getStudentCoursesByEmail() {
        return studentCoursesByEmail;
    }

    public void setStudentCoursesByEmail(Collection<StudentCourse> studentCoursesByEmail) {
        this.studentCoursesByEmail = studentCoursesByEmail;
    }
}
