package generic;

import java.util.ArrayList;
import java.util.List;

public class Parametrized implements OrderedTripletInterface<List<String>, String, Integer> {
	private List<String> firstKey;
	private String secondKey;
	private Integer lastKey;
	
	public Parametrized(List<String> l, String s, Integer i) {
		this.firstKey = l;
		this.secondKey = s;
		this.lastKey = i;
		this.firstKey = new ArrayList<> ();
	}
	
	@Override
	public List<String> getFirstKey(List<String> firstKey) {
		return this.firstKey;
	}

	@Override
	public String getSecondKey(String s) {
		return secondKey;
	}
	//generic method
	
	
	

}
