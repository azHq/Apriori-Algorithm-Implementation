package DataScience2;

import java.util.ArrayList;
import java.util.Random;

public class RandomData {

	public int totalnumOfdata;
	ArrayList<Integer> randomData=new ArrayList<>();
	public RandomData(int totalnumOfdata) {
		
		this.totalnumOfdata=totalnumOfdata;
	}
	
	public ArrayList<Integer> takerandom(){
		
		Random rand=new Random();
		rand.setSeed(3);
		for(int i=0;i<totalnumOfdata;i++){
			
			
			int x=rand.nextInt(totalnumOfdata-1);
			
			while(randomData.contains(x)){
				
				x=rand.nextInt(totalnumOfdata);
			}
			
			randomData.add(x);
		
			
			
		}
		return randomData;
		
	}

}
