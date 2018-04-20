package itam.q_puzzle.model_activity;

/**
 * Created by M. ROMADLONI on 18-06-2016.
 */
public class BlokKosong {

    int id;
    int surat_nomor;
    int level_id;
    int blank;

    // constructors
    public BlokKosong() {

    }

    public BlokKosong(int surat_nomor, int level_id, int blank) {
        this.surat_nomor = surat_nomor;
        this.level_id = level_id;
        this.blank = blank;
    }

    public BlokKosong(int id, int surat_nomor, int level_id, int blank) {
        this.id = id;
        this.surat_nomor = surat_nomor;
        this.level_id = level_id;
        this.blank = blank;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setSuratNomor(int surat_nomor) {
        this.surat_nomor = surat_nomor;
    }

    public void setLevelId(int level_id) {
        this.level_id = level_id;
    }

    public void setBlank(int blank) {
        this.blank = blank;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public int getSuratNomor() {
        return this.surat_nomor;
    }

    public int getLevelId() {
        return this.level_id;
    }

    public int getBlank() {
        return this.blank;
    }
}
