/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gudang;
import java.util.*;
/**
 *
 * @author OWNER
 */
public class DataPribadi {
    private ArrayList<Karyawan> pegawai=new ArrayList();
    
    public DataPribadi(){
        Karyawan karyawan=new Karyawan();
        pegawai.add(karyawan);
    }
    
    
    public int login(String noPegawai,String password){
        boolean adaNo=false;
        int status=0;
        int index=0;
        for(int i=0;i<pegawai.size();i++){
            if(noPegawai.equals(pegawai.get(i).getNoPegawai())){
                adaNo=true;
                index=i;
                break;
            }
        }
        if(adaNo==true){
            //login berhasil
            if(password.equals(pegawai.get(index).getPassword())){
                status=0;
            }
            //login gagal karena salah password
            else{
                status=1;
            }
        }
        //login gagal karena noPegawai tidak ditemukan
        else{
            status=2;
        }
        return status;
    }
    
    public boolean daftar(String noPegawai,String password){
        boolean sudahAda=false;
        for(int i=0;i<pegawai.size();i++){
            if(noPegawai.equals(pegawai.get(i).getNoPegawai())){
                sudahAda=true;
                break;
            }
        }
        if(sudahAda==false){
            Karyawan karyawan= new Karyawan(noPegawai,password);
            pegawai.add(karyawan);
        }
        return sudahAda;
    }
    
    public void cetakPegawai(){
        for(int i=0;i<pegawai.size();i++){
            System.out.println(pegawai.get(i).getNoPegawai());
        }
    }
    
}
