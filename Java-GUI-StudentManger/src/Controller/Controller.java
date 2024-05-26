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
import javax.swing.UnsupportedLookAndFeelException;
import jnafilechooser.api.JnaFileChooser;

/**
 *
 * @author PC
 */
public class Controller implements ActionListener {

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Thêm")) {
            try {
                view.addStudent();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (s.equals("Sửa")) {
            try {
                view.SuaStudent();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (s.equals("Xoá")) {
            try {
                view.XoaStudent();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (s.equals("Sắp Xếp Theo Họ Tên")) {
            try {
                view.SortByName();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (s.equals("Sắp Xếp Theo GPA")) {
            try {
                view.SortByGPA();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (s.equals("Mở File")) {
            try {

                JnaFileChooser fileChooser = new JnaFileChooser();
                fileChooser.setMode(JnaFileChooser.Mode.Files);
                boolean f = fileChooser.showOpenDialog(view);
                if (f) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getName());
                    // Thực hiện các xử lý cần thiết với file đã chọn
                    view.ReadFile(selectedFile);
                } else {
                    return;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        if (s.equals("Thoát")) {
            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 20));
            var n = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Thoát", "Thoát", JOptionPane.OK_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                System.gc();
                view.dispose();
                System.exit(0);
            }

        }
        if (s.equals("Tìm Kiếm")) {
            view.Search();
        }
        if (s.equals("Làm Mới")) {
            view.Refresh();
        }
    }

}
