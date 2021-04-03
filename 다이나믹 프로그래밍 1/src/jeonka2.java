import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-26
 * Time: 오후 1:45
 */

public class jeonka2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();

        TreeSet<String> set = new TreeSet<>();
        // 길이
        for(int l=1; l<=len; l++)
        {
            // 끝 인덱스
            for(int i=0; i+l<=len; i++)
            {
                String tmp = str.substring(i, i+l);
                boolean[] isOk = new boolean[26];
                int tlen = tmp.length();

                int j=0;
                for(; j<tlen; j++)
                {
                    int id = tmp.charAt(j) - 'a';
                    if(!isOk[id])
                        isOk[id] = true;
                    // 나왔던 알파벳이 또 포함되어 있으면
                    else
                        break;
                }

                // 중복된 알파벳이 하나도 없으면
                if(j == tlen)
                    set.add(tmp);
            }
        }

        System.out.println(set.size());
    }
}
