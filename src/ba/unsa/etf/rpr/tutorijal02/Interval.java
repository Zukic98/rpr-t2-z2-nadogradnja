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
        if(t1 > t2)throw new IllegalArgumentException();
        prvaTacka = t1;
        drugaTacka = t2;
        pripadnostPrveTacke = b1;
        pripadnostDrugeTacke = b2;
    }

    boolean isNull(){
        return prvaTacka == 0 && drugaTacka == 0;
    }

    boolean isIn(double x){
        return prvaTacka<x && x<drugaTacka || prvaTacka==x && pripadnostPrveTacke || drugaTacka==x && pripadnostDrugeTacke;
    }

    public Interval intersect(Interval interval){
        if(prvaTacka==interval.prvaTacka && drugaTacka==interval.drugaTacka)return new Interval(prvaTacka,drugaTacka,pripadnostPrveTacke,pripadnostDrugeTacke);
        if(prvaTacka<interval.prvaTacka && drugaTacka> interval.drugaTacka)return new Interval(interval.prvaTacka,interval.drugaTacka,interval.pripadnostPrveTacke,interval.pripadnostDrugeTacke);
        if(prvaTacka>interval.prvaTacka && drugaTacka< interval.drugaTacka)return new Interval(prvaTacka,drugaTacka,pripadnostPrveTacke,pripadnostDrugeTacke);
        if(prvaTacka>interval.prvaTacka && drugaTacka>interval.drugaTacka)return new Interval(prvaTacka, interval.drugaTacka, pripadnostPrveTacke, interval.pripadnostDrugeTacke);
        if(prvaTacka<interval.prvaTacka && drugaTacka<interval.drugaTacka)return new Interval(interval.prvaTacka, drugaTacka, interval.pripadnostPrveTacke, pripadnostDrugeTacke);
        return new Interval(0,0,false,false);
    }

    public static Interval intersect(Interval i1,Interval i2){
        if(i1.prvaTacka==i2.prvaTacka && i1.drugaTacka==i2.drugaTacka)return new Interval(i1.prvaTacka,i1.drugaTacka,i1.pripadnostPrveTacke,i1.pripadnostDrugeTacke);
        if(i1.prvaTacka<i2.prvaTacka && i1.drugaTacka> i2.drugaTacka)return new Interval(i2.prvaTacka,i2.drugaTacka,i2.pripadnostPrveTacke,i2.pripadnostDrugeTacke);
        if(i1.prvaTacka>i2.prvaTacka && i1.drugaTacka< i2.drugaTacka)return new Interval(i1.prvaTacka,i1.drugaTacka,i1.pripadnostPrveTacke,i1.pripadnostDrugeTacke);
        if(i1.prvaTacka>i2.prvaTacka && i1.drugaTacka>i2.drugaTacka)return new Interval(i1.prvaTacka, i2.drugaTacka, i1.pripadnostPrveTacke, i2.pripadnostDrugeTacke);
        if(i1.prvaTacka<i2.prvaTacka && i1.drugaTacka<i2.drugaTacka)return new Interval(i2.prvaTacka, i1.drugaTacka, i2.pripadnostPrveTacke, i1.pripadnostDrugeTacke);
        return new Interval(0,0,false,false);
    }

    @Override
    public String toString() {
        if(prvaTacka==drugaTacka && pripadnostPrveTacke==pripadnostDrugeTacke)return "()";
        String str="";
        if(pripadnostPrveTacke) str=str+ "[" + prvaTacka;
        else str = "(" + prvaTacka;
        str = str + "," + drugaTacka;
        if(pripadnostDrugeTacke) str= str + "]";
        else str = str +")";
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        Interval i=(Interval)obj;
        return prvaTacka==i.prvaTacka && drugaTacka== i.drugaTacka && pripadnostPrveTacke== i.pripadnostPrveTacke && pripadnostDrugeTacke==i.pripadnostDrugeTacke;
    }
}
