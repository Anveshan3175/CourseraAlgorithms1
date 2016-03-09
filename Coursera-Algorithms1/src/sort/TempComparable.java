package sort;

public class TempComparable implements Comparable<TempComparable> {
    private final double deg;

    public TempComparable(double deg) {
       this.deg = deg;
    }

    public int compareTo(TempComparable that) {       
       double EPS = 0.1;
       if (this.deg < that.deg - EPS)
          return -1;
       if (this.deg > that.deg + EPS)
          return +1;
       return  0;
    }
   
}