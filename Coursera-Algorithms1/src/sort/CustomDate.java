package sort;

public class CustomDate implements Comparable<CustomDate> {

	
	private int year;
	private int month;
	private int day;
	
	CustomDate(int year,int month,int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	@Override
	public int compareTo(CustomDate that  ) {
		// TODO Auto-generated method stub
		if(this.year > that.year)
			return 1;
		else if(this.year < that.year )
			return -1;
		else if(this.month > that.month)
			return 1;
		else if(this.month < that.month)
			return -1;
		else if(this.day > that.day)
			return 1;
		else if (this.day < that.day)
			return -1;
		return 0;
	}

	public String toString(){
		return day+"/"+month+"/"+year;
	}
}
