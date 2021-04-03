import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 8:20
 */

public class test3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] S = new int[1000001];
        for(int i=1; i<=N; i++)
            S[i] = Integer.parseInt(st.nextToken());

        int[] ps = new int[1000001];
        for(int i=1; i<=N; i++)
            ps[i] = ps[i-1] + S[i];

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int sum = ps[end] - ps[start-1];
            int num = end - start + 1;

            double ans = (double)sum / num;
            sb.append(String.format("%.2f\n", ans));
        }

        System.out.print(sb.toString());
    }
}
