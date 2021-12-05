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
public class dataRak {
    private ArrayList<Rak> shelf=new ArrayList();
    
    public dataRak(){
        Rak rak1=new Rak("M1","Makanan",100);
        shelf.add(rak1);
        Rak rak2=new Rak("N2","Minuman",100);
        shelf.add(rak2);
    }
    
    /*
    public int cekSisaKapasitas(String jenis){
        int total=0;
        
        for(int i=0;i<shelf.size();i++){
            if(jenis.equals(shelf.get(i).getJenis())){
                total=+shelf.get(i).getSisaKapasitas();
            }
        }
        return total;
    }
    */
    
    public int isiRak(String ID, String letak, String jenis, int stok){
        int status=0;
        for(int i=0;i<shelf.size();i++){
            if(letak.equals(shelf.get(i).getNama())){
                if(jenis.equals(shelf.get(i).getJenis())){
                    if(stok<=shelf.get(i).getSisaKapasitas()){
                        shelf.get(i).isi(ID, stok);
                        //barang berhasil masuk
                        status=1;
                        break;
                    }
                    else{
                        //semua rak penuh
                        status=2;
                        break;
                    }
                }
                else{
                    status=3;//Jenis Barang tidak Cocok
                    break;
                }
            }
            else{
                status=4;//Rak yang dicari tidak ada
            }
        }
        return status;
    }
   /*
    public String getLetakBarang(String ID){
        String namaRak=null;
        for(int i=0;i<shelf.size();i++){
            if(ID.equals(shelf.get(i).getNama())){
                namaRak=shelf.get(i).getNama();
            }
        }
        return namaRak;
    }
*/
    
    public int keluarRak(String letak, String ID, int stok){
        int status=0;
        for(int i=0;i<shelf.size();i++){
            if(letak.equals(shelf.get(i).getNama())){
                status=shelf.get(i).keluar(ID, stok);
                break;
            }
            else{
                status=3;//Rak yang dipilih tidak ada
            }
        }
        return status;
    }
    
    public void getDaftarRak(){
        for (int i=0;i<shelf.size();i++){
            System.out.println((i+1)+". "+shelf.get(i).getNama());
        }
    }
    
}
