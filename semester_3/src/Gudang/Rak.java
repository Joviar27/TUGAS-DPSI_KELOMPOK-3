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
public class Rak {
    private ArrayList<String[]> IDandStok;
    private String nama;
    private String jenis;
    private int totalKapasitas;
    private int sisaKapasitas;
    
    public Rak(String nama, String jenis, int totalKapasitas){
        IDandStok=new ArrayList();
        this.nama=nama;
        this.jenis=jenis;
        this.totalKapasitas=totalKapasitas;
        sisaKapasitas=totalKapasitas;
    }
    
    public int getSisaKapasitas(){
        return sisaKapasitas;
    }
    public String getJenis(){
        return jenis;
    }
    public String getNama(){
        return nama;
    }
    
    public void isi(String ID,int stok){
        boolean adaID=false;
        int index=0;
        for(int i=0;i<IDandStok.size();i++){
            if(ID.equals(IDandStok.get(i)[0])){
                adaID=true;
                index=i;
                break;
            }  
        }
        
        if(adaID==false){
            String [] identitas= {ID, Integer.toString(stok)};
            IDandStok.add(identitas);
            sisaKapasitas-=stok;
        }
        else{
            String [] identitas= IDandStok.get(index);
            identitas[1]=Integer.toString(Integer.parseInt(identitas[1])+stok);
            IDandStok.set(index, identitas);
            sisaKapasitas-=stok;
        }
    }
    
    public int keluar(String ID, int stok){
        int status=0;//barang tidak ada di rak
        boolean adaID=false;
        int index=0;
        for(int i=0;i<IDandStok.size();i++){
            if(ID.equals(IDandStok.get(i)[0])){
                adaID=true;
                index= i;
            }
        }
        
        if(adaID==true){
            if(stok<Integer.parseInt(IDandStok.get(index)[1])){
                IDandStok.get(index)[1]=Integer.toString(Integer.parseInt(IDandStok.get(index)[1])-stok);
                status=1;
                sisaKapasitas+=stok;
            }
            else if(stok==Integer.parseInt(IDandStok.get(index)[1])){
                IDandStok.remove(index);
                status=1;
                sisaKapasitas+=stok;
            }
            else{
                status=2;//jumlah barang yang mau diambil melebih stok
            }
        }
        return status;
    } 
}
