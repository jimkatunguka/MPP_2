package testQns;

public class IsPrimeHappy {
	
	//isPrime
	static int isPrime(int n) {
		int isPrime = 1;
		int m= n/2;
		
		if(n<=1) isPrime = 0;
		
		for(int i=2; i<m; i++) {
		if(n%m==0) isPrime = 0;
		}
		
		return isPrime;
	}
	
	//isPrimeHappy
	static int isPrimeHappy(int n) {
		int isPrimeHappy = 1;
		int count = 0;
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			if (isPrime(i) == 1) {
				count++;
				sum+=i;
			}
		}
		if(count<1) isPrimeHappy = 0;
		if(sum % n != 0) isPrimeHappy = 0;
		return isPrimeHappy;
	}
	
	//findPorcupineNumber
	public static int findPorcupineNumber(int n)
    {
        int porcupine = -1,nextPrime = -1;
        do
        {
            n++;
            if (porcupine == -1 && isPrime(n) == 1 &&  (n % 10 == 9))
            {
                porcupine = n;
            }

           while (porcupine > -1 && nextPrime == -1) // check for next prime
            {
                n++;
                if (isPrime(n)==1)
                {
                    nextPrime = n;
                    if (nextPrime % 10 != 9)
                    {
                        // reset the porcupine and nextprime 
                        porcupine = -1; nextPrime = -1;
                    }
                }
            }
        }
        while (porcupine == -1 && nextPrime == -1);

        return porcupine;
    }
	
	public static void main(String args[]) {
		System.out.println("spln");
	System.out.println(findPorcupineNumber(0));
	
	}
	

}
