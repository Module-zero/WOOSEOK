import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 4:36
 */

public class Q1977
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;
        for(int i=1; i<=100; i++)
        {
            int num = i*i;
            if(num >= M && num <= N)
            {
                sum += num;

                if(min == 0)
                    min = num;
            }
        }

        if(sum == 0)
            System.out.println(-1);
        else
        {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
