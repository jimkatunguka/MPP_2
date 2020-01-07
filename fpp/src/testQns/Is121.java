package testQns;

public class Is121 {
	public static int is121Array(int[] a)
    {
        int is121 = 1;
        int firstones = 0, lastones=0, twos = 0;
        int prev = 0;
        int changecount = 0;
        
        int firstelement = a[0];
        if (firstelement != 1) is121 = 0;
        
        for (int i = 0; i < a.length && is121==1; i++)
        {
            if (a[i] == 2) twos++;
            if (prev != a[i]) changecount++;
            if(changecount ==1) if (a[i] == 1) firstones++;
            if(changecount == 3) if (a[i] == 1) lastones++;
            if (changecount > 3) is121 = 0;

            prev = a[i];
        }
        if (twos < 1) is121 = 0;
        if (firstones != lastones) is121 = 0;
        return is121;
    }

	public static void main(String[]args) {
		int[]a = {1,1,2,2,2,1,1,1};
		int[]b = {1,1,2,2,2,1,1};
		System.out.println(is121Array(b));
	}

}
