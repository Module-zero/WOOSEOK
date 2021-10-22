import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-22
 * Time: 오후 2:28
 */

public class Q20437
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] cnt = new int[26];
            ArrayList<Integer>[] list = new ArrayList[26];
            for(int i=0; i<26; i++)
                list[i] = new ArrayList<>();

            char[] ary = W.toCharArray();
            int len = ary.length;
            int min = 20000;
            int max = 0;
            for(int i=0; i<len; i++)
            {
                int id = ary[i] - 'a';
                list[id].add(i);

                cnt[id]++;
                if(cnt[id] >= K)
                {
                    // 딱 K개가 되는 지점
                    int prev = list[id].get(cnt[id] - K);
                    min = Integer.min(min, i - prev + 1);
                    max = Integer.max(max, i - prev + 1);
                }
            }

            if(min == 20000 || max == 0)
                sb.append("-1\n");
            else
                sb.append(min).append(' ').append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
