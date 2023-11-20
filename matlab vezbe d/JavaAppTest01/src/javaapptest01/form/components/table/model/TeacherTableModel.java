/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapptest01.form.components.table.model;

import java.util.ArrayList;
import java.util.List;
import javaapptest01.domain.AcademicTitle;
import javaapptest01.domain.Teacher;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dules
 */
public class TeacherTableModel extends AbstractTableModel {

    private List<Teacher> teachers;
      private List<Teacher> removedTeachers;

    public TeacherTableModel(List<Teacher> teachers) {
        this.teachers = teachers;
        this.removedTeachers = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return teachers == null ? 0 : teachers.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = teachers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return teacher.getFirstname();
            case 1:
                return teacher.getLastname();
            case 2:
                return teacher.getAcademicTitle().getName();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ime";
            case 1:
                return "prezime";
            case 2:
                return "zvanje";
            default:
                return "n/a";
        }
    }

    public Teacher getRow(int row) {
        return teachers.get(row);
    }

    public void addEmptyRow() {
        Teacher teacher = new Teacher();
        teachers.add(teacher);
        
        //iscrtaj tabelu ponovo na osnovu podataka
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //if (columnIndex == 0 || columnIndex==1) return true;
        return true;
    }
    
    
    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        System.out.println("nova vrednost: " + 
                String.valueOf(value) + "na poziciji " + rowIndex+","+columnIndex);
        
        Teacher teacher = teachers.get(rowIndex);
        if (columnIndex==0){
            teacher.setFirstname(String.valueOf(value));
        }else if (columnIndex==1){
            teacher.setLastname(String.valueOf(value));
        }else if(columnIndex==2){
            //opcija 1.
            //String academicTitle = String.valueOf(value);
            //vrati mi kompletne podatke o zvanju na osnovu imena
            
            //opcija 2.
            //izbor zvanja bude u komponeneti Combobox odakle ce korisnik birati zvanje
            teacher.setAcademicTitle((AcademicTitle) value);
        }
        
        fireTableDataChanged();
    }

    public void remove(int selectedRow) {
        if(teachers==null) return;
        
        if (selectedRow!=-1 && selectedRow<teachers.size()){
            Teacher teacher = teachers.get(selectedRow);
            if (teacher.getId() != null){
                removedTeachers.add(teacher);
            }
            teachers.remove(selectedRow);
            fireTableDataChanged();
        }
    }

    public List<Teacher> getRemovedTeachers() {
        return removedTeachers;
    }
  
}
