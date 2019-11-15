package DataScience2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainClass {
	
	
	public int totalnumOfdata;
	ArrayList<TotalData> totalData=new ArrayList<>();
	ArrayList<Integer> randomObject=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		
		MainClass mainclass=new MainClass();
		mainclass.loadDataSet();
		
		
		
		
	}
	
	public void loadDataSet() throws IOException {
		

		FileReader fr=new FileReader(new File("train.txt"));
		BufferedReader br1=new BufferedReader(fr);
		
		SplitDataSet split=new SplitDataSet(br1);
		totalData=split.takeData();
		totalnumOfdata=totalData.size();
		
		KNN knn=new KNN(totalData,totalnumOfdata);
		
	
	
//		mainclass.takerandom();
//		System.out.println(mainclass.totalnumOfdata);
//		DistanceCalculate dist=new DistanceCalculate(mainclass.totalnumOfdata,mainclass.randomObject,mainclass.listdata);
		
	}
	
	
	
	public static void print(String s){
		
		System.out.println(s);
	}
	
	public static void print(int a){
		
		System.out.println(a);
	}
	
	public void takerandom(){
		
		Random rand=new Random();
		rand.setSeed(3);
		for(int i=0;i<totalnumOfdata;i++){
			
			
			int x=rand.nextInt(totalnumOfdata-1);
			
			while(randomObject.contains(x)){
				
				x=rand.nextInt(totalnumOfdata);
			}
			
			randomObject.add(x);
		
			
			
		}
		
	}
	

}

