/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapptest01.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapptest01.dbrepository.DBrepository;
import javaapptest01.domain.AcademicTitle;
import javaapptest01.domain.Teacher;

/**
 *
 * @author Dules
 */
public class Controller {
    private DBrepository dbRepository;
    
    public Controller() {
        dbRepository = new DBrepository();
    }
    
    public List <AcademicTitle> getAllAcademicTitle() throws Exception{
        try {
            return dbRepository.getAllAcademicTitle();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //return null;
            throw new Exception("Greska kod ucitavanja zvanja!");
        }
    }
    
    public Teacher saveTeacher(Teacher teacher) throws Exception{
        try {
            return dbRepository.saveTeacher(teacher);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod cuvanja nastavnika!");
        }
    }
    
    public List <Teacher> getAllTeachers() throws Exception{
        try {
            return dbRepository.getAllTeachers();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Gresak kod citanja podataka!");
        }
    }

    public void update(List<Teacher> teachers, List<Teacher> removedTeachers) throws Exception {
        try {
            dbRepository.updateTeachers(teachers, removedTeachers);
            System.out.println("Uspesno azuriranje!");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Greska kod azuriranja nastavnika");
        }
    }
}
