import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-10
 * Time: 오전 12:08
 */

public class Q1421
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] ary = new int[51];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            ary[i] = Integer.parseInt(st.nextToken());
            if(ary[i] > max)
                max = ary[i];
        }

        long ans = 0;
        for(int i=1; i<=max; i++)
        {
            long sum = 0;
            for(int j=0; j<N; j++)
            {
                if(ary[j] < i)
                    continue;

                int c = ary[j]/i;
                int cnt = c;

                if(ary[j] % i == 0)
                    cnt--;

                long tmp = c * i * W - cnt * C;
                if(tmp > 0)
                    sum += tmp;
            }

            if(sum > ans)
                ans = sum;
        }

        System.out.println(ans);
    }
}
