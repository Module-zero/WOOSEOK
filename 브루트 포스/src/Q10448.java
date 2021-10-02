import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 9:10
 */

public class Q10448
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ary = new int[50];
        int i = 1;
        int value = i;
        int id = 0;
        while(value <= 1000)
        {
            ary[id] = value;

            id++;
            i++;
            value += i;
        }

        StringBuffer sb = new StringBuffer();
        while(N-- > 0)
        {
            int K = Integer.parseInt(br.readLine());

            boolean isFound = false;
            for(int a=0; a<id; a++)
            {
                for(int b=0; b<id; b++)
                {
                    for(int c=0; c<id; c++)
                    {
                        if(K == ary[a]+ary[b]+ary[c])
                        {
                            isFound = true;
                            break;
                        }
                    }

                    if(isFound)
                        break;
                }

                if(isFound)
                    break;
            }

            if(isFound)
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb.toString());
    }
}
