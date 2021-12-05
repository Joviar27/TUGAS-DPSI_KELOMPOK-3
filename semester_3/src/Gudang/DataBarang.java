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
public class DataBarang {
    private ArrayList<Barang> item=new ArrayList();
    
    public DataBarang(){
        
    }
    
    private dataRak ShelfList=new dataRak();
    private Transaksi Transaction=new Transaksi();
    
    public int barangMasuk(String ID, String letak, int stok){
        boolean adaBarang=false;
        String jenis=null;
        int index=0;
        int status=0;//barang tidak ada
        for(int i=0;i<item.size();i++){
            if(ID.equals(item.get(i).getID())){
                adaBarang=true;
                jenis=item.get(i).getJenis();
                index=i;
                break;
            }
        }
        
        if(adaBarang==true){
            status=ShelfList.isiRak(ID, letak, jenis, stok);
            
            if(status==1){
                //barang berhasil dimasukkan ke rak
                item.get(index).tambahStok(stok);
                
                String namaBarang=item.get(index).getNama();
                Barang barang=new Barang(ID, namaBarang, jenis, stok);
                Transaction.TransaksiBarangMasuk(barang);
            }
        } 
        return status;
    }
    
    public int barangKeluar(String letak, String ID, int stok){
        int status=4;//Barang tidak ada di daftar item
        boolean adaID=false;
        boolean stokAda=false;
        int index=0;
        for(int i=0;i<item.size();i++){
            if(ID.equals(item.get(i).getID())){
                index=i;
                adaID=true;
                if(stok<=item.get(i).getStok()){
                    stokAda=true;
                    break;
                }
                else{
                    status=5;//Stok yang ingin diambil melebih stok di daftar item
                    break;
                }
            }
        }
        
        if(adaID==true && stokAda==true){
            status=ShelfList.keluarRak(letak, ID, stok);
            
            if(status==1){
                //barang berhasil keluar
                item.get(index).kurangStok(stok);
                
                String namaBarang=item.get(index).getNama();
                String jenisBarang=item.get(index).getJenis();
                Barang barang=new Barang(ID, namaBarang, jenisBarang, stok);
                Transaction.TransaksiBarangKeluar(barang);
            }
        }
        return status;
    }
    
    public int tambahBarang(String ID, String nama, String jenis){
        boolean adaBarang=false;
        int status=0;//barang sudah ada
        for(int i=0;i<item.size();i++){
            if(ID.equals(item.get(i).getID()) || nama.equals(item.get(i).getNama())){
                adaBarang=true;
                break;
            }
        }
        
        if(adaBarang==false){
            Barang barang=new Barang(ID, nama, jenis);
            item.add(barang);
            status=1;
        }
        return status;
    }
    
    public void ListRak(){
        ShelfList.getDaftarRak();
    }
    
    public void cetakSemuaBarang(){
        if(item.size()<1){
            System.out.println("Gudang Kosong");
        }
        else{
            for(int i=0;i<item.size();i++){
                System.out.println("No. "+(i+1));
                item.get(i).cetakBarang();
                System.out.println();
            }
        }
    }
    
    public void cetakIsiRak(){
        for(int i=0;i<item.size();i++){
            if(item.get(i).getLetak().equals("M1")){
                System.out.println("RAK M1");
                item.get(i).cetakBarang2();
                System.out.println();
            }
            else if(item.get(i).getLetak().equals("N2")){
                System.out.println("RAK N2");
                item.get(i).cetakBarang2();
                System.out.println();
            }
        }
    }
    
    public void cetakTransaksiMasuk(){
        Transaction.cetakBarangMasuk();
    }
    
    public void cetakTransaksiKeluar(){
        Transaction.cetakBarangKeluar();
    }
    
}
