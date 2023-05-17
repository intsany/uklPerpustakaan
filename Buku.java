package Perpus;


public class Buku {

    private int idBuku;

    private String namaBuku;
    private int stok;
    private int harga;
    
    
        public Buku(String namaBuku, int stok, int harga, int idBuku) {
            this.namaBuku = namaBuku;
            this.stok = stok;
            this.harga = harga;
            this.idBuku = idBuku;
        }
        
        
        public String getNamaBuku() {
            return namaBuku;
        }
    
        public void setNamaBuku(String namaBuku) {
            this.namaBuku = namaBuku;
        }
    
        public int getStok() {
            return stok;
        }
    
        public void setStok(int stok) {
            this.stok = stok;
        }
    
        public int getHarga() {
            return harga;
        }
    
        public void setHarga(int harga) {
            this.harga = harga;
        }
    
        public int getIdBuku() {
            return idBuku;
        }
    
        public void setIdBuku(int idBuku) {
            this.idBuku = idBuku;
        }
    }
    
    
    
