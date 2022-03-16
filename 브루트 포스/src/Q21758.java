import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 5:23
 */

public class Q21758
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[100010];
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        int[] left = new int[100010];
        int[] right = new int[100010];
        for(int i=1; i<=N; i++)
        {
            left[i] = left[i-1] + A[i];
            right[N-i+1] = right[N-i+2] + A[N-i+1];
        }

        int ans = 0;
        for(int i=2; i<N; i++)
        {
            // 벌통이 N번 인덱스
            int cur = (left[N] - left[1] - A[i]) + (left[N] - left[i]);
            ans = Integer.max(ans, cur);

            // 벌통이 1번 인덱스
            cur = (right[1] - right[N] - A[i]) + (right[1] - right[i]);
            ans = Integer.max(ans, cur);
        }

        for(int i=2; i<N; i++)
        {
            int cur = (left[i] - left[1]) + (right[i] - right[N]);
            ans = Integer.max(ans, cur);
        }

        System.out.println(ans);
    }
}
