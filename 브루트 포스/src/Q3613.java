import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 7:07
 */

public class Q3613
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean isJava = false;
        boolean isCpp= false;

        char[] ary = str.toCharArray();
        int len = str.length();
        StringBuffer sb = new StringBuffer();
        boolean isUdbar = false;
        for(int i=0; i<len; i++)
        {
            char ch = ary[i];

            if(ch == '_')
            {
                // 자바였는데 _이 나오면 에러. _이 2번 나와도 에러.
                if(i == 0 || isJava || isUdbar)
                {
                    System.out.println("Error!");
                    return;
                }

                isCpp = true;
                isUdbar = true;
                continue;
            }
            else if(ch >= 'A' && ch <= 'Z')
            {
                // cpp였는데 대문자가 나오면 에러.
                if(i == 0 || isCpp)
                {
                    System.out.println("Error!");
                    return;
                }

                isJava = true;
                ary[i] += 32;
                sb.append('_');
            }

            if(isUdbar)
            {
                ary[i] -= 32;
                isUdbar = false;
            }

            sb.append(ary[i]);
        }

        if(isCpp && isJava)
        {
            System.out.println("Error!");
            return;
        }
        else if(isUdbar)
        {
            System.out.println("Error!");
            return;
        }

        System.out.println(sb.toString());
    }
}
