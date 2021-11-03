import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-03
 * Time: 오후 10:47
 */

public class Q1477
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[53];
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());
        ary[N+1] = L;

        Arrays.sort(ary, 0, N+2);

        int start = 1;
        int end = L-1;

        while(start <= end)
        {
            int mid = (start + end) / 2;

            int cnt = 0;
            for(int i=1; i<=N+1; i++)
            {
                int dist = ary[i] - ary[i-1];
                if(dist / mid < 1)
                    continue;

                cnt += dist / mid;
                if(dist % mid == 0)
                    cnt--;
            }

            if(cnt > M)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(start);
    }
}
