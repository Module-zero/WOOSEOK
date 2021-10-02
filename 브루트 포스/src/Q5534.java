import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 6:11
 */

public class Q5534
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[101];

        String name = br.readLine();
        for(int i=0; i<N; i++)
            strs[i] = br.readLine();

        int ans = 0;
        int nlen = name.length();
        for(int i=0; i<N; i++)
        {
            String str = strs[i];
            int len = str.length();
            boolean isFound = false;

            if(len < nlen)
                continue;

            for(int start=0; start<=len-nlen; start++)
            {
                for(int interval=1; start+interval*(nlen-1)<len; interval++)
                {
                    int cnt = 0;
                    for(int j=0; j<nlen; j++)
                    {
                        int id = start + interval*j;
                        if(id >= len)
                            break;

                        if(name.charAt(j) == str.charAt(id))
                            cnt++;
                        else
                            break;
                    }

                    if(cnt == nlen)
                    {
                        isFound = true;
                        ans++;
                        break;
                    }
                }

                if(isFound)
                    break;
            }
        }

        System.out.println(ans);
    }
}
