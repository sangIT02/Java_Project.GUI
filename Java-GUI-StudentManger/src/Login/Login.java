/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import View.View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author PC
 */
public class Login extends JFrame{
    private JLabel user;
    private  JLabel password;
    private JTextField tuser;
    private JPasswordField tpass;
    private JButton login;
    private JButton exit;
    private JCheckBox check;

    public Login() {
        init();
    }

    private void init() {
        this.setSize(500   , 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel til = new JLabel("LOGIN STUDENT MANAGER");
        til.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        til.setFont(new Font("Arial", Font.BOLD, 30));
        til.setBorder(new EmptyBorder(40, 0, 0, 0));
        
        
        Font f = new Font("Arial", Font.PLAIN, 20);
        user = new JLabel("User Name");
        user.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        user.setFont(f);
        password = new JLabel("Password");
        password.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        password.setFont(f);
        Border border = BorderFactory.createLineBorder(Color.white, 2);
        tuser = new JTextField();
        tuser.setFont(new Font("Arial", Font.PLAIN, 18));
        tuser.setBorder(border);
        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 18));
        tpass.setBorder(border);
        
        Controller ac = new Controller(this);
        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 18));
        login.addActionListener(ac);
        login.setBackground(Color.gray);
        login.setForeground(Color.white);
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.addActionListener(ac);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.white);
        check = new JCheckBox("Show Password");
        check.setHorizontalAlignment(SwingConstants.RIGHT);
        check.setBorder(new EmptyBorder(0, 0, 0, 20));
        check.setFont(new Font("Arial", Font.PLAIN, 13));
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if (check.isSelected()) {
                    tpass.setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                    tpass.setEchoChar('\u2022'); // Ẩn mật khẩu bằng dấu chấm
                }
            }
        });
        
        JPanel p1 = new JPanel(new GridLayout(2, 2, 10, 10));
        p1.add(user);
        p1.add(tuser);
        p1.add(password);
        p1.add(tpass);
        p1.setBorder(new EmptyBorder(60, 0, 20, 20));
        
        
        JPanel p2 = new JPanel(new BorderLayout());
        p2.add(p1,BorderLayout.CENTER);
        p2.add(check,BorderLayout.SOUTH);
        p2.setBorder(new EmptyBorder(0, 0, 40, 20));
        
        JPanel p3 = new JPanel(new GridLayout(1, 2, 40, 20));
        p3.add(login);
        p3.add(exit);
        p3.setBorder(new EmptyBorder(0, 100, 70, 100));
        this.setLayout(new BorderLayout());
        this.add(til, BorderLayout.NORTH);
        this.add(p2,BorderLayout.CENTER);
        this.add(p3,BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void DangNhap(){
        String ten = tuser.getText();
        char[] pass = tpass.getPassword();
        String mk = new String(pass);
        
        if(ten.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập User Name");
        }
        else if(mk.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Password");
        }
        if(ten.equals("admin") && mk.equals("admin")){
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
            new View();
            this.dispose();
        }else if(!ten.equals("") && !mk.equals("")){
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    void Thoat() {
        System.exit(0);
    }
    
    
    
}
