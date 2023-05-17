package Perpus;

import java.util.ArrayList;

public class ListPetugas {

    public ArrayList<Petugas> list;

    //list petugas
    public ListPetugas() {
        list = new ArrayList<Petugas>(); 
        
        list.add(new Petugas("Sabrina", "Banyuwangi", "08637152", 1));//1
        list.add(new Petugas("Bia", "Malang", "08567865", 2));//2
    }
    
    //looping petugas
    public void viewPetugas() {
        System.out.println("\tDaftar Petugas");
        System.out.println("Nama Petugas \tAlamat \tTelepon");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdPetugas()+" "+
                    list.get(i).getNama()+"\t"+
                    list.get(i).getAlamat()+"\t"+
                    list.get(i).getTelepon());
        }
        System.out.println("");  
    }
}
