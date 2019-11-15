package datascience3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainClass {
	 HashMap<String,Integer> map=new HashMap<String,Integer>();
	 ArrayList<Result> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path="C:\\Users\\ASUS\\Downloads\\Apriori\\data.txt";
		BufferedReader br=new BufferedReader(new FileReader(new File(path)));
		MainClass main=new MainClass();
		main.getData(br);

	}
	
	public void getData(BufferedReader br) throws IOException{
		
		String s=null;
		for(int i=1;i<=5;i++){
			
			String match =null;
			for(int j=1;j<=5;j++){
				
				match="I"+i+",I"+j;
				map.put(match,0);
			}
		}
		
		while((s=br.readLine())!=null){
			
			String[] str=s.split(",");
			for(int i=1;i<str.length;i++){
				String match =null;
				for(int j=i;j<str.length;j++){
					
					
					if(i!=j){
						match=str[i]+","+str[j];
						int count=map.get(match);
						map.put(match,count+1);
						
					}			
						
					
				}
				
				
				
			}
						
		}
		
		
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			  Map.Entry<String, Integer> e= it.next();
			 
			  int Value = e.getValue();
			   if(Value<2) it.remove();                    

		}
				
		HashMap<String,Integer> map3=new HashMap<String,Integer>();
		for(String res:map.keySet()){
			String[] key=res.split(",");
			for(String res2:map.keySet()){
				
				for(int i=0;i<key.length;i++){
					String str=null;
					if(!res2.contains(key[i])&&map.get(res)>=2){
						
						String str2[]=res2.split(",");
						map3.put(str,0);
					}
					
				}
				
				
			}
			
		}
		
		Iterator<Map.Entry<String, Integer>> it2 = map3.entrySet().iterator();
		while(it2.hasNext()) {
			  Map.Entry<String, Integer> e= it2.next();
			 
			  String[] key=e.getKey().split(",");
			  System.out.print(e.getKey()+"->>");
			  A:for(int i=0;i<key.length;i++) {
				  for(int j=i;j<key.length;j++) {
					  
					  if(i!=j) {
						  String subset=key[i]+","+key[j];
						  String subset2=key[j]+","+key[i];
						  boolean flag=false;
						  for(String k:map.keySet()) {
							  
							  if((k.contains(subset)||k.contains(subset2))) {
								  
								  System.out.println("first"+k+" "+subset);
								  flag=true;
							  }
							  
						  }
						  if(!flag) {
							  
							  it2.remove();
							  break A;
						  }
						  System.out.print(subset+"||");
					  }
					  
				  }
			  }
			  
			  System.out.println();
			  
			/*  boolean flag=false;
			  for(String k:map.keySet()) {
				  
				  if(key.contains(k)) {
					  
					  System.out.println("first"+key+" "+k);
					  flag=true;
				  }
				  
			  }
			  
			  if(!flag) it2.remove();*/
			   

		}
		
		
		 for(String k:map3.keySet()) {
			  
			  System.out.println(k);
			  
		  }
		 for(String k:map.keySet()) {
			  
			  System.out.println(k);
			  
		  }
		
	}
	
	

}
