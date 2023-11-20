/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapptest01.dbrepository;

import java.util.List;
import javaapptest01.domain.Teacher;
import java.sql.*;
import java.util.ArrayList;
import javaapptest01.domain.AcademicTitle;

/**
 *
 * @author Dules
 */
public class DBrepository {
    //konekcija kao attribut
    //implementirati kao Singleton
    
    public List<AcademicTitle> getAllAcademicTitle() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stud_sluzba";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        String query = "SELECT * FROM zvanje";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<AcademicTitle> titles = new ArrayList<>();
        while (rs.next()) {
            AcademicTitle academicTitle = new AcademicTitle();
            academicTitle.setId(rs.getLong("id"));
            academicTitle.setName(rs.getString("naziv"));
            titles.add(academicTitle);
        }
        rs.close();
        statement.close();
        connection.close();

        return titles;
    }

    public Teacher saveTeacher(Teacher teacher) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stud_sluzba";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        String query = "INSERT INTO nastavnik (ime,prezime,zvanje)"
                + " VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, teacher.getFirstname());
        ps.setString(2, teacher.getLastname());
        ps.setLong(3, teacher.getAcademicTitle().getId());

        ps.executeUpdate();
        ps.close();
        connection.close();
        return teacher;
    }

    public List<Teacher> getAllTeachers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/stud_sluzba";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        String query = "SELECT n.*, z.naziv FROM nastavnik as n INNER JOIN zvanje z ON n.zvanje = z.id ";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<Teacher> teachers = new ArrayList<>();
        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("id"));
            teacher.setFirstname(rs.getString("ime"));
            teacher.setLastname(rs.getString("prezime"));

            AcademicTitle academicTitle = new AcademicTitle();
            academicTitle.setId(rs.getLong("zvanje"));
            academicTitle.setName(rs.getString("naziv"));

            teacher.setAcademicTitle(academicTitle);

            teachers.add(teacher);
        }
        rs.close();
        statement.close();
        connection.close();

        return teachers;
    }

    public void updateTeachers(List<Teacher> teachers, List<Teacher> removedTeachers) throws Exception {
        String url = "jdbc:mysql://localhost:3306/stud_sluzba";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);

        String queryInsert = "INSERT INTO nastavnik (ime,prezime,zvanje)"
                + " VALUES (?,?,?)";
        PreparedStatement psInsert = connection.prepareStatement(queryInsert);

        try {
            //delete
            for (Teacher removedTeacher : removedTeachers) {
                //obrisi nastavnika....
                System.out.println("DELETE-----------------------------------------------");
                System.out.println(removedTeacher);
                
                //??????
                //ako nastavnik nema ID a obelezen je za brisanje
                //resen je pre nego sto je prosledjen entitet
            }

            //save or update
            for (Teacher teacher : teachers) {
                try {
                    //da li postoji nastavnik ili je nastavnik nov
                    if (teacher.getId() == null) {
                        //uradi insert
                        System.out.println("INSERT-----------------------------------------------");
                        System.out.println(teacher);
                        psInsert.setString(1, teacher.getFirstname());
                        psInsert.setString(2, teacher.getLastname());
                        psInsert.setLong(3, teacher.getAcademicTitle().getId());
                        psInsert.executeUpdate();
                    } else {
                        //nastavnik postoji
                        System.out.println("UPDATE-----------------------------------------------");
                        System.out.println(teacher);
                    }
                } catch (Exception e) {
                    System.out.println("Desila se greska!");
                    //connection.rollback();
                    throw new Exception("Desila se greska kod cuvanja/azuriranja!");
                }
            }

            //proslo je u FOR/u sve kako treba
            connection.commit();
        } catch (Exception e) {
            System.out.println("Greska: " + e.getMessage());
            connection.rollback();

            throw e;
        } finally {
            connection.close();
        }

    }
}
