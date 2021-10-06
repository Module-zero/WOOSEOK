import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-07-14
 * Time: 오후 6:43
 */

public class Q15662
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] strs = new String[1001];

        for(int i=0; i<T; i++)
            strs[i] = br.readLine();

        int K = Integer.parseInt(br.readLine());
        // 12시방향의 위치
        int[] top = new int[1001];
        int[] isturn = new int[1001];

        for(int i=0; i<K; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            isturn[num] = dir;

            for(int j=num-1; j>=0; j--)
            {
                int left = (top[j+1] + 6) % 8;
                int right = (top[j] + 2) % 8;

                if(strs[j].charAt(right) != strs[j+1].charAt(left))
                    isturn[j] = -isturn[j+1];
                else
                    isturn[j] = 0;
            }

            for(int j=num+1; j<T; j++)
            {
                int left = (top[j] + 6) % 8;
                int right = (top[j-1] + 2) % 8;

                if(strs[j-1].charAt(right) != strs[j].charAt(left))
                    isturn[j] = -isturn[j-1];
                else
                    isturn[j] = 0;
            }

            for(int j=0; j<T; j++)
            {
                if(isturn[j] == 1)
                    top[j] = (top[j] + 7) % 8;
                else if(isturn[j] == -1)
                    top[j] = (top[j] + 1) % 8;
            }
        }

        int ans = 0;
        for(int i=0; i<T; i++)
        {
            if(strs[i].charAt(top[i]) == '1')
                ans++;
        }

        System.out.println(ans);
    }
}
