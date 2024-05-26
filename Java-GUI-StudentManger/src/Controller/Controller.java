/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.View;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

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
       if(s.equals("Sắp Xếp Theo Họ Tên")){
            try {
                view.SortByName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Sắp Xếp Theo GPA")){
            try {
                view.SortByGPA();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       if(s.equals("Mở File")){

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setPreferredSize(new Dimension(800,500));
            // Hiển thị hộp thoại mở file
            int returnValue = fileChooser.showOpenDialog(null);
            // Kiểm tra xem người dùng có chọn file hay không
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getName());
                // Thực hiện các xử lý cần thiết với file đã chọn
                view.ReadFile(selectedFile);
            }
    
                   
       }
       if(s.equals("Thoát")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            var n = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thoát", JOptionPane.OK_OPTION);
            if(n == JOptionPane.YES_OPTION){
                System.gc();
                view.dispose();
                System.exit(0);
            }
            
       }
       if(s.equals("Tìm Kiếm")){
           view.Search();
       }
       if(s.equals("Làm Mới")){
           view.Refresh();
       }
    }
    
}
