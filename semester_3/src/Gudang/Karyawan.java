/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gudang;

/**
 *
 * @author OWNER
 */
public class Karyawan {
    private String noPegawai;
    private String password;
    
    public Karyawan(){
        noPegawai="1234567";
        password="rahasia";
    }
    
    public Karyawan(String noPegawai,String password){
        this.noPegawai=noPegawai;
        this.password=password;
    }
    
    public String getNoPegawai(){
        return noPegawai;
    }
    public String getPassword(){
        return password;
    }
    public void setNoPegawai(String noPegawai){
        this.noPegawai= noPegawai;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
