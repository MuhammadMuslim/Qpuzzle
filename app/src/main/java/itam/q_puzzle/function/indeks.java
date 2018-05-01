package itam.q_puzzle.function;

/**
 * Created by Muslim muslim on 4/10/2018.
 */
public class indeks {

    double waktu;
    double kesalahan;
    double bantuan;
    double r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    double r11, r12, r13, r14, r15, r16, r17, r18, r19, r20;
    double r21, r22, r23, r24, r25, r26, r27;
    int z1, z2, z3, z4, z5, z6, z7, z8, z9, z10;
    int z11, z12, z13, z14, z15, z16, z17, z18, z19, z20;
    int z21, z22, z23, z24, z25, z26, z27;
    double rizi, ri;
    double z;
    int level;
    double a;
    double waktuCepat;
    double waktuNormal;
    double waktuLambat;
    double b;
    double kesalahanRendah;
    double kesalahanSedang;
    double kesalahanTinggi;
    double c;
    double bantuanRendah;
    double bantuanSedang;
    double bantuanTinggi;

    public double getZ() {
        return  this.z;
    }

public int getLevel(double waktu, double kesalahan, double bantuan) {
    this.waktu = waktu;
    this.kesalahan = kesalahan;
    this.bantuan = bantuan;

    waktuCepat = getWaktuCepat(this.waktu);
    waktuNormal = getWaktuNormal(this.waktu);
    waktuLambat = getWaktuLambat(this.waktu);

    kesalahanRendah = getKesalahanRendah(this.kesalahan);
    kesalahanSedang = getKesalahanSedang(this.kesalahan);
    kesalahanTinggi = getKesalahanTinggi(this.kesalahan);

    bantuanRendah = getBantuanRendah(this.bantuan);
    bantuanSedang = getBantuanSedang(this.bantuan);
    bantuanTinggi = getBantuanTinggi(this.bantuan);

    r1 = Math.min(waktuCepat, Math.min(kesalahanRendah, bantuanRendah));
    z1 = 3;

    r2 = Math.min(waktuCepat, Math.min(kesalahanRendah, bantuanSedang));
    z2 = 2;

    r3 = Math.min(waktuCepat, Math.min(kesalahanRendah, bantuanTinggi));
    z3 = 1;

    r4 = Math.min(waktuCepat, Math.min(kesalahanSedang, bantuanRendah));
    z4 = 2;

    r5 = Math.min(waktuCepat, Math.min(kesalahanSedang, bantuanSedang));
    z5 = 2;

    r6 = Math.min(waktuCepat, Math.min(kesalahanSedang, bantuanTinggi));
    z6 = 1;

    r7 = Math.min(waktuCepat, Math.min(kesalahanTinggi, bantuanRendah));
    z7 = 1;

    r8 = Math.min(waktuCepat, Math.min(kesalahanTinggi, bantuanSedang));
    z8 = 1;

    r9 = Math.min(waktuCepat, Math.min(kesalahanTinggi, bantuanTinggi));
    z9 = 1;

    r10 = Math.min(waktuNormal, Math.min(kesalahanRendah, bantuanRendah));
    z10 = 2;

    r11 = Math.min(waktuNormal, Math.min(kesalahanRendah, bantuanSedang));
    z11 = 2;

    r12 = Math.min(waktuNormal, Math.min(kesalahanRendah, bantuanTinggi));
    z12 = 1;

    r13 = Math.min(waktuNormal, Math.min(kesalahanSedang, bantuanRendah));
    z13 = 2;

    r14 = Math.min(waktuNormal, Math.min(kesalahanSedang, bantuanSedang));
    z14 = 2;

    r15 = Math.min(waktuNormal, Math.min(kesalahanSedang, bantuanTinggi));
    z15 = 1;

    r16 = Math.min(waktuNormal, Math.min(kesalahanTinggi, bantuanRendah));
    z16 = 1;

    r17 = Math.min(waktuNormal, Math.min(kesalahanTinggi, bantuanSedang));
    z17 = 1;

    r18 = Math.min(waktuNormal, Math.min(kesalahanTinggi, bantuanTinggi));
    z18 = 1;

    r19 = Math.min(waktuLambat, Math.min(kesalahanRendah, bantuanRendah));
    z19 = 1;

    r20 = Math.min(waktuLambat, Math.min(kesalahanRendah, bantuanSedang));
    z20 = 1;

    r21 = Math.min(waktuLambat, Math.min(kesalahanRendah, bantuanTinggi));
    z21 = 1;

    r22 = Math.min(waktuLambat, Math.min(kesalahanSedang, bantuanRendah));
    z22 = 1;

    r23 = Math.min(waktuLambat, Math.min(kesalahanSedang, bantuanSedang));
    z23 = 1;

    r24 = Math.min(waktuLambat, Math.min(kesalahanSedang, bantuanTinggi));
    z24 = 1;

    r25 = Math.min(waktuLambat, Math.min(kesalahanTinggi, bantuanRendah));
    z25 = 1;

    r26 = Math.min(waktuLambat, Math.min(kesalahanTinggi, bantuanSedang));
    z26 = 1;

    r27 = Math.min(waktuLambat, Math.min(kesalahanTinggi, bantuanTinggi));
    z27 = 1;

    rizi = (r1*z1)+(r2*z2)+(r3*z3)+(r4*z4)+(r5*z5)+(r6*z6)+(r7*z7)+(r8*z8)+(r9*z9)+(r10*z10)+
            (r11*z11)+(r12*z12)+(r13*z13)+(r14*z14)+(r15*z15)+(r16*z16)+(r17*z17)+(r18*z18)+(r19*z19)+(r20*z20)+
            (r21*z21)+(r22*z22)+(r23*z23)+(r24*z24)+(r25*z25)+(r26*z26)+(r27*z27);
    ri = r1+r2+r3+r4+r5+r6+r7+r8+r9+r10+r11+r12+r13+r14+r15+r16+r17+r18+r19+r20+r21+r22+r23+r24+r25+r26+r27;

    z = rizi/ri;

    this.level = (int) Math.round(z);

    return this.level;
}

public double getWaktuCepat(double waktu) {

    a = waktu;

    if(a<=1.5) {

        waktuCepat = 1;
    }
    else if(a>1.5 && a<4.5) {

        waktuCepat = (4.5-a)/(4.5-1.5);
    }
    else if(a>=4.5) {

        waktuCepat = 0;
    }

    return waktuCepat;
}

public double getWaktuNormal(double waktu) {

    a = waktu;

    if(a<=3 || a>=6) {

        waktuNormal = 0;
    }
    else if(a>3 && a<=4.5) {

        waktuNormal = (a-3)/(4.5-3);
    }
    else if(a>4.5 && a<6) {

        waktuNormal = (6-a)/(6-4.5);
    }

    return waktuNormal;
}

public double getWaktuLambat(double waktu) {

    a = waktu;

    if(a<=4.5) {

        waktuLambat = 0;
    }
    else if(a>4.5 && a<7.5) {

        waktuLambat = (a-4.5)/(7.5-4.5);
    }
    else if(a>=7.5) {

        waktuLambat = 1;
    }

    return waktuLambat;
}

public double getKesalahanRendah(double kesalahan) {

    b = kesalahan;

    if(b>=0 && b<0.2) {

        kesalahanRendah = (0.2-b)/(0.2-0);
    }
    else if(b>=0.2) {

        kesalahanRendah = 0;
    }

    return kesalahanRendah;
}

public double getKesalahanSedang(double kesalahan) {

    b = kesalahan;

    if(b<=0.1 || b>=0.3) {

        kesalahanSedang = 0;
    }
    else if(b>0.1 && b<=0.2) {

        kesalahanSedang = (b-0.1)/(0.2-0.1);
    }
    else if(b>0.2 && b<0.3) {

        kesalahanSedang = (0.3-b)/(0.3-0.2);
    }

    return kesalahanSedang;
}

public double getKesalahanTinggi(double kesalahan) {

    b = kesalahan;

    if(b<=0.2) {

        kesalahanTinggi = 0;
    }
    else if(b>0.2 && b<0.4) {

        kesalahanTinggi = (b-0.2)/(0.4-0.2);
    }
    else if(b>=0.4) {

        kesalahanTinggi = 1;
    }

    return kesalahanTinggi;
}

public double getBantuanRendah(double bantuan) {

    c = bantuan;

    if(c>=0 && c<0.2) {

        bantuanRendah = (0.2-c)/(0.2-0);
    }
    else if(c>=0.2) {

        bantuanRendah = 0;
    }

    return bantuanRendah;
}

public double getBantuanSedang(double bantuan) {

    c = bantuan;

    if(c<=0.1 || c>=0.3) {

        bantuanSedang = 0;
    }
    else if(c>0.1 && c<=0.2) {

        bantuanSedang = (c-0.1)/(0.2-0.1);
    }
    else if(c>0.2 && c<0.3) {

        bantuanSedang = (0.3-c)/(0.3-0.2);
    }

    return bantuanSedang;
}

public double getBantuanTinggi(double bantuan) {

    c = bantuan;

    if(c<=0.2) {

        bantuanTinggi = 0;
    }
    else if(c>0.2 && c<0.4) {

        bantuanTinggi = (c-0.2)/(0.4-0.2);
    }
    else if(c>=0.4) {

        bantuanTinggi = 1;
    }

    return bantuanTinggi;
}
}
