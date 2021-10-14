import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-14
 * Time: 오후 7:12
 */

public class Q20164
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            int num = tmp[0];
            int tn = num;
            int len = 0;
            while(tn > 0)
            {
                if(((tn % 10) & 1) == 1)
                    tmp[1]++;

                tn /= 10;
                len++;
            }

            if(num < 10)
            {
                max = Integer.max(max, tmp[1]);
                min = Integer.min(min, tmp[1]);
            }
            else if(num < 100)
            {
                int a = num / 10;
                int b = num % 10;

                num = a + b;
                queue.add(new int[]{num, tmp[1]});
            }
            else
            {
                String str = String.valueOf(num);

                for(int i=1; i<len-1; i++)
                {
                    int n1 = Integer.parseInt(str.substring(0, i));

                    for(int j=i+1; j<len; j++)
                    {
                        int n2 = Integer.parseInt(str.substring(i, j));
                        int n3 = Integer.parseInt(str.substring(j, len));

                        queue.add(new int[]{n1+n2+n3, tmp[1]});
                    }
                }
            }
        }

        System.out.println(min + " " + max);
    }
}
