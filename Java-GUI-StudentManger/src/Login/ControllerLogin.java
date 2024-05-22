/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class ControllerLogin implements ActionListener{
    private Login login;

    public ControllerLogin(Login login) {
        this.login = login;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("Đăng nhập")){
            login.DangNhap();
        }
        else if(s.equals("Thoát")){
            login.Thoat();
        }
    }
    
}
