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
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        //proses masuk dan daftar
        int opsi1;
        boolean berhasil=false;
        boolean berjalan=true;
        
        DataPribadi dataPribadi=new DataPribadi();
        proses1: while(berjalan=true){
            System.out.println("Selamat Datang di SISMa");
            System.out.println("1. Masuk");
            System.out.println("2. Daftar");
        
            System.out.println();
            System.out.print("Pilihan: ");
            opsi1=sc.nextInt();sc.nextLine();
            System.out.println();
            
            String noPegawai,password;
            switch(opsi1){
                case 1:
                    System.out.print("Nomor Pegawai: ");
                    noPegawai=sc.nextLine();
                    System.out.print("Password: ");
                    password=sc.nextLine();
                    
                    int status1=dataPribadi.login(noPegawai,password);
                    System.out.println();
                    if(status1==0){
                        System.out.println("Login berhasil");
                        System.out.println();
                        berhasil=true;
                        break proses1;
                    }
                    else if(status1==1){
                        System.out.println("Password yang Dimasukkan Salah");
                    }
                    else if(status1==2){
                        System.out.println("Nomor Pegawai yang Dimasukkan Tidak Terdaftar");
                    }
                    break;
                case 2:
                    System.out.print("Nomor Pegawai: ");
                    noPegawai=sc.nextLine();
                    System.out.print("Password: ");
                    password=sc.nextLine();
                    
                    boolean status2=dataPribadi.daftar(noPegawai, password);
                    System.out.println();
                    if(status2==false){
                        System.out.println("Berhasil Daftar");
                    }
                    else if(status2==true){
                        System.out.println("Nomor Pegawai yang Anda Masukkan Sudah Ada");
                    }
                    break;
                default:
                    System.out.println("Input salah, silahkan ulangi");
            }
            System.out.println();
        }
        
        DataBarang ItemList= new DataBarang();        
        proses2 :while(berhasil==true){
            int opsi2;
            System.out.println();
            System.out.println("Pilih Menu");
            System.out.println("1. Beranda");
            System.out.println("2. Stok Barang");
            System.out.println("3. Transaksi");
            System.out.println("4. Keluar");
            
            System.out.print("Pilih Menu: ");
            opsi2=sc.nextInt(); sc.nextLine();
            
            switch(opsi2){
                case 1:
                    proses3: while(berhasil==true){
                        int opsi3;
                        System.out.println();
                        System.out.println("Selamat Datang !");
                        System.out.println("1. Tambah Barang");
                        System.out.println("2. Barang Masuk");
                        System.out.println("3. Barang Keluar");
                        System.out.println("4. Kembali");
                        System.out.println();
                    
                        System.out.println("Stok Barang yang Ada");
                    
                        System.out.println();
                        ItemList.cetakSemuaBarang();
                        System.out.println();
                    
                        System.out.print("Pilih Menu: ");
                        opsi3=sc.nextInt();sc.nextLine();
                        
                        String id,nama,jenis,letak;
                        int status, stok;
                        switch (opsi3){
                            case 1:
                                System.out.println();
                                System.out.println("MENAMBAHKAN BARANG BARU");
                                System.out.print("ID Barang: ");
                                id=sc.nextLine();
                                System.out.print("Nama Barang: ");
                                nama=sc.nextLine();
                                System.out.print("Jenis Barang: ");
                                jenis=sc.nextLine();
                                System.out.println();
                            
                                status=ItemList.tambahBarang(id, nama, jenis);
                                if(status==0){
                                    System.out.println("Barang Sudah Ada");
                                }
                                else{
                                    System.out.println("Barang Berhasil Ditambahkan");
                                }
                                break;
                            
                            case 2:
                                System.out.println();
                                System.out.println("MEMASUKKAN BARANG");
                                System.out.println();
                                System.out.println("Rak yang Tersedia :");
                                ItemList.ListRak();
                                System.out.println();
                            
                                System.out.print("ID Barang: ");
                                id=sc.nextLine();
                                System.out.print("Letak Barang: ");
                                letak=sc.nextLine();
                                System.out.print("Jumlah Stok: ");
                                stok=sc.nextInt();
                                System.out.println();
                                
                                status=ItemList.barangMasuk(id, letak, stok);
                                
                                switch (status){
                                    case 0:
                                        System.out.println("ID Barang Belum Ada");
                                        break;
                                    case 1:
                                        System.out.println("Barang Berhasil Dimasukkan");
                                        break;
                                    case 2:
                                        System.out.println("Rak yang Dipilih Penuh");
                                        break;
                                    case 3:
                                        System.out.println("Rak Tidak Sesuai dengan Jenis Barang");
                                        break;
                                    case 4:
                                        System.out.println("Rak yang Dipilih Tidak Ditemukan");
                                        break;
                                }
                                break;
                                
                            case 3:
                                System.out.println();
                                System.out.println("MENGELUARKAN BARANG");
                                System.out.print("ID Barang: ");
                                id=sc.nextLine();
                                System.out.print("Letak Barang: ");
                                letak=sc.nextLine();
                                System.out.print("Jumlah Stok: ");
                                stok=sc.nextInt();
                                System.out.println();
                                
                                status=ItemList.barangKeluar(letak, id, stok);
                                
                                switch (status){
                                    case 0:
                                        System.out.println("Barang Tidak Ada didalam Rak");
                                        break;
                                    case 1:
                                        System.out.println("Barang Berhasil Dikeluarkan");
                                        break;
                                    case 2:
                                        System.out.println("Jumlah Barang yang Diambil Melebihi Stok di Rak");
                                        break;
                                    case 3:
                                        System.out.println("Rak yang Dipilih Tidak Ada");
                                        break;
                                    case 4:
                                        System.out.println("Barang Tidak Ada");
                                        break;
                                    case 5:
                                        System.out.println("Jumlah Barang yang Diambil Melebihi Stok");
                                        break;
                                }
                                break;
                            case 4:
                                break proses3;
                        }
                    }
                    break;
                case 2:
                    System.out.println();
                    ItemList.cetakIsiRak();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Transaksi Barang Masuk");
                    ItemList.cetakTransaksiMasuk();
                    System.out.println();
                    
                    System.out.println("Transaksi Barang Keluar");
                    ItemList.cetakTransaksiKeluar();
                    System.out.println();
                    break;
                case 4:
                    break proses2;
            }
        }
        System.out.println("TERIMAKASIH TELAH MENGGUNAKAN SISMa");
    }
}
