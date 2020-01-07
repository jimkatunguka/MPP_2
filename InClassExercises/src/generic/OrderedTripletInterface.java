package generic;

public interface OrderedTripletInterface <R, S, T>{
	
	R getFirstKey(R r);
	S getSecondKey(S s);
	
	default T getLastKey(T t) {
		return t;
	}

}
