import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-19
 * Time: 오후 2:51
 */

public class sc1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ary = new int[100001];
        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int minId = 0;
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());
            if(min > ary[i])
            {
                min = ary[i];
                minId = i;
            }
        }

        int cnt = 0;
        int left = minId;
        int right = N - left - 1;

        if(left == 0)
            cnt += (right + K - 2) / (K-1);
        else if(right == 0)
            cnt += (left + K - 2) / (K-1);
        else
        {
            cnt = 1;
            int leftId = minId - (left % (K-1));
            left = leftId;
            cnt += (left + K - 2) / (K-1);

            int rightId = K + leftId - 1;
            right = N - rightId - 1;
            cnt += (right + K - 2) / (K-1);
        }

        System.out.println(cnt);
    }
}
