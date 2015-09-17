package Java;

public class P204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n]; 
        if (n<3) return 0; 
        notPrime[0] = true; notPrime[1] = true; 
        notPrime[2] = false; 
        for (int i=2; i<n; i++){
            if (notPrime[i]) continue; 
            for (int k=i*2; k<n; k+=i) notPrime[k] = true; 
        }
        int num = 0; 
        for (boolean b:notPrime) if (!b) num++; 
        return num; 
    }
}
