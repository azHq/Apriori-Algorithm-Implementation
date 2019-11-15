package DataScience2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class KNN {
	
	
	public ArrayList<TotalData> totalData=new ArrayList<>();
	public ArrayList<Integer> randomData=new ArrayList<>();
	
	public int range;
	public int k_value=4;
	public int totalnumOfdata;
	public int totalFound;
	
	public Distance distance;
	
	public KNN(ArrayList<TotalData> totalData,int totalnumOfdata) {
		
		this.totalData=totalData;
		this.totalnumOfdata=totalnumOfdata;
		distance=new Distance();
		
		
		findTotalMatch() ;
		calculateAccuracy();
		
		
		
	}
	
	public void findTotalMatch() {
		
		RandomData randdom=new RandomData(totalnumOfdata);
		randomData=randdom.takerandom();
		range=(int)(.1*totalnumOfdata);
		
		
		//System.out.println(takeData.size()+","+randomObject.size()+","+totalnumOfdata+","+range);
		
		int index=0;
		
		for(int l=0;l<10;l++){
			
			for(int i=0;i<range;i++){
				
				ArrayList<Result> result=new ArrayList<Result>();
				
				int random=randomData.get(index);
				TotalData testdata=totalData.get(random);
				
				System.out.println(index);
				for(int j=0;j<totalnumOfdata;j++){
					
					if(j!=random){
						
						
						
						System.out.println(j);
						TotalData traindata=totalData.get(j);
						
						double dist=distance.calculateDistance(testdata.value,traindata.value);
						
						Result res=new Result(traindata.className,dist);
						result.add(res);
						
						Collections.sort(result);
						
					}
					else {
						
						TotalData t2=totalData.get(j);
						System.out.println("Simillar"+testdata.className+"\n"+t2.className);
					}
					
					
				}
				
				/*Iterator it=result.iterator();
				int c=0;
				
				while(it.hasNext()) {
					
					Result reslt=(Result)it.next();
					
					
					System.out.println(reslt.value);
					
					
				}*/
				
				matchWithTestData(result,testdata);
				
				index++;
				
				
			}
			
		}
		
		System.out.println(totalFound);
	}
	
	
	public void matchWithTestData(ArrayList<Result> result,TotalData testdata) {
		
		int x=0,y=0,z=0;
		
		for(int k=0;k<k_value;k++){
			
			Result res2=result.get(k);
			
			if(res2.className.equals("M")) {	
				
			
				x++;
				
			}
			else if(res2.className.equals("I")){
				
				
				y++;
			}
			else if(res2.className.equals("F")){
				
				
				z++;
				
			}
			
		}
		
		
		
		if(x>=y&&x>=z){
			
			
			if(testdata.className.equals("M")){
				
				System.out.println(testdata.className);
				totalFound++;
			}
			
			
		}
		else if(y>=x&&y>=z){
			
			
			if(testdata.className.equals("I")){
				
				System.out.println(testdata.className);
				totalFound++;
			}
			
		}
		else if(z>=x&&z>=y){
			
			
			if(testdata.className.equals("F")){
				
				totalFound++;
			}
		}
		
	}
	
	public void calculateAccuracy(){
		
		
		double accuracy=100*(totalFound/(double)totalnumOfdata);
		System.out.println("accuracy:"+accuracy+"%");
		
	}

}
