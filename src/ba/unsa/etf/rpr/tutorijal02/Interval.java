package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double prvaTacka,drugaTacka;
    private boolean pripadnostPrveTacke,pripadnostDrugeTacke;

    Interval(){
        prvaTacka = 0;
        drugaTacka = 0;
        pripadnostPrveTacke = false;
        pripadnostDrugeTacke = false;
    }
    Interval(double t1,double t2,boolean b1,boolean b2){
        if(t1 > t2)throw IllegalArgumentException();
        prvaTacka = t1;
        drugaTacka = t2;
        pripadnostPrveTacke = b1;
        pripadnostDrugeTacke = b2;
    }

    @Override
    boolean isNull(){
        return prvaTacka == 0 && drugaTacka == 0;
    }
}
