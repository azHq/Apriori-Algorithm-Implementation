package DataScience2;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class SplitDataSet {

	BufferedReader br;
	
	ArrayList<TotalData> listdata=new ArrayList<>();
	public SplitDataSet(BufferedReader br) {
		
		this.br=br;
			
	}
	
	public ArrayList<TotalData> takeData() throws IOException{
		
		String line;
		
		
		
		while((line=br.readLine())!=null){
			
			
			String[] s=line.split(",");
			
			
			
			double[] value=new double[s.length-1];
			String className=s[0];
			for(int i=0;i<s.length-1;i++){
				
				value[i]=Double.parseDouble(s[i+1]);
			}
			
			
			
			TotalData totaldata=new TotalData(className,value);
			listdata.add(totaldata);
			
			
			
		}
		return listdata;
		
	}


}
