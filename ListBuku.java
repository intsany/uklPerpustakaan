package Perpus;

import java.util.ArrayList;

public class ListBuku {
    public ArrayList<Buku> list;
    private int stokdefault = 10;

    public ListBuku() {
        //listbuku
        list = new ArrayList<Buku>();

        list.add(new Buku("Harry Potter", stokdefault, 10000, 1));
        list.add(new Buku("Narnia", stokdefault, 8000, 2));
        list.add(new Buku("Madilog", stokdefault, 90000, 3));
        list.add(new Buku("Sherlock", stokdefault, 15000, 4));
        list.add(new Buku("Bumi manusia", stokdefault, 8000, 5));
    }

    public void viewBuku() {
        System.out.println("\tDaftar Buku");
        System.out.println("Judul Buku \t\tHarga Buku \tStok Buku");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getIdBuku() + " "
                    + list.get(i).getNamaBuku() + "\t\t"
                    + list.get(i).getHarga() + "\t\t"
                    + list.get(i).getStok());
        }
    }

    //Mencari buku if(buku==true){jalan}
    public Buku findBuku(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIdBuku() == id) {
                return list.get(i);
            }
        }
        return null;
    }

    //Mengurangi stok 
    public void kurangiStok(int id, int jmlbuku) {
    
                int currentStok = list.get(id).getStok();
                list.get(id).setStok(currentStok - jmlbuku);
            }


    //menambahstokbuku
    public void tambahStok(int id, int buku) {
    
                int currentStok = list.get(id).getStok();
                list.get(id).setStok(currentStok + buku);
            }
        
    

    //mengambil default tstok
    public int getdefstok() {
        return this.stokdefault;
    }

    //Mencari nama buku berdsrkan ID
    public String getnamabuku(int id) {
        return list.get(id).getNamaBuku();
    }

    //Mintastokbuku
    public int getstok(int id) {
        return list.get(id - 1).getStok();
    }

    public int getHarga(int id){
        return list.get(id).getHarga();
    }

}

