/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import View.View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import javax.swing.border.LineBorder;

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
        this.setTitle("Đăng Nhập ");
        JLabel til = new JLabel("ĐĂNG NHẬP");
        til.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        til.setFont(new Font("Arial", Font.BOLD, 30));
        til.setBorder(new EmptyBorder(40, 0, 0, 0));
        
      
        
        Font f = new Font("Arial", Font.PLAIN, 20);
        user = new JLabel("Tên Đăng Nhập");
        user.setFont(f);
        user.setForeground(Color.decode("#F48FB1"));
        
        password = new JLabel("Mật Khẩu");
        password.setFont(f);
        password.setBackground(Color.white);
        password.setForeground(Color.decode("#F48FB1"));
        Border border = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black);
        tuser = new JTextField();
        tuser.setFont(new Font("Arial", Font.PLAIN, 18));
        tuser.setPreferredSize(new Dimension(300,20));
        tuser.setBorder(border);
        tuser.setForeground(Color.decode("#3d3d3d"));
        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 18));
        tpass.setPreferredSize(new Dimension(300,20));
        tpass.setBorder(border);
       
        ControllerLogin ac = new ControllerLogin(this);
        login = new JButton("Đăng nhập");
        login.setFont(new Font("Arial", Font.PLAIN, 18));
        login.addActionListener(ac);
        login.setBackground(Color.gray);
        login.setForeground(Color.white);
        exit = new JButton("Thoát");
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.addActionListener(ac);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.white);
        check = new JCheckBox("Hiển Thị Mật Khẩu");
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
        
        JPanel p1 = new JPanel(new GridLayout(2, 1, 10, 25));
        JPanel p2 = new JPanel(new GridLayout(2,1,10,10));
        JPanel p3 = new JPanel(new GridLayout(2,1,10,10));
        
        p2.setBackground(Color.WHITE);
        p2.setBorder(new LineBorder(Color.decode("#000"), WIDTH));
        p3.setBorder(new LineBorder(Color.decode("#000"), WIDTH));
        p3.setBackground(Color.WHITE);
        p2.add(user);
        p2.add(tuser);
        p3.add(password);
        p3.add(tpass);
        p1.add(p2);
        p1.add(p3);
        p1.setBorder(new EmptyBorder(60, 30, 20, 30));
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p1,BorderLayout.CENTER);
        p4.add(check,BorderLayout.SOUTH);
        p4.setBorder(new EmptyBorder(0, 0, 40, 0));
        
        JPanel p5 = new JPanel(new GridLayout(1, 2, 40, 20));
        p5.add(login);
        p5.add(exit);

        p5.setBorder(new EmptyBorder(0, 100, 70, 100));
        this.setLayout(new BorderLayout());
        this.add(til, BorderLayout.NORTH);
        this.add(p4,BorderLayout.CENTER);
        this.add(p5,BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
    
    public void DangNhap(){
        String ten = tuser.getText();
        char[] pass = tpass.getPassword();
        String mk = new String(pass);
        
        if(ten.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Tên Đăng Nhập");
        }
        else if(mk.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Mật Khẩu");
        }
        if(ten.equals("admin") && mk.equals("admin")){
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Đã đăng nhập", JOptionPane.INFORMATION_MESSAGE);
            new View();
            //this.dispose();
            this.setVisible(false);
        }else if(!ten.equals("") && !mk.equals("")){
            JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    void Thoat() {
        System.gc();
        dispose();
    }
    
    
    
}
