package testQns;

public class GetExponent {
	public static int getExponent(int n, int p)
    {
        if (p <= 1) return -1;
        boolean isok = false;
        int x = 0;
      double temp = n;
        do
        {

            temp = temp / p;
            isok=(temp % 1 == 0);
            if (isok)
            {
                x++;
            }

        } while (isok);

        return x;
    }
	
	public static void main(String[]args) {
		System.out.println(getExponent(18, 1));
	}

}
