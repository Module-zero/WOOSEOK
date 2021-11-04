import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-04
 * Time: 오후 7:28
 */

public class Q2824
{
    public static int foo(int a, int b)
    {
        while(b != 0)
        {
            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[1001];
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[1001];
        for(int i=0; i<M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        long ans = 1;
        boolean ok = false;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                int gcd = foo(A[i], B[j]);

                A[i] /= gcd;
                B[j] /= gcd;
                ans *= gcd;
                if(ans >= 1000000000L)
                {
                    ans %= 1000000000L;
                    ok = true;
                }
            }
        }

        if(ok)
            System.out.println(String.format("%09d", ans));
        else
            System.out.println(ans);
    }
}
