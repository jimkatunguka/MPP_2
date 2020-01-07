package prob3;

public interface Cache {
	//shouldn't be static
	default long timeout() {
		//seconds
		return 1;
	}
}
