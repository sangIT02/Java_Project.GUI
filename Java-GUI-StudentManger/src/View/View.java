/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class View extends JFrame {

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
    private JTextField tage;
    private JComboBox tadd;
    private JTextField temail;
    private JTextField tphone;
    private JTextField tgpa;
    
    private JButton add;
    private JButton update;
    private JButton del;
    private JButton search;
    private JButton readfile;
    private JButton sortbyname;
    private JButton sortbtgpa;
    private JButton exit;

    public View() {
        init();
    }

    private void init() {
        this.setSize(1000, 800);
        this.setTitle("Student manager");
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 1, 20, 20));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon iadd = new ImageIcon("C:\\Users\\PC\\OneDrive\\Desktop\\Swing_Java\\Java-GUI-StudentManger\\test\\add.png");
        ImageIcon idel = new ImageIcon("C:\\Users\\PC\\OneDrive\\Desktop\\Swing_Java\\Java-GUI-StudentManger\\test\\del.png");
        ImageIcon iupdate = new ImageIcon("C:\\Users\\PC\\OneDrive\\Desktop\\Swing_Java\\Java-GUI-StudentManger\\test\\update.png");
        ImageIcon isearch = new ImageIcon("C:\\Users\\PC\\OneDrive\\Desktop\\Swing_Java\\Java-GUI-StudentManger\\test\\search.png");
        int width = 30; // Chiều rộng mới
        int height = 30; // Chiều cao mới
        Image sadd = iadd.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image sdel = idel.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image supdate = iupdate.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Image ssearch = isearch.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Tạo biểu tượng mới với kích thước đã đặt
        ImageIcon icon_add = new ImageIcon(sadd);
        ImageIcon icon_del = new ImageIcon(sdel);
        ImageIcon icon_update = new ImageIcon(supdate);
        ImageIcon icon_search = new ImageIcon(ssearch);

        JPanel dl = new JPanel(new GridLayout(2, 4, 10, 10));
        id = new JLabel("ID");
        name = new JLabel("Name");
        age = new JLabel("Age");
        address = new JLabel("Address");
        email = new JLabel("Email");
        phone = new JLabel("Phone");
        gpa = new JLabel("GPA");
        gender = new JLabel("Gioi Tinh");
        tid = new JTextField();
        tname = new JTextField();
        tage = new JTextField();
        Object o[] = {
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
        tadd = new JComboBox(o);
        temail = new JTextField();
        tphone = new JTextField();
        tgpa = new JTextField();
        nam = new JRadioButton("Nam");
        nu = new JRadioButton("Nữ");
        
        Object cname[] = {
            "ID","NAME","AGE","GENDER","ADDRESS","PHONE","EMAIL","GPA"
        };
        Object data[][] = {
            
        };
         JPanel p4 = new JPanel(new GridLayout(1, 2, 0, 0));
         p4.add(nam);
         p4.add(nu);
        dl.add(id);
        dl.add(tid);
        dl.add(name);
        dl.add(tname);
        dl.add(age);
        dl.add(tage);
        dl.add(gender);
        dl.add(p4);
        dl.add(address);
        dl.add(tadd);
        dl.add(phone);
        dl.add(tphone);
        dl.add(email);
        dl.add(temail);
        dl.add(gpa);
        dl.add(tgpa);
//        dl.add(address);
//        dl.add(address);

        model = new DefaultTableModel(data, cname);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(960, 260));
        jsp = new JScrollPane(table);
        ButtonGroup gr = new ButtonGroup();
        gr.add(nam);
        gr.add(nu);
        
        
        Font f = new Font("Arial", Font.PLAIN, 20);
        add = new JButton("Thêm", icon_add);
        add.setBackground(Color.WHITE);
        add.setFont(f);
        del = new JButton("Xoá", icon_del);
        del.setBackground(Color.WHITE);
        del.setFont(f);
        update = new JButton("Sửa", icon_update);
        update.setBackground(Color.WHITE);
        update.setFont(f);
        JPanel p2 = new JPanel(new GridLayout(1, 3, 20, 20));
        p2.add(add);
        p2.add(del);
        p2.add(update);
        JPanel p1 = new JPanel();
        p1.add(jsp);
        p1.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        tsearch = new JTextField();
        tsearch.setFont(f);
        search = new JButton("Search", icon_search);
        search.setBackground(Color.WHITE);
        search.setFont(f);
        search.setSize(new Dimension(100, 50));
        search.setBorder(new LineBorder(Color.BLACK));
        //search.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel p3 = new JPanel(new BorderLayout(10, 10));
        p3.setBorder(new EmptyBorder(20, 300, 10, 100));
        p3.add(tsearch,BorderLayout.CENTER);
        p3.add(search,BorderLayout.EAST);
        
        JPanel p5 = new JPanel(new BorderLayout(20, 20));
        p5.add(p1,BorderLayout.CENTER);
        p5.add(p3,BorderLayout.BEFORE_FIRST_LINE);
        this.add(p5);
        this.add(p4);
        this.setVisible(true);
    }

}
