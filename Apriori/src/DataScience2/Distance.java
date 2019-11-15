package DataScience2;

public class Distance {
	
	public Distance() {
		
	}
	
	public double calculateDistance(double[] value1,double[] valu2){
		
		double sum=0.0;
		for(int i=0;i<value1.length;i++){
			
			sum+=Math.pow(value1[i]-valu2[i],2);
		
		}
		
		return Math.sqrt(sum);
		
	}

}
