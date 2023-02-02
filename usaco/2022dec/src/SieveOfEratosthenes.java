import java.util.ArrayList;

class SieveOfEratosthenes
{
    void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        ArrayList<Integer> p = new ArrayList<>();
        // Print all prime numbers
        for(int i = 1; i <= n; i++)
        {
            if(prime[i]) p.add(i);

        }
        System.out.println(p);
    }

    // Driver Program to test above function
    public static void main(String args[])
    {
        int n = 5 * 100000;
        SieveOfEratosthenes g = new SieveOfEratosthenes();
        g.sieveOfEratosthenes(n);
    }
}