package apriori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainClass {
	 HashMap<String,Integer> map=new HashMap<String,Integer>();
	 HashMap<String,Integer> map2=new HashMap<String,Integer>();
	 ArrayList<String> list=new ArrayList<String>();
	 ArrayList<String> list2=new ArrayList<String>();
	 int numberOfitem=5;
	 static int length=3;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path="C:\\\\Users\\\\ASUS\\\\Downloads\\\\Apriori\\\\data.txt";
		BufferedReader br=new BufferedReader(new FileReader(new File(path)));
		MainClass main=new MainClass();
		main.getData(br);
		main.getItemSubSet(5);
		main.caculateC1();
		for(int i=1;i<length;i++) {
			
			main.calculateFrequancy();
		}
		
//		main.caculateC2();
//		main.caculateC3();
		
		

	}
	
	
	public void getData(BufferedReader br)throws IOException{
		String s=null;
		while((s=br.readLine())!=null){
			
			String[] str=s.split(",");
			String[] str2=new String[str.length-1];
			for(int i=1;i<str.length;i++){	
				str2[i-1]=str[i];
				
			}
			
			
			getSubSet(str2);
			 
			
		}
		
		
	}
	
	public void getItemSubSet(int numOfItem){
		
		String[] str=new String[numOfItem];
		for(int i=1;i<=numOfItem;i++){
			
			str[i-1]="I"+i;
		}
		for (int i = 0; i < (1<<str.length); i++) 
        { 
			
			String subset="{";
            for (int j = 0; j < str.length; j++) {
  
                
                if ((i & (1 << j)) > 0&&subset.length()>2) subset=subset+","+str[j];
                else if((i & (1 << j)) > 0) subset=subset+str[j];
            }
                
                
                subset+="}";
               list2.add(subset);
           
        } 
		
				
		
	}
	
	public void getSubSet(String[] str){
		
		for (int i = 0; i < (1<<str.length); i++) 
        { 
			
			String subset="{";
            for (int j = 0; j < str.length; j++) {
  
                
            	 if ((i & (1 << j)) > 0&&subset.length()>2) subset=subset+","+str[j];
                 else if((i & (1 << j)) > 0) subset=subset+str[j];
            }
                
                subset+="}";
               list.add(subset);
           
        } 
		
				
		
	}
	
	public  <T> Set<T> mergeSet(Set<T> a, Set<T> b) 
    { 
  
        // Creating an empty set 
        Set<T> mergedSet = new HashSet<T>(); 
  
        // add the two sets to be merged 
        // into the new set 
        mergedSet.addAll(a); 
        mergedSet.addAll(b); 
  
        // returning the merged set 
        return mergedSet; 
    } 
	
	public void caculateC1() throws IOException{
		
		for(int i=1;i<=numberOfitem;i++) {
			
			String s="{I"+i+"}";
			map.put(s,0);
		}
		
		
		
	}
	
	public void calculateFrequancy() {
		
		for(String s:map.keySet()) {
			
			for(String s2:list) {
				
				if(s2.contains(s)) {
					
					int count=map.get(s)+1;
					map.put(s,count);
				}
			}
		}
		minimumCountCheck();
		for(String k:map.keySet()) {
			
			// System.out.println(k+"->"+map.get(k));
			
		}
		setJoin();
	}
	
	public void setJoin() {
		
		for(String s:map.keySet()){
			for(String s2:map.keySet()){
				
				if(!s2.contains(s)){
						
					System.out.println(s+"--"+s2);
						s=s.replace("{","");
						s=s.replace("}","");
						s2=s2.replace("{","");
						s2=s2.replace("}","");
					 	Set<String> set = new HashSet<String>(); 
					 	set.addAll(Arrays.asList(s.split(",")));
					 	set.addAll(Arrays.asList(s2.split(",")));
				        String str="{";
				        for(String str2:set) {
				        	
				        	if(str.length()>2) str=str+","+str2;
				        	else str=str+str2;
				        	
				        }
				        str=str+"}";
				        System.out.println(str);
				        map2.put(str,0);       
				     
				}
			}
				
			
			
		
		}
		
		for(String k:map2.keySet()) {
			  
			   System.out.println(k+"->"+map2.get(k));
			  
		 }
		
		map=map2;
		map2=new HashMap<String,Integer>();
		
	}
	
	public void minimumCountCheck() {
		
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			  Map.Entry<String, Integer> e= it.next();
			 
			  int Value = e.getValue();
			   if(Value<2) it.remove();                    

		}
				
	}
	
	public void caculateC2(){
		
		
		for(String s:list2){
			
			if(s.length()==7){
				for(String s2:list){
					
					if(s2.contains(s)){
						if(map.get(s)==null){
							map.put(s,1);
						}
						else{
							
							int count=map.get(s)+1;
							map.put(s,count);
						}
					}
				}
					
					
				
			}
		}
		
		for(String k:map.keySet()) {
			  
			  //System.out.println(k+"->"+map.get(k));
			  
		 }
		
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			  Map.Entry<String, Integer> e= it.next();
			 
			  int Value = e.getValue();
			   if(Value<2||e.getKey().length()<7) it.remove();                    

		}
				
		
	
	}
	public void caculateC3(){
		
		for(String s:map.keySet()){
				for(String s2:map.keySet()){
					
					if(!s2.contains(s)){	
							s=s.replace("{","");
							s=s.replace("}","");
							s2=s2.replace("{","");
							s2=s2.replace("}","");
						 	Set<String> a = new HashSet<String>(); 
					        a.addAll(Arrays.asList(s.split(",")));
					        a.addAll(Arrays.asList(s2.split(",")));
					        map2.put(a.toString(),0);       
					     
					}
				}
					
					
				
			
		}
		
		for(String k:map2.keySet()) {
			  
			   System.out.println(k+"->"+map2.get(k));
			  
		 }
		
		/*Iterator<Map.Entry<String, Integer>> it2 = map3.entrySet().iterator();
		while(it2.hasNext()) {
			  Map.Entry<String, Integer> e= it2.next();
			 
			  String[] key=e.getKey().split(",");
			  //System.out.print(e.getKey()+"->>");
			  A:for(int i=0;i<key.length;i++) {
				  for(int j=i;j<key.length;j++) {
					  
					  if(i!=j) {
						  String subset=key[i]+","+key[j];
						  String subset2=key[j]+","+key[i];
						  boolean flag=false;
						  for(String k:map.keySet()) {
							  
							  if((k.contains(subset)||k.contains(subset2))) {
								  
								 // System.out.println("first"+k+" "+subset);
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
			  
			
			   

		}
		
		
		 for(String k:map3.keySet()) {
			 int count=0;
			  for(String s:list){
				  if(s.contains(k)) count++;
			  }
			  map3.put(k,count);
			  System.out.println(k+"->>"+map3.get(k));
			  
		  }
		 for(String k:map.keySet()) {
			  
			  System.out.println(k);
			  
		  }*/
		
		
	}
	
	public  int stringCompare(String str1, String str2) 
    { 
  
        
  
        int str1_ch = (int)str1.charAt(1); 
        int str2_ch = (int)str2.charAt(1); 

        if (str1_ch>str2_ch) { 
           return 1;
        } 
        else if(str1_ch<str2_ch) { 
            return -1; 
        } 
           
        return 0;
	
    }
	public String getSubSet(String[] input, int index) {
		  // Should check that index >=0 and < 2^input.length here.
		  // Should also check that input.length <= 31.
		  String returnValue = "";
		  for (int i = 0; i < input.length; i++){
		    if ((i & (1 << i)) != 0) // 1 << i is the equivalent of 2^i
		      returnValue += input[i];
		  }
		  return returnValue;
		  
	}

	
	

}
