import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-09
 * Time: 오후 3:27
 */

public class Q2792
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ary = new int[300001];
        for(int i=0; i<M; i++)
            ary[i] = Integer.parseInt(br.readLine());

        Arrays.sort(ary, 0, M);

        long left = 1;
        long right = 1000000000;
        long ans = 0;
        while(left <= right)
        {
            long mid = (left + right) / 2;

            int cnt = 0;
            for(int i=0; i<M; i++)
                cnt += (ary[i] + mid - 1) / mid;

            if(cnt > N)
                left = mid + 1;
            else
            {
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
