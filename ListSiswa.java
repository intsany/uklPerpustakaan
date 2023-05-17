package Perpus;

import java.util.ArrayList;

public class ListSiswa {
    
    public ArrayList<Siswa> list;

    public ListSiswa(){
        list = new ArrayList<Siswa>(); 
        //constructor
        list.add(new Siswa("Olipew", "Malang", "0856782829", true, 1));//1
        list.add(new Siswa("Kecap",   "Samarinda", "086372637", true, 2));//2
        list.add(new Siswa("Laura",    "Yogya", "085362746", true, 3));//3
        list.add(new Siswa("Tatan",    "Malang", "082345677654", true, 4));//4
    }

    //view siswa
    public void viewSiswa() {
        System.out.println("\tDaftar Siswa");
        System.out.println("Nama Siswa \tAlamat \tTelepon \tStatus");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdSiswa() + " "
                    + list.get(i).getNama() + "\t"
                    + list.get(i).getAlamat() + "\t"
                    + list.get(i).getTelepon() + "\t"
                    + list.get(i).getStatus());
        }
    }

    //id siswa
    public Siswa findSiswa(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdSiswa() == id) {
                return list.get(i);
            }
        }
        return null;
    }
    //find siswa
    public String findNamaSiswa(int id) {
        return list.get(id).getNama();
    }
    
    //change siswa
    public void setStatSiswa(int id,boolean stat) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdSiswa() == id) {
                list.get(i).setStatus(stat);
            }
        }
    }
}

