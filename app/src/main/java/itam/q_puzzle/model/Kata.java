package itam.q_puzzle.model;

/**
 * Created by M. ROMADLONI on 18-06-2016.
 */
public class Kata {

    int id;
    int surat_nomor;
    int ayat;
    int kata;
    String src;
    int nomor;

    // constructors
    public Kata() {

    }

    public Kata(int surat_nomor, int ayat, int kata, String src, int nomor) {
        this.surat_nomor = surat_nomor;
        this.ayat = ayat;
        this.kata = kata;
        this.src = src;
        this.nomor = nomor;
    }

    public Kata(int id, int surat_nomor, int ayat, int kata, String src, int nomor) {
        this.id = id;
        this.surat_nomor = surat_nomor;
        this.ayat = ayat;
        this.kata = kata;
        this.src = src;
        this.nomor = nomor;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSuratNomor(int surat_nomor) {
        this.surat_nomor = surat_nomor;
    }

    public void setAyat(int ayat) {
        this.ayat = ayat;
    }

    public void setKata(int kata) {
        this.kata = kata;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    // getters
    public int getId() {
        return  this.id;
    }

    public int getSuratNomor() {
        return this.surat_nomor;
    }

    public int getAyat() {
        return this.ayat;
    }

    public int getKata() {
        return  this.kata;
    }

    public String getSrc() {
        return this.src;
    }

    public int getNomor() {
        return  this.nomor;
    }
}
