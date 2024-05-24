/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.*;
import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import model.Address;
import model.Student;

/**
 *
 * @author PC
 */
public class View extends JFrame implements Comparable<Student>{

    private DefaultTableModel model;
    private JTable table;
    private JScrollPane jsp;
    private JLabel id;
    private JLabel name;
    private JLabel age;
    private JRadioButton nam;
    private JRadioButton nu;
    private JLabel gender;
    private JLabel address;
    private JLabel email;
    private JLabel phone;
    private JLabel gpa;
    
    private JTextField tsearch;
    private JTextField tid;
    private JTextField tname;
    private JComboBox tage;
    private JComboBox tadd;
    private JTextField temail;
    private JTextField tphone;
    private JTextField tgpa;
    
    private  JTextField xa;
    private  JTextField huyen;
    private  JTextField tinh;

    
    private JButton add;
    private JButton update;
    private JButton del;
    private JButton search;
    private JButton readfile;
    private JButton sortbyname;
    private JButton sortbtgpa;
    private JButton exit;
    private File file;
    private List<Student> list;
    private ButtonGroup gr;
    private JButton refresh;
    
   
    public View() {
        init();
    }

    private void init() {
        this.setSize(1200,600);
        this.setTitle("QUẢN LÝ SINH VIÊN");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Đặt kích thước cho JFrame bằng với kích thước màn hình
        this.setSize(screenSize.width, screenSize.height-50);
        //this.setLocationRelativeTo();
        this.setLocation(0, 0);
        this.setLayout(new BorderLayout(0, 0));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        list = new ArrayList<Student>();
        ImageIcon iadd = new ImageIcon("test\\add.png");
        ImageIcon idel = new ImageIcon("test\\del.png");
        ImageIcon iupdate = new ImageIcon("test\\update.png");
        ImageIcon isearch = new ImageIcon("test\\search.png");
        int width = 40; // Chiều rộng mới
        int height = 40; // Chiều cao mới
        Image sadd = iadd.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image sdel = idel.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image supdate = iupdate.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image ssearch = isearch.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Tạo biểu tượng mới với kích thước đã đặt
        ImageIcon icon_add = new ImageIcon(sadd);
        ImageIcon icon_del = new ImageIcon(sdel);
        ImageIcon icon_update = new ImageIcon(supdate);
        ImageIcon icon_search = new ImageIcon(ssearch);

        Font f = new Font("Arial", Font.BOLD, 16);
        Font plain = new Font("Arial",Font.BOLD,20);
        JPanel dl = new JPanel(new GridLayout(8, 2, 10, 10));
        id = new JLabel("Mã Số Sinh Viên");
        id.setHorizontalAlignment(SwingConstants.LEFT);
        id.setFont(new Font("Arial",Font.BOLD,20) {
        });
        name = new JLabel("Họ Và Tên");
        name.setHorizontalAlignment(SwingConstants.LEFT);
        name.setFont(plain);
        age = new JLabel("Tuổi");
        age.setHorizontalAlignment(SwingConstants.LEFT);
        age.setFont(plain);
        address = new JLabel("Địa Chỉ");
        address.setHorizontalAlignment(SwingConstants.LEFT);
        address.setPreferredSize(new Dimension(100,50));
        address.setFont(plain);
        email = new JLabel("Địa Chỉ Email");
        email.setHorizontalAlignment(SwingConstants.LEFT);
        email.setFont(plain);
        phone = new JLabel("Số Điện Thoại");
        phone.setHorizontalAlignment(SwingConstants.LEFT);
        phone.setFont(plain);
        gpa = new JLabel("GPA");
        gpa.setHorizontalAlignment(SwingConstants.LEFT);
        gpa.setFont(plain);
        gender = new JLabel("Giới Tính");
        gender.setHorizontalAlignment(SwingConstants.LEFT);
        gender.setFont(plain);
        
        Font italic = new Font("Arial",Font.ITALIC,20);
        tid = new JTextField("Nhập Mã Số Sinh Viên");
        //tid.setHorizontalAlignment(SwingConstants.CENTER);
        tid.setFont(italic);
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK);
        tid.setBorder(bottomBorder);
        tid.setForeground(Color.GRAY);
        tid.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tid.setText("");
                tid.setFont(new Font("Arial",Font.PLAIN,20));
                tid.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tid.getText().isEmpty()) {
                    tid.setText("Nhập Mã Số Sinh Viên");
                    tid.setForeground(Color.GRAY);
                    tid.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        
       
        //tid.setPreferredSize(new Dimension(300, 40));
        tname = new JTextField("Nhập Họ Tên Sinh Viên");
        tname.setFont(italic);
        tname.setForeground(Color.GRAY);
        //tname.setHorizontalAlignment(SwingConstants.CENTER);
        tname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tname.setText("");
                tname.setFont(new Font("Arial",Font.PLAIN,20));
                tname.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tname.getText().isEmpty()) {
                    tname.setText("Nhập Họ Tên Sinh Viên");
                    tname.setForeground(Color.GRAY);
                    tname.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        tname.setBorder(bottomBorder);
         Integer[] ages = new Integer[101];
        for (int i = 1; i <= 100; i++) {
            ages[i] = i;
        }
        tage = new JComboBox<>(ages);
        tage.setBackground(Color.WHITE);
        tage.setFont(f);
        Object o[] = {"",
            "An Giang", "Bà Rịa – Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh",
            "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận", "Cà Mau", 
            "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", 
            "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội", "Hà Tĩnh", "Hải Dương", 
            "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", 
            "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", 
            "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", 
            "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", 
            "Thừa Thiên Huế", "Tiền Giang", "TP Hồ Chí Minh", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", 
            "Vĩnh Phúc", "Yên Bái"
        };
//        tadd = new JComboBox(o);
//        tadd.setFont(f);

        temail = new JTextField("Jessica69@gmail.com");
        temail.setFont(italic);
        temail.setBorder(bottomBorder);
        //temail.setHorizontalAlignment(SwingConstants.CENTER);
        temail.setForeground(Color.gray);
        temail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                temail.setText("");
                temail.setFont(new Font("Arial",Font.PLAIN,20));
                temail.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (temail.getText().isEmpty()) {
                    temail.setText("Jessica69@gmail.com");
                    temail.setForeground(Color.GRAY);
                    temail.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        tphone = new JTextField("0123456789 ");
        tphone.setFont(italic);
        //tphone.setHorizontalAlignment(SwingConstants.CENTER);
        tphone.setForeground(Color.GRAY);
        tphone.setBorder(bottomBorder);
        tphone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tphone.setText("");
                tphone.setFont(new Font("Arial",Font.PLAIN,20));
                tphone.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tphone.getText().isEmpty()) {
                    tphone.setText("0123456789 ");
                    tphone.setForeground(Color.GRAY);
                    tphone.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        tgpa = new JTextField("Nhập GPA");
        tgpa.setFont(italic);
        //tgpa.setHorizontalAlignment(SwingConstants.CENTER);

        tgpa.setForeground(Color.gray);
        tgpa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tgpa.setText("");
                tgpa.setFont(new Font("Arial",Font.PLAIN,20));
                tgpa.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tgpa.getText().isEmpty()) {
                    tgpa.setText("Nhập GPA");
                    tgpa.setForeground(Color.GRAY);
                    tgpa.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        tgpa.setBorder(bottomBorder);
        nam = new JRadioButton("Nam");
        nam.setFont(f);

        nu = new JRadioButton("Nữ");
        nu.setFont(f);
        nam.setBackground(Color.white);
        nu.setBackground(Color.white);
        Object cname[] = {
            "MÃ SỐ SINH VIÊN","HỌ TÊN","TUỔI","GIỚI TÍNH","ĐỊA CHỈ","ĐIỆN THOẠI","EMAIL","GPA"
        };
        Object data[][] = {
            
        };
         JPanel p4 = new JPanel(new GridLayout(1, 2, 0, 0));
         p4.add(nam);
         p4.add(nu);
        
         JPanel p5 = new JPanel(new GridLayout(1    , 3, 0  , 2));
         Font f18 = new Font("Arial",Font.ITALIC,18);
         Border rb = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK);
         xa = new JTextField("Xã");
         xa.setFont(f18);
         xa.setForeground(Color.GRAY);
         xa.setBorder(new EmptyBorder(0, 0, 0, 0));
         xa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                xa.setText("");
                xa.setFont(new Font("Arial",Font.PLAIN,18));
                xa.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (xa.getText().isEmpty()) {
                    xa.setText("Xã");
                    xa.setForeground(Color.GRAY);
                    xa.setFont(new Font("Arial",Font.ITALIC,18));
                }
            }
        });
         huyen = new JTextField("Huyện");
         huyen.setFont(f18);
         huyen.setForeground(Color.GRAY);
         huyen.setBorder(new EmptyBorder(0, 0, 0, 0));
         huyen.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                huyen.setText("");
                huyen.setFont(new Font("Arial",Font.PLAIN,18));
                huyen.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (huyen.getText().isEmpty()) {
                    huyen.setText("Huyện");
                    huyen.setForeground(Color.GRAY);
                    huyen.setFont(new Font("Arial",Font.ITALIC,18));
                }
            }
        });
         tinh = new JTextField("Tỉnh");
         tinh.setFont(f18);
         tinh.setForeground(Color.GRAY);
         tinh.setBorder(new EmptyBorder(0, 0, 0, 0));
         tinh.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tinh.setText("");
                tinh.setFont(new Font("Arial",Font.PLAIN,18));
                tinh.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tinh.getText().isEmpty()) {
                    tinh.setText("Tỉnh");
                    tinh.setForeground(Color.GRAY);
                    tinh.setFont(new Font("Arial",Font.ITALIC,18));
                }
            }
        });
         p5.setBackground(Color.WHITE);
         p5.add(xa);
         p5.add(huyen);
         p5.add(tinh);
         
      
        //dl.setPreferredSize(new Dimension(400, 400));
        dl.setBorder(new LineBorder(Color.GRAY, 3));


        model = new DefaultTableModel(data, cname);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(1120, 545));
        table.setBackground(Color.LIGHT_GRAY);
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(190);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(220);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(160);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
        jsp = new JScrollPane(table);
        
        JPanel p_table = new JPanel();
        JPanel tb = new JPanel();
        tb.add(jsp);
        p_table.setBorder(new EmptyBorder(0, 0, 0, 20));
        p_table.add(tb);
        //p_table.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        
        tb.setBorder(new LineBorder(Color.BLACK, 2));

        
        gr = new ButtonGroup();
        gr.add(nam);
        gr.add(nu);
        
        
        Border bl = new LineBorder(Color.BLACK,2);
        Controller ac = new Controller(this);
        add = new JButton("Thêm", icon_add);
        add.setBackground(Color.DARK_GRAY);
        add.setForeground(Color.white);
        add.setFont(f);
        add.setBorder(bl);
        add.addActionListener(ac);
        del = new JButton("Xoá", icon_del);
        del.setBackground(Color.DARK_GRAY);
        del.setForeground(Color.WHITE);
        del.setFont(f);
        del.setBorder(bl);
        del.addActionListener(ac);

        update = new JButton("Sửa", icon_update);
        update.setBackground(Color.DARK_GRAY);
        update.setForeground(Color.white);
        update.setFont(f);
        update.setBorder(bl);
        update.addActionListener(ac);

        sortbtgpa = new JButton("Sắp Xếp Theo GPA");
        sortbtgpa.setBackground(Color.DARK_GRAY);
        sortbtgpa.setForeground(Color.white);
        sortbtgpa.setBorder(bl);
        sortbtgpa.setFont(f);
        sortbtgpa.addActionListener(ac);

        sortbyname = new JButton("Sắp Xếp Theo Họ Tên");
        sortbyname.setBackground(Color.DARK_GRAY);
        sortbyname.setForeground(Color.white);        
        sortbyname.setFont(f);
        sortbyname.setBorder(bl);
        sortbyname.addActionListener(ac);

        exit = new JButton("Thoát");
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.white);        
        exit.setBorder(bl);
        exit.setFont(f);
        exit.addActionListener(ac);

        readfile = new JButton("Mở File");
        readfile.setBorder(bl);
        readfile.setBackground(Color.DARK_GRAY);
        readfile.setForeground(Color.white);        
        readfile.setFont(f);
        readfile.addActionListener(ac);
        
        refresh = new JButton("Làm Mới");
        refresh.setBorder(bl);
        refresh.setBackground(Color.DARK_GRAY);
        refresh.setForeground(Color.white);        
        refresh.setFont(f);
        refresh.addActionListener(ac);
        JPanel btn = new JPanel(new GridLayout(1, 7, 20, 20));
        btn.add(add);
        btn.add(del);
        btn.add(update);
        btn.add(sortbyname);
        btn.add(sortbtgpa);
        btn.add(readfile);
        btn.add(exit);
        btn.setBorder(new EmptyBorder(30, 20, 10, 20));
       
        
        tsearch = new JTextField("Nhập Họ Tên Sinh Viên");
        tsearch.setForeground(Color.GRAY);
        tsearch.setFont(italic);
        tsearch.setPreferredSize(new Dimension(150, 20));
        tsearch.setBorder(new LineBorder(Color.BLACK,2));
        tsearch.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tsearch.setText("");
                tsearch.setFont(new Font("Arial",Font.PLAIN,20));
                tsearch.setForeground(Color.BLACK);            }

            @Override
            public void focusLost(FocusEvent e) {
                    if (tsearch.getText().isEmpty()) {
                    tsearch.setText("Nhập Họ Tên Sinh Viên");
                    tsearch.setForeground(Color.GRAY);
                    tsearch.setFont(new Font("Arial",Font.ITALIC,20));
                }            }
        });
        search = new JButton("Tìm Kiếm", icon_search);
        search.setBackground(Color.DARK_GRAY);
        search.setForeground(Color.white);        
        search.setFont(f);
        search.setSize(new Dimension(100, 50));
        search.setBorder(new LineBorder(Color.BLACK,2));
        search.addActionListener(ac);
        
        //search.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel p_search = new JPanel(new BorderLayout(10, 10));
        
        JPanel bt_se_re = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel ts = new JPanel(new GridLayout(1, 3));
        JLabel te = new JLabel("");
        JLabel te1 = new JLabel("NHẬP THÔNG TIN");
        te1.setFont(new Font("Arial",Font.BOLD,20));
        te1.setHorizontalAlignment(SwingConstants.CENTER);
        te1.setBorder(new EmptyBorder(0, 0, 0, 50));
        te1.setForeground(Color.decode("#F50057"));
        ts.add(te1);
        ts.add(te);
        ts.add(tsearch);
        p_search.add(ts,BorderLayout.CENTER);
        //p_search.add(tsearch,BorderLayout.CENTER);
        bt_se_re.add(search);
        bt_se_re.add(refresh);
        p_search.add(bt_se_re,BorderLayout.EAST);
        tsearch.setPreferredSize(new Dimension(500,40));
        bt_se_re.setBorder(new EmptyBorder(0, 0, 0, 20));
        p_search.setBorder(new EmptyBorder(20, 0, 0, 20));
        
        JPanel p_center = new JPanel(new BorderLayout(20, 20));
        JLabel head = new JLabel("QUẢN LÝ SINH VIÊN");
        head.setHorizontalAlignment(SwingConstants.CENTER);
        head.setFont(new Font("Arial",Font.BOLD,30));
        
        
        JPanel pn = new JPanel(new GridLayout(8, 1, 0, 20));
        pn.setBorder(new EmptyBorder(0, 20, 0, 0));
        JPanel s1 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s2 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s3 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s4 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s5 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s6 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s7 = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel s8 = new JPanel(new GridLayout(2, 1, 10, 10));

        s1.setBackground(Color.white);
        s2.setBackground(Color.WHITE);
        s3.setBackground(Color.WHITE);
        s4.setBackground(Color.WHITE);
        //s4.setBorder(bottomBorder);
        s5.setBackground(Color.WHITE);
        s6.setBackground(Color.WHITE);
        s7.setBackground(Color.WHITE);
        s8.setBackground(Color.WHITE);

        s1.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s2.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s3.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s4.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s5.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s6.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s7.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));
        s8.setBorder(new LineBorder(Color.decode("#e74c3c"), WIDTH));

        //Border b = new EmptyBorder(0, 30, 0, 30);
        Dimension d = new Dimension(350, 40);
        Dimension t = new Dimension(120, 40);
        id.setPreferredSize(t);
        //name.setBorder(b);
        name.setPreferredSize(t);
        age.setPreferredSize(t);
        gender.setPreferredSize(t);
        address.setPreferredSize(t);
        email.setPreferredSize(t);
        phone.setPreferredSize(t);
        gpa.setPreferredSize(t);

        tid.setPreferredSize(new Dimension(d));
        s1.add(id);
        s2.add(name);
        s3.add(age);
        s4.add(gender);
        s5.add(address);
        s6.add(email);
        s7.add(phone);
        s8.add(gpa);
        
        s1.add(tid);
        s2.add(tname);
        s3.add(tage);
        s4.add(p4);
        s5.add(p5);
        s6.add(temail);
        s7.add(tphone);
        s8.add(tgpa);
        pn.add(s1);
        pn.add(s2);
        pn.add(s3);
        pn.add(s4);
        pn.add(s5);
        pn.add(s6);
        pn.add(s7);
        pn.add(s8);
        
        head.setBorder(new EmptyBorder(20, 0, 0, 0));
        this.add(head,BorderLayout.NORTH);
        
        p_center.add(p_search,BorderLayout.NORTH);
        p_center.add(p_table,BorderLayout.CENTER);
        //p_center.add(dl,BorderLayout.WEST);
        p_center.add(pn,BorderLayout.WEST);

        this.add(p_center,BorderLayout.CENTER);
        this.add(btn,BorderLayout.SOUTH);
        //this.pack();
        this.setVisible(true);
    }
    
    
    public void ShowResult(){
       
        Object s[][] = new Object[list.size()][8];
        for (int i = 0; i < list.size(); i++) {
            Student n = list.get(i);
            s[i][0] = n.getId();
            s[i][1] = n.getName();
            s[i][2] = n.getAge();
            s[i][3] = n.getGender();
            s[i][4] = n.getAddress().getXa()+" - "+n.getAddress().getHuyen()+" - "+n.getAddress().getTinh();
            s[i][5] = n.getPhone();
            s[i][6] = n.getEmail();
            s[i][7] = n.getGpa();
            
        }
        Object cname[] = {
            "MSSV","HỌ TÊN","TUỔI","GIỚI TÍNH","ĐỊA CHỈ","ĐIỆN THOẠI","EMAIL","GPA"
        };
        table.setModel(new DefaultTableModel(s, cname));
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(190);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(220);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(160);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
    }
    
    public void addStudent() throws FileNotFoundException {
        Student s = new Student();
        String id = tid.getText();
        Iterator<Student> it = list.iterator();
       
        if(tid.getText().equals("Nhập Mã Số Sinh Viên")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Mã Sinh Viên");
           
        }
        else if(tname.getText().equals("Nhập Họ Tên Sinh Viên")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Họ Tên");
        }
        else if(tage.getSelectedIndex() == -1){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Tuổi");
            
        } 
        else if(!nam.isSelected() && !nu.isSelected()){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Giới Tính"); 
        
        }
        else if(xa.getText().equals("Xã")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Địa Chỉ");
        
        }
        else if(huyen.getText().equals("Huyện")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Địa Chỉ");
           
        }
        else if(tinh.getText().equals("Tỉnh")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Địa Chỉ");
            
        }
        else if(temail.getText().equals("Jessica69@gmail.com")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Email");
           
        }
        else if(tphone.getText().equals("0123456789 ")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Số Điện Thoại");
      
        }
        else if(tgpa.getText().equals("Nhập GPA")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống GPA");
          
        }

        else{
            try {
                double g = Double.parseDouble(tgpa.getText());
            } catch (Exception e) {
                System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Lại GPA, GPA Phải Là Số");
            return;
            }
             while(it.hasNext()){
                Student n = it.next();
                if(n.getId().equals(id)){
                JOptionPane.showMessageDialog(null, "Mã Sinh Viên Đã Tồn Tại");
                return;
                }
            }
            s.setId(tid.getText());
            s.setName(tname.getText());
            s.setAge((int) tage.getSelectedItem());
            if(nam.isSelected()){
            s.setGender(nam.getText());
            }
            else{
                s.setGender(nu.getText());
            }
            
            s.setAddress(new Address(xa.getText(), huyen.getText(), tinh.getText()));
            s.setEmail(temail.getText());
            s.setPhone(tphone.getText());
            s.setGpa(Double.parseDouble(tgpa.getText()));
            list.add(s);
            ShowResult();
            System.out.println(s.toString());
            //WriteFile(f);
            Font i = new Font("Arial",Font.ITALIC,20);
            Color g = Color.gray;
            tid.setText("Nhập Mã Số Sinh Viên");
            tid.setFont(i);
            tid.setForeground(g);
            tname.setText("Nhập Họ Tên");
            tname.setFont(i);
            tname.setForeground(g);
            tage.setSelectedIndex(0);
            if(nam.isSelected() || nu.isSelected()){
                gr.clearSelection();
            }
            xa.setText("Xã");
            xa.setForeground(g);
            xa.setFont(new Font("Arial",Font.ITALIC,18));
            huyen.setText("Huyện");
            huyen.setForeground(g);

            huyen.setFont(new Font("Arial",Font.ITALIC,18)); 
            tinh.setText("Tỉnh");
            tinh.setForeground(g);

            tinh.setFont(new Font("Arial",Font.ITALIC,18));
            temail.setText("Jessica69@gmail.com");
            temail.setFont(i);
            temail.setForeground(g);
            tphone.setText("0123456789");
            tphone.setFont(i);
            tphone.setForeground(g);
            tgpa.setText("Nhập GPA");
            tgpa.setFont(i);
            tgpa.setForeground(g);
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Sinh Viên");
            WriteFile(file);
        }
    }

    public void SortByName() throws FileNotFoundException {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFisrtName().compareTo(o2.getFisrtName());
            }

        });
        Object s[][] = new Object[list.size()][8];
       for (int i = 0; i < list.size(); i++) {
            Student n = list.get(i);
            s[i][0] = n.getId();
            s[i][1] = n.getName();
            s[i][2] = n.getAge();
            s[i][3] = n.getGender();
            s[i][4] = n.getAddress().getXa()+" - "+n.getAddress().getHuyen()+" - "+n.getAddress().getTinh();
            s[i][5] = n.getPhone();
            s[i][6] = n.getEmail();
            s[i][7] = n.getGpa();
            
        }
//        Object cname[] = {
//            "MSSV","HỌ TÊN","TUỔI","GIỚI TÍNH","ĐỊA CHỈ","ĐIỆN THOẠI","EMAIL","GPA"
//        };
//        table.setModel(new DefaultTableModel(s, cname));
        //model.setDataVector(s, columname);
        ShowResult();
        WriteFile(file);
    }

    public void SuaStudent() throws FileNotFoundException {
//            DefaultTableModel tm = (DefaultTableModel) table.getModel();
//            int i_row = table.getSelectedRow();
            try {
                int i_row = table.getSelectedRow();
                if(i_row != -1){
                    Luu();
                }
                else{
                    throw new Exception();
                }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sinh Viên Nào Để Sửa");
        }
        
       

    }
    
    /**
     *
     * @return
     */
    
    public void XoaStudent() throws FileNotFoundException {
        UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));

        DefaultTableModel md = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if(i_row != -1){
              var lc = JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xoá Sinh Viên Này? ","Xoá Sinh Viên",JOptionPane.YES_NO_OPTION);
            if (lc == JOptionPane.YES_OPTION) {
            md.removeRow(i_row);
            list.remove(i_row);
            WriteFile(file);
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Sinh Viên Muốn Xoá");
        }
    }

    public void SortByGPA() throws FileNotFoundException {
    Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                
                return (o1.getGpa() > o2.getGpa()) ? -1:1;
                
            }

        });
        Object s[][] = new Object[list.size()][8];
       for (int i = 0; i < list.size(); i++) {
            Student n = list.get(i);
            s[i][0] = n.getId();
            s[i][1] = n.getName();
            s[i][2] = n.getAge();
            s[i][3] = n.getGender();
            s[i][4] = n.getAddress().getXa()+" - "+n.getAddress().getHuyen()+" - "+n.getAddress().getTinh();
            s[i][5] = n.getPhone();
            s[i][6] = n.getEmail();
            s[i][7] = n.getGpa();
            
        }
//        Object cname[] = {
//            "MSSV","HỌ TÊN","TUỔI","GIỚI TÍNH","ĐỊA CHỈ","ĐIỆN THOẠI","EMAIL","GPA"
//        };
//        table.setModel(new DefaultTableModel(s, cname));
        ShowResult();
        WriteFile(file);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }


    public void ReadFile(File file) {       
         try {
            setFile(file);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Student> listStudent = new ArrayList<Student>();

            while (fis.available() > 0) {
                Student s = (Student) ois.readObject();
                listStudent.add(s);
                
            }
                                     System.out.println(file);
            setList(listStudent);
            System.out.println("Doc File Thanh Cong");
            ShowResult();
            ois.close();
            fis.close();
        } catch (Exception e) {
        }
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public int compareTo(Student o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void WriteFile(File file) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Student s : list) {
               oos.writeObject(s);
            }
            System.out.println("Da ghi du lieu ra file");
            oos.close();
            fos.close();
        } catch (Exception e) {
        }
    }

    public void Search() {
        DefaultTableModel md = (DefaultTableModel) table.getModel();
        md.setRowCount(0);
        String n = tsearch.getText().toLowerCase();
        for(int i = 0;i < list.size();i++){
            Student s = list.get(i);
            if(s.getName().toLowerCase().contains(n)){

            md.addRow(new Object[]{s.getId(),s.getName(),s.getAge(),s.getGender(),s.getAddress().getXa()+" - "+s.getAddress().getHuyen()+" - "+s.getAddress().getTinh(),s.getPhone(),s.getEmail(),s.getGpa()});
            }
      
        }
//          Object cname[] = {
//            "MSSV","HỌ TÊN","TUỔI","GIỚI TÍNH","ĐỊA CHỈ","ĐIỆN THOẠI","EMAIL","GPA"
//        };
        }

    public void Refresh() {
        tsearch.setText("Nhập Họ Tên Sinh Viên");
        tsearch.setForeground(Color.GRAY);
        tsearch.setFont(new Font("Arial",Font.ITALIC,20));
        ShowResult();
    }
    
    public void Luu(){
        JFrame luu = new JFrame("Cập Nhật Thông Tin Sinh Viên");
        luu.setSize(800 , 500);
        luu.setLocationRelativeTo(null);
        luu.setTitle("SỬA THÔNG TIN SINH VIÊN");
        Font f = new Font("Arial", Font.BOLD, 20);

        name = new JLabel("Họ Tên Sinh Viên");
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setFont(f);
        age = new JLabel("Tuổi");
        age.setHorizontalAlignment(SwingConstants.CENTER);
        age.setFont(f);
        address = new JLabel("Địa Chỉ");
        address.setHorizontalAlignment(SwingConstants.CENTER);
        address.setFont(f);
        email = new JLabel("Địa Chỉ Email");
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setFont(f);
        phone = new JLabel("Số Điện Thoại");
        phone.setHorizontalAlignment(SwingConstants.CENTER);
        phone.setFont(f);
        gpa = new JLabel("GPA");
        gpa.setHorizontalAlignment(SwingConstants.CENTER);
        gpa.setFont(f);
        gender = new JLabel("Giới Tính");
        gender.setHorizontalAlignment(SwingConstants.CENTER);
        gender.setFont(f);
        Font italic = new Font("Arial",Font.ITALIC,20);
        tname = new JTextField("Nhập Họ Tên Sinh Viên");
        tname.setFont(italic);
        tname.setForeground(Color.GRAY);
        tname.setBorder(new LineBorder(Color.red, WIDTH));
        //tname.setHorizontalAlignment(SwingConstants.CENTER);
        tname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tname.setText("");
                tname.setFont(new Font("Arial",Font.PLAIN,20));
                tname.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tname.getText().isEmpty()) {
                    tname.setText("Nhập Họ Tên Sinh Viên");
                    tname.setForeground(Color.GRAY);
                    tname.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
         Integer[] ages = new Integer[101];
        for (int i = 1; i <= 100; i++) {
            ages[i] = i;
        }
        tage = new JComboBox<>(ages);
        tage.setFont(f);
        tage.setBorder(new EmptyBorder(0, 0, 0, 0));
        tage.setEditable(true);
        tage.setBorder(new LineBorder(Color.red, WIDTH));

        Border bd = new EmptyBorder(0, 0, 0, 0);
        Font f18 = new Font("Arial",Font.ITALIC,18);
        xa = new JTextField("Xã");
        xa.setFont(f18);
        xa.setForeground(Color.GRAY);
        xa.setBorder(new EmptyBorder(0, 0, 0, 0));
        xa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                xa.setText("");
                xa.setFont(new Font("Arial",Font.PLAIN,18));
                xa.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (xa.getText().isEmpty()) {
                    xa.setText("Xã");
                    xa.setForeground(Color.GRAY);
                    xa.setFont(new Font("Arial",Font.ITALIC,18));
                }
            }
        });
         huyen = new JTextField("Huyện");
         huyen.setFont(f18);
         huyen.setForeground(Color.GRAY);
         huyen.setBorder(new EmptyBorder(0, 0, 0, 0));
         huyen.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                huyen.setText("");
                huyen.setFont(new Font("Arial",Font.PLAIN,18));
                huyen.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (huyen.getText().isEmpty()) {
                    huyen.setText("Huyện");
                    huyen.setForeground(Color.GRAY);
                    huyen.setFont(new Font("Arial",Font.ITALIC,18));
                }
            }
        });
         tinh = new JTextField("Tỉnh");
         tinh.setFont(f18);
         tinh.setForeground(Color.GRAY);
         tinh.setBorder(new EmptyBorder(0, 0, 0, 0));
         tinh.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tinh.setText("");
                tinh.setFont(new Font("Arial",Font.PLAIN,18));
                tinh.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tinh.getText().isEmpty()) {
                    tinh.setText("Tỉnh");
                    tinh.setForeground(Color.GRAY);
                    tinh.setFont(new Font("Arial",Font.ITALIC,18));
                }
            }
        });
        
         //tạo textfield nhập email
        temail = new JTextField("Jessica69@gmail.com");
        temail.setFont(italic);
        temail.setBorder(new LineBorder(Color.red, WIDTH));
        //temail.setHorizontalAlignment(SwingConstants.CENTER);
        temail.setForeground(Color.gray);
        temail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                temail.setText("");
                temail.setFont(new Font("Arial",Font.PLAIN,20));
                temail.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (temail.getText().isEmpty()) {
                    temail.setText("Jessica69@gmail.com");
                    temail.setForeground(Color.GRAY);
                    temail.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        // tạo textfield nhập SĐT
        tphone = new JTextField("0123456789");
        tphone.setFont(italic);
        //tphone.setHorizontalAlignment(SwingConstants.CENTER);
        tphone.setForeground(Color.GRAY);
        tphone.setBorder(new LineBorder(Color.red, WIDTH));
        tphone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tphone.setText("");
                tphone.setFont(new Font("Arial",Font.PLAIN,20));
                tphone.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tphone.getText().isEmpty()) {
                    tphone.setText("0123456789");
                    tphone.setForeground(Color.GRAY);
                    tphone.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        // tạo textfield nhập điểm gpa
        tgpa = new JTextField("Nhập GPA");
        tgpa.setFont(italic);
        tgpa.setBorder(new LineBorder(Color.red, WIDTH));
        tgpa.setForeground(Color.gray);
        tgpa.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Xử lý khi nhận focus
                tgpa.setText("");
                tgpa.setFont(new Font("Arial",Font.PLAIN,20));
                tgpa.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Xử lý khi mất focus
                if (tgpa.getText().isEmpty()) {
                    tgpa.setText("Nhập GPA");
                    tgpa.setForeground(Color.GRAY);
                    tgpa.setFont(new Font("Arial",Font.ITALIC,20));
                }
            }
        });
        
        nam = new JRadioButton("Nam");
        nam.setFont(f);
        nu = new JRadioButton("Nữ");
        nu.setFont(f);
        
        // panel chứa các textfield dữ liệu
        JPanel text = new JPanel(new GridLayout(7, 1, 10, 10));
        
        Border b = new EmptyBorder(20, 0, 20, 20);
        text.setBorder(b);
        // thêm các textfield vào panel text
        JPanel s2 = new JPanel(new BorderLayout(10, 10));
        JPanel s3 = new JPanel(new BorderLayout(10, 10));
        JPanel s4 = new JPanel(new BorderLayout(10, 10));
        JPanel s5 = new JPanel(new BorderLayout(10, 10));
        JPanel s6 = new JPanel(new BorderLayout(10, 10));
        JPanel s7 = new JPanel(new BorderLayout(10, 10));
        JPanel s8 = new JPanel(new BorderLayout(10, 10));
        
        
        JPanel p4 = new JPanel(new FlowLayout(SwingConstants.CENTER));
        p4.setBorder(new LineBorder(Color.red, WIDTH));
        p4.add(nam,SwingConstants.CENTER);
        p4.add(nu);
        nam.setBackground(Color.white);
        nu.setBackground(Color.white);

        p4.setBackground(Color.white);

        Dimension t = new Dimension(300, 40);
        
        name.setPreferredSize(t);
        age.setPreferredSize(t);
        gender.setPreferredSize(t);
        address.setPreferredSize(t);
        email.setPreferredSize(t);
        phone.setPreferredSize(t);
        gpa.setPreferredSize(t);

        s2.add(name,BorderLayout.WEST);
        s3.add(age,BorderLayout.WEST);
        s4.add(gender,BorderLayout.WEST);
        s5.add(address,BorderLayout.WEST);
        s6.add(email,BorderLayout.WEST);
        s7.add(phone,BorderLayout.WEST);
        s8.add(gpa,BorderLayout.WEST);
        
        // panel chứa textfield địa chỉ
        JPanel p_add = new JPanel(new GridLayout(1, 3, 0, 0));
        p_add.setBorder(new LineBorder(Color.red, WIDTH));
        p_add.add(xa);
        p_add.add(huyen);
        p_add.add(tinh);

        s2.add(tname,BorderLayout.CENTER);
        s3.add(tage,BorderLayout.CENTER);
        s4.add(p4,BorderLayout.CENTER);
        s5.add(p_add,BorderLayout.CENTER);
        s6.add(temail,BorderLayout.CENTER);
        s7.add(tphone,BorderLayout.CENTER);
        s8.add(tgpa,BorderLayout.CENTER);
        
        JButton save = new JButton("Lưu");
        JButton huy = new JButton("Huỷ");
        save.setFont(f);
        save.setBackground(Color.DARK_GRAY);
        save.setForeground(Color.WHITE);
        huy.setFont(f);
        huy.setBackground(Color.DARK_GRAY);
        huy.setForeground(Color.WHITE);
        huy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                luu.setVisible(false);
            }
        });
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        save();
                        luu.setVisible(false);
                } catch (FileNotFoundException ex) {
                }
            }
        });
        
        luu.setLayout(new BorderLayout(10, 10));
        text.add(s2);
        text.add(s3);
        text.add(s4);
        text.add(s5);
        text.add(s6);
        text.add(s7);
        text.add(s8);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(save);
        p1.add(huy);
        luu.add(text,BorderLayout.CENTER);
        luu.add(p1,BorderLayout.SOUTH);
        luu.setVisible(true);
    }
    public void save() throws FileNotFoundException{
        
        DefaultTableModel tm = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        if(tname.getText().equals("Nhập Họ Tên Sinh Viên")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Họ Tên");
        }
        else if(tage.getSelectedIndex() == -1){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Tuổi");
            
        } 
        else if(!nam.isSelected() && !nu.isSelected()){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Giới Tính"); 
        
        }
        else if(xa.getText().equals("Xã")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Địa Chỉ");
        
        }
        else if(huyen.getText().equals("Huyện")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Địa Chỉ");
           
        }
        else if(tinh.getText().equals("Tỉnh")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Địa Chỉ");
            
        }
        else if(temail.getText().equals("Jessica69@gmail.com")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Email");
           
        }
        else if(tphone.getText().equals("0123456789")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống Số Điện Thoại");
      
        }
        else if(tgpa.getText().equals("Nhập GPA")){
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Vui Lòng Không Bỏ Trống GPA");
          
        }

        else{
            
            try {
                double g = Double.parseDouble(tgpa.getText());
            } catch (Exception e) {
                System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Lại GPA, GPA Phải Là Số");
            return;
            }
            }
            Student s = list.get(i_row);
            s.setName(tname.getText());
            s.setAge((int) tage.getSelectedItem());
            if(nam.isSelected()){
            s.setGender(nam.getText());
            }
            else{
                s.setGender(nu.getText());
            }
            
            s.setAddress(new Address(xa.getText(), huyen.getText(), tinh.getText()));
            s.setEmail(temail.getText());
            s.setPhone(tphone.getText());
            s.setGpa(Double.parseDouble(tgpa.getText()));
            ShowResult();
            System.out.println(s.toString());
            //WriteFile(f);
            Font i = new Font("Arial",Font.ITALIC,20);
            Color g = Color.gray;
            tid.setText("Nhập Mã Số Sinh Viên");
            tid.setFont(i);
            tid.setForeground(g);
            tname.setText("Nhập Họ Tên");
            tname.setFont(i);
            tname.setForeground(g);
            tage.setSelectedIndex(0);
            if(nam.isSelected() || nu.isSelected()){
                gr.clearSelection();
            }
            xa.setText("Xã");
            xa.setForeground(g);
            xa.setFont(new Font("Arial",Font.ITALIC,18));
            huyen.setText("Huyện");
            huyen.setForeground(g);
            huyen.setFont(new Font("Arial",Font.ITALIC,18)); 
            tinh.setText("Tỉnh");
            tinh.setForeground(g);
            tinh.setFont(new Font("Arial",Font.ITALIC,18));
            temail.setText("Jessica69@gmail.com");
            temail.setFont(i);
            temail.setForeground(g);
            tphone.setText("0123456789");
            tphone.setFont(i);
            tphone.setForeground(g);
            tgpa.setText("Nhập GPA");
            tgpa.setFont(i);
            tgpa.setForeground(g);
            WriteFile(file);
            UIManager.put("OptionPane.messageFont", new Font("Arial",Font.PLAIN,20));
            JOptionPane.showMessageDialog(null, "Lưu Thành công");
            
    }
}
    
   

