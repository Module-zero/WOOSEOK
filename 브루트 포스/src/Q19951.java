import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-28
 * Time: 오후 4:28
 */

public class Q19951
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] H = new int[100001];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            H[i] = Integer.parseInt(st.nextToken());

        int[] ary = new int[100002];
        int[] sum = new int[100002];
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ary[a] += k;
            ary[b+1] += -k;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++)
        {
            sum[i] = sum[i - 1] + ary[i];
            sb.append(sum[i] + H[i]).append(' ');
        }

        System.out.println(sb.toString());
    }
}
