package itam.q_puzzle.model;

/**
 * Created by Muslim muslim on 4/10/2018.
 */
public class Nilai {

    int id;
    String nama;
    int nilai;
    int waktu;

    public Nilai() {

    }

    public Nilai(String nama, int nilai, int waktu){

        this.nama = nama;
        this.nilai = nilai;
        this.waktu = waktu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }
}
