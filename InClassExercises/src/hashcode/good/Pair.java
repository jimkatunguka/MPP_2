package hashcode.good;

public class Pair {
	String first;
	String second;
	public Pair(String f, String s) {
		first = f;
		second = s;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
	
	/*public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != this.getClass()) return false;
		Pair p = (Pair)ob;
		return p.first.equals(first) && p.second.equals(second);
	}*/
	
	/*public int hashCode() {
		int result = 17; //seed
		int hashFirst = first.hashCode();
		int hashSecond = second.hashCode();
		result += 31 * result + hashFirst;
		result += 31 * result + hashSecond;
		return result;
		
	}*/
	
	
	
	

}
