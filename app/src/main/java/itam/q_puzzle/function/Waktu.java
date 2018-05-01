package itam.q_puzzle.function;

/**
 * Created by Muslim muslim on 4/10/2018.
 */
public class Waktu {

    public Waktu() {

    }

    public String getWaktuMenit(int waktuDetik) {

        int menit = waktuDetik/60;
        int detik = waktuDetik%60;
        String waktu = String.format("%02d:%02d", menit, detik);

        return waktu;
    }

    public String getWaktuJam(int waktuDetik) {

        int menit = waktuDetik/60;
        int jam = menit/60;
        menit = menit%60;
        int detik = waktuDetik%60;
        String waktu = String.format("%02d:%02d:%02d", jam, menit, detik);

        return waktu;
    }
}
