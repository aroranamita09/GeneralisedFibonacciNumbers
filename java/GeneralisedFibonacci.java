package  com.stackroute;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneralisedFibonacci{
   void checkItout(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] vals = br.readLine().split(" ");
            int a = Integer.parseInt(vals[0]);
            int b = Integer.parseInt(vals[1]);
            int c = Integer.parseInt(vals[2]);
            int n = Integer.parseInt(vals[3]);
            int m = Integer.parseInt(vals[4]);

            long[][] transition = new long[3][3];
            transition[0][1] = b;
            transition[1][0] = 1;
            transition[1][1] = a;
            transition[2][1] = 1;
            transition[2][2] = 1;

            long[] state = new long[] { 1, 1, c };

            transition = matPow(transition, n - 1, m);
            state = prod(state, transition, m);
            System.out.println(state[0]);
        }
    }

    long[][] matPow(long[][] m1, long powl, long mod) {
        long[][] res = null;
        while (powl > 0) {
            if ((powl & 1) > 0) {
                if (res == null) {
                    res = m1;
                }
                else {
                    res = prod(res, m1, mod);
                }
            }
            powl >>= 1;
            if (powl > 0) {
                m1 = prod(m1, m1, mod);
            }
        }
        return res;
    }

    //n3
    long[][] prod(long[][] m1, long[][] m2, long mod) {
        long[][] res = new long[m1.length][];
        for (int i = 0; i < m1.length; i++) {
            res[i] = prod(m1[i], m2, mod);
        }
        return res;
    }

    //n2
     long[] prod(long[] v, long[][] m, long mod) {
        long[] res = new long[v.length];
        for (int i = 0; i < v.length; i++) {
            long temp = 0;
            for (int k = 0; k < v.length; k++) {
                temp = (temp + ((v[k] * m[k][i]) % mod)) % mod;
            }
            res[i] = temp;
        }
        return res;
    }
}
