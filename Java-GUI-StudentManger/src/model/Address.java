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
public class Address implements Serializable{
    private String xa;
    private String huyen;
    private String tinh;

    public Address() {
    }

    public Address(String xa, String huyen, String tinh) {
        this.xa = xa;
        this.huyen = huyen;
        this.tinh = tinh;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    @Override
    public String toString() {
        return "Address{" + "xa=" + xa + ", huyen=" + huyen + ", tinh=" + tinh + '}';
    }
    
}
