package itam.q_puzzle.model;

/**
 * Created by Muslim muslim on 4/10/2018.
 */
public class Surat {

    int nomor;
    String nama;
    int ayat;
    int kata;
    int puzzle;

    // constructors
    public Surat() {

    }

    public Surat(int nomor, String nama, int ayat, int kata, int puzzle) {
        this.nomor = nomor;
        this.nama = nama;
        this.ayat = ayat;
        this.kata = kata;
        this.puzzle = puzzle;
    }

    // setters
    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAyat(int ayat) {
        this.ayat = ayat;
    }

    public void setKata(int kata) {
        this.kata = kata;
    }

    public void setPuzzle(int puzzle) {
        this.puzzle = puzzle;
    }

    // getters
    public int getNomor() {
        return  this.nomor;
    }

    public String getNama() {
        return this.nama;
    }

    public int getAyat() {
        return this.ayat = ayat;
    }

    public int getKata() {
        return this.kata = kata;
    }

    public int getPuzzle() {
        return this.puzzle = puzzle;
    }
}
