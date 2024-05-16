/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Controller implements ActionListener{
    private View view;

    public Controller(View view) {
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
       if(s.equals("Thêm")){
            try {
                view.addStudent();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Sửa")){
            try {
                view.SuaStudent();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Xoá")){
            try {
                view.XoaStudent();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Sort By Name")){
            try {
                view.SortByName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Sort By GPA")){
            try {
                view.SortByGPA();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Read from file")){
           view.ReadFile();
                   
       }
       if(s.equals("Exit")){
           System.exit(0);
       }
       if(s.equals("Search")){
           view.Search();
       }
       if(s.equals("Refresh")){
           view.Refresh();
       }
    }
    
}
