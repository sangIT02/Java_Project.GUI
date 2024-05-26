/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Student implements Serializable{
    private String id;
    private String name;
    private int age;
    private String gender;
    private Address address;
    private String email;
    private String phone;
    private double gpa;

    public Student(String id, String name, int age, String gender, Address address, String email, String phone, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gpa = gpa;
    }

    public Student() {
        address = new Address();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public String getFisrtName(){
        String[] word = this.name.split(" ");
        return word[word.length-1];
    }
    
    public int solg(){
        String w[] = this.name.split(" ");
        return w.length;
    }
    public String getLastName(){
        String[] word = this.name.split(" ");
        return word[0];
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address.toString() + ", email=" + email + ", phone=" + phone + ", gpa=" + gpa + '}';
    }

    public Object removeDiacritics(String fisrtName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
