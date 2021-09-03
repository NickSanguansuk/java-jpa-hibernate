package jpa.entitymodels;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Course", schema = "school_mgmt")
@NamedQueries({
        @NamedQuery(name = "getAllCoursesQuery", query = "SELECT c FROM Course c"),
        @NamedQuery(name = "getCourseByIdQuery", query = "SELECT c FROM Course c WHERE c.id = :idValue")
})
public class Course {
    private Integer id;
    private String instructor;
    private String name;
    private Collection<StudentCourse> studentCoursesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "instructor")
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course that = (Course) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (instructor != null ? !instructor.equals(that.instructor) : that.instructor != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (instructor != null ? instructor.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", instructor='" + instructor + '\'' +
                ", name='" + name + '\'' +
                //", studentCoursesById=" + studentCoursesById +
                '}';
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<StudentCourse> getStudentCoursesById() {
        return studentCoursesById;
    }

    public void setStudentCoursesById(Collection<StudentCourse> studentCoursesById) {
        this.studentCoursesById = studentCoursesById;
    }
}
