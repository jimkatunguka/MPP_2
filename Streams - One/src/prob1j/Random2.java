package prob1j;

import java.util.function.Supplier;

	public class Random2 {
		public static void main(String[] args) {
			Supplier<Double> supplier2 = (new Random2()).new MyRandom();
			System.out.println(supplier2.get());
		}
		
			class MyRandom implements Supplier<Double>{
				
				@Override
				public Double get() {
					return Math.random();
				}
		}
	}



