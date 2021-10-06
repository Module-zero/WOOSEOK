import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-03
 * Time: 오후 4:52
 */

public class Q20365
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        char[] ary = str.toCharArray();

        int start = 0;
        int end = len-2;
        char cur = ary[len-1];
        int ans = 1;
        while(start < end)
        {
            while(start <= end && ary[start] == cur)
                start++;
            while(start <= end && ary[end] == cur)
                end--;

            if(start > end)
                break;

            if(cur == 'R')
                cur = 'B';
            else
                cur = 'R';

            ans++;
        }

        System.out.println(ans);
    }
}
