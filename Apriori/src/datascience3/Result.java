package datascience3;

public class Result {
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	String item;
	int frequency;
	public Result(String item,int frequency){
		
		this.item=item;
		this.frequency=frequency;
		
	}

}
