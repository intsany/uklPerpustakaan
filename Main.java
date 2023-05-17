package Perpus;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String back = "";

        boolean stay = true;

        ListBuku listBuku = new ListBuku();
        ListSiswa listSiswa = new ListSiswa();
        ListPetugas listPetugas = new ListPetugas();
        ListPeminjaman listPeminjaman = new ListPeminjaman();

        while (stay){
            System.out.println("\n=======Selamat datang di Perpustakaan=======");
            System.out.println("\n1. Daftar Siswa");
            System.out.println("2. Daftar Petugas Perpustakaan");
            System.out.println("3. Daftar Buku");
            System.out.println("4. Melakukan peminjaman");
            System.out.println("5. Melakukan pengembalian");
            System.out.println("6. Keluar");
            System.out.print("\nPilih menu: ");

            int menu = scan.nextInt();

            switch (menu){
                case 1:
                    System.out.println("=====================\n");
    
                    listSiswa.viewSiswa();
    
                    System.out.println("Press t to b");
    
                    break;

                case 2:
                    System.out.println("======================\n");
    
                    listPetugas.viewPetugas();
                    break;

                case 3:
                    System.out.println("======================\n");
    
                    listBuku.viewBuku();
                    break;
                case 4:
                    System.out.print("Masukkan Id Siswa: ");
    
                    int selectedIdSiswa = scan.nextInt();
                    Siswa selectedSiswa = listSiswa.findSiswa(selectedIdSiswa);
    
                    if (selectedSiswa != null){
    
                        if (selectedSiswa.getStatus() == true){
    
                            System.out.println("Pilih buku yang ingin anda pinjam");
                            listBuku.viewBuku();
    
                            int i = 0;//angka untuk jumlah buku yang dipinjam
                            int harga = 0;
                            String tambahBuku = "y";
    
                            // ArrayList<String> pinjamBuku = new ArrayList<String>();
                            // ArrayList<Integer> priceList = new ArrayList<Integer>();
                            ArrayList<Integer> idBuku = new ArrayList<Integer>();
                            ArrayList<Integer> qtyBuku = new ArrayList<Integer>();
    
                            int qtyTotal = 0;
                            double diskon = 0;
    
                            while (tambahBuku.equalsIgnoreCase("y")){
                                i ++;
    
                                System.out.print("Pilih buku ke - " + i + " : ");
                                int a = scan.nextInt();
    
                                System.out.print("Masukkan jumlah buku: ");
                                int q = scan.nextInt();
    
                                qtyBuku.add(q);
                                qtyTotal += q;
    
                                // pinjamBuku.add(listBuku.getnamabuku(a - 1));
                                // priceList.add(listBuku.getHarga(a - 1));
                                idBuku.add(a - 1);
                                //untuk menyimpan buku - buku yang dipinjam
    
                                harga += listBuku.getHarga(a - 1);
                                listBuku.kurangiStok(a - 1, q);
    
    
                                System.out.println("Apakah anda ingin menambah buku?(y/t)");
                                tambahBuku = scan.next();
                                
            
                            }
    
                            System.out.println("\nTransaksi peminjaman anda sebagai seberikut");
                            System.out.println("\n===========================================");
                            System.out.println("Nama buku \tQty \tHarga \tJumlah \t");
    
                            for (int x = 0; x < i; x++){
                                System.out.println(listBuku.getnamabuku(idBuku.get(x)) + "\t"
                                    + qtyBuku.get(x) + "\t\t"
                                    + listBuku.getHarga(idBuku.get(x)) + "\t"
                                    + qtyBuku.get(x) * listBuku.getHarga(idBuku.get(x)));
                            }
                            
                            System.out.println("Harga: " + harga);
                            if (i >= 5){
                                diskon = harga * 50 / 100;
                                
                                System.out.println("Diskon = " + diskon) ; 
                            }
                            
                            System.out.println("Total harga = " + (harga - diskon));
                            
                            selectedSiswa.setStatus(false);

                            break;
    
                        } else{
                            System.out.println("Anda tidak dapat meminjam buku lagi");
                        } break;


                        
                     }
    
                case 5:
                    System.out.print("Masukkan Id Siswa: ");
    
                    int pilihIdSiswa = scan.nextInt();
                    Siswa pilihSiswa = listSiswa.findSiswa(pilihIdSiswa);

                    if (pilihSiswa != null){
                
                        if (pilihSiswa.getStatus() == false){

                            System.out.println("Pilih buku yang ingin anda kembalikan");
                            listBuku.viewBuku();

                            int i = 0;//angka untuk jumlah buku yang dipinjam
                            int harga = 0;
                            String tambahBuku = "y";

                            // ArrayList<String> pinjamBuku = new ArrayList<String>();
                            // ArrayList<Integer> priceList = new ArrayList<Integer>();
                            ArrayList<Integer> idBuku = new ArrayList<Integer>();
                            ArrayList<Integer> qtyBuku = new ArrayList<Integer>();
                    

                            while (tambahBuku.equalsIgnoreCase("y")){
                                i ++;

                                System.out.print("Pilih buku ke - " + i + " : ");
                                int a = scan.nextInt();

                                System.out.print("Masukkan jumlah buku: ");
                                int q = scan.nextInt();

                                qtyBuku.add(q);

                                // pinjamBuku.add(listBuku.getnamabuku(a - 1));
                                // priceList.add(listBuku.getHarga(a - 1));
                                idBuku.add(a - 1);
                                //untuk menyimpan buku - buku yang dipinjam

                                listBuku.tambahStok(a - 1, q);


                                System.out.println("Apakah anda ingin mengembalikan buku lagi?(y/t)");
                                tambahBuku = scan.next();
                                
            
                            }

                            System.out.println("\nAnda berhasil mengembalikan buku ");


                            for (int x = 0; x < i; x++){
                                System.out.println(listBuku.getnamabuku(idBuku.get(x)) + "\t"
                                    + qtyBuku.get(x) + "\t\t"
                                );
                            }
                            
                            listBuku.viewBuku();

                            pilihSiswa.setStatus(true);;

                            break;

                        } else {
                            System.out.println("Tidak ada buku yang anda pinjam");
                        }

                    }

                case 6:
                    System.out.println("Terima kasih atas kunjungan anda");
                    
                    return;
                
            }
            
        }
    }
}

 //Pilih buku
 // 1

 // apakah anda ingin menambah buku "y/t"
 // t 
// hasilnya

// y
// pilih buku ke-2
// 4

//y
// pilih buku ke - 5
// 3

//y
// anda sudah sampai di batas maksimal


//Selamat datang
// masukkan id anda
// list buku
// masukkan id buku


            


