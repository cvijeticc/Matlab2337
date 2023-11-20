/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapptest01.domain;

/**
 *
 * @author Dules
 */
public class Teacher {
    private Long id;
    private String firstname;
    private String lastname;
    private AcademicTitle academicTitle;

    public Teacher() {
        id = null;
        firstname="/";
        lastname="n/a";
        academicTitle = new AcademicTitle(0L, "N/A");
    }

    public Teacher(Long id, String firstname, String lastname, AcademicTitle academicTitle) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.academicTitle = academicTitle;
    }

    public AcademicTitle getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(AcademicTitle academicTitle) {
        this.academicTitle = academicTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", academicTitle=" + academicTitle + '}';
    }
    
}
