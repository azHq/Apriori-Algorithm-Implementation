package DataScience2;


public class Result implements Comparable {

	
	public String className;
	public double value;
	public Result(String className,double value) {
	
		this.className=className;
		this.value=value;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int compareTo(Object obj) {
		
		double distance1=this.value;
		Result df=(Result)obj;
		double distance2=df.value;
		 if(distance1<distance2)
			 return -1;
		 else if(distance1>distance2)
			 return 1;
		 else
			 return -1;
		
		
	}

}
