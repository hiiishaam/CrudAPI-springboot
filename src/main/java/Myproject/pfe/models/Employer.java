package Myproject.pfe.models;

import Myproject.pfe.Ennumerations.Grades;
import jakarta.persistence.*;

@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String name;

    @Column(unique=true)
    public String email;

    public String phone;

    @Enumerated(EnumType.STRING)
    public Grades grade;

    public Employer(Grades grade, String phone, String email, String name, long id) {
        this.grade = grade;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public Employer() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }
}
