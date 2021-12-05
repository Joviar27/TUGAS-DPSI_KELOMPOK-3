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
public class Barang {
    private String ID;
    private String nama;
    private String jenis;
    private String satuan;
    private int stok=0;
    private String letak;
    
    public Barang(){
        ID="A00000";
        nama="sample";
        jenis="sample";
        stok=1;
    }
    
    public Barang(String ID, String nama, String jenis){
        this.ID=ID;
        this.nama=nama;
        this.jenis=jenis;
        
        switch (jenis){
            case "Makanan":
                satuan="Kilogram";
                letak="M1";
                break;
            case "Minuman":
                satuan="Liter";
                letak="N2";
                break;
        }
    }
    
    public Barang(String ID, String nama, String jenis, int stok){
        this.ID=ID;
        this.nama=nama;
        this.jenis=jenis;
        
        switch (jenis){
            case "Makanan":
                satuan="Kilogram";
                letak="M1";
                break;
            case "Minuman":
                satuan="Liter";
                letak="N2";
                break;
        }
        this.stok=stok;
    }    
   
    
    public String getID(){
        return ID;
    }
    public String getNama(){
        return nama;
    }
    public String getJenis(){
        return jenis;
    }
    public int getStok(){
        return stok;
    }
    public String getSatuan(){
        return satuan;
    }
    public String getLetak(){
        return letak;
    }
    public void tambahStok(int stok){
        this.stok+=stok;
    }
    public void kurangStok(int stok){
        this.stok-=stok;
    }
    
    public void cetakBarang(){
        System.out.println("ID Barang: "+ID);
        System.out.println("Nama Barang: "+nama);
        System.out.println("Jenis Barang: "+jenis);
        System.out.println("Satuan: "+satuan);
        System.out.println("Stok :"+stok);                
    }
    
    public void cetakBarang2(){
        System.out.println("ID Barang: "+ID);
        System.out.println("Nama Barang: "+nama);
        System.out.println("Jenis Barang: "+jenis);
        System.out.println("Satuan: "+satuan);               
    }
    
}
