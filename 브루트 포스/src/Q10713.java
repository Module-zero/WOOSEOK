import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 4:15
 */

public class Q10713
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] P = new int[100001];
        for(int i=0; i<M; i++)
            P[i] = Integer.parseInt(st.nextToken());

        long[] ps = new long[100001];
        for(int i=0; i<M-1; i++)
        {
            int min = P[i];
            int max = P[i+1];
            if(min > max)
            {
                int tmp = min;
                min = max;
                max = tmp;
            }

            ps[min]++;
            ps[max]--;
        }

        long ans = 0;
        int[] A = new int[100001];
        int[] B = new int[100001];
        int[] C = new int[100001];
        for(int i=1; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            ps[i] += ps[i-1];
            ans += Long.min(A[i] * ps[i], B[i] * ps[i] + C[i]);
        }

        System.out.println(ans);
    }
}
