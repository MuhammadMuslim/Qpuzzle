package itam.q_puzzle.model_activity;

/**
 * Created by M. ROMADLONI on 18-06-2016.
 */
public class Level {

    int id;
    String nama;
    int max_row;

    // constructors
    public Level() {

    }

    public Level(String nama, int max_row) {
        this.nama = nama;
        this.max_row = max_row;
    }

    public Level(int id, String nama, int max_row) {
        this.id = id;
        this.nama = nama;
        this.max_row = max_row;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setMaxRow(int max_row) {
        this.max_row = max_row;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getNama() {
        return this.nama;
    }

    public int getMaxRow() {
        return this.max_row;
    }
}
