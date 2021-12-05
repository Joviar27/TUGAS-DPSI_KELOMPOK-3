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
public class Transaksi {
    private ArrayList<Barang> barangMasuk=new ArrayList();
    private ArrayList<Barang> barangKeluar=new ArrayList();
    
    public Transaksi(){
        
    }
    
    public void TransaksiBarangMasuk(Barang barang){
        barangMasuk.add(barang);
    }
    
    public void TransaksiBarangKeluar(Barang barang){
        barangKeluar.add(barang);
    }
    
    public void cetakBarangMasuk(){
        for(int i=0;i<barangMasuk.size();i++){
            barangMasuk.get(i).cetakBarang();
            System.out.println();
        }
    }
    
     public void cetakBarangKeluar(){
        for(int i=0;i<barangKeluar.size();i++){
            barangKeluar.get(i).cetakBarang();
            System.out.println();
        }
    }
}
