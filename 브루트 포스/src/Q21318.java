import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-29
 * Time: 오후 10:09
 */

public class Q21318
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] sum = new int[100001];
        for(int i=1; i<=N; i++)
        {
            sum[i] = sum[i-1];
            if(i == N)
                continue;

            if(ary[i] > ary[i+1])
                sum[i]++;
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<Q; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(sum[y-1] - sum[x-1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
