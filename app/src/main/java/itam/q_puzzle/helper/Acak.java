package itam.q_puzzle.helper;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by M. ROMADLONI on 20-06-2016.
 */
public class Acak {

    int panjang_bilangan;
    ArrayList<Integer> array_urut = new ArrayList<Integer>();
    ArrayList<Integer> array_acak = new ArrayList<Integer>();
    ArrayList<Integer> array_blok = new ArrayList<Integer>();

    // constructor
    public Acak() {

    }

    public ArrayList<Integer> getAcakBilangan(int panjang_bilangan) {

        array_urut.clear();
        for(int a=1; a<=panjang_bilangan; a++) {
            array_urut.add(a);
        }

        Random rd = new Random();
        int idx;
        int num;
        array_acak.clear();

        for(int b=0; b<panjang_bilangan; b++) {

            idx = rd.nextInt(array_urut.size());
            num = array_urut.get(idx);
            array_urut.remove(idx);
            array_acak.add(num);
        }

        return array_acak;
    }

    public ArrayList<Integer> getAcakBlok(int panjang_bilangan, int num_blank, int max_blank_row) {

        array_acak.clear();
        array_acak = getAcakBilangan(panjang_bilangan);
        int idx_temp;

        for(int a=0; a<panjang_bilangan; a++) {

            idx_temp = array_acak.get(a);
            int num_row = 0;
            boolean isBreak = false;

            for(int b=1; b<=max_blank_row; b++) {

                if(array_blok.contains(idx_temp+b)==true) {
                    num_row = num_row+1;
                }
                else {
                    isBreak = true;
                }

                if(array_blok.contains(idx_temp-b)==true) {
                    num_row = num_row+1;
                }
                else {
                    isBreak = true;
                }

                if(isBreak==true) {
                    break;
                }
            }

            if(num_row<max_blank_row) {
                array_blok.add(idx_temp);
            }

            if(array_blok.size()==num_blank) {
                break;
            }
        }

        return array_blok;
    }

    public ArrayList<Integer> getArrayAcak() {
        return array_acak;
    }
}
