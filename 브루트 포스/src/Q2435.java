import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 11:26
 */

public class Q2435
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ary = new int[101];
        int[] sum = new int[101];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++)
        {
            if(i >= K)
            {
                sum[i] = sum[i - 1] + ary[i] - ary[i - K];
                max = Integer.max(max, sum[i]);
            }
            else
                sum[i] = ary[i] + sum[i-1];
        }

        System.out.println(max);
    }
}
