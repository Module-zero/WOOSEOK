import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 7:31
 */

public class Q20154
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ary = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        String S = br.readLine();
        int len = S.length();
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for(int i=0; i<len; i++)
        {
            int num = S.charAt(i) - 'A';
            queue1.add(ary[num]);
        }

        while(len != 1)
        {
            while(true)
            {
                if(queue1.isEmpty())
                {
                    Queue<Integer> tmp = queue1;
                    queue1 = queue2;
                    queue2 = tmp;
                    break;
                }
                else
                {
                    int n1 = queue1.poll();

                    if(queue1.isEmpty())
                    {
                        Queue<Integer> tmp = queue1;
                        queue1 = queue2;
                        queue2 = tmp;

                        queue1.add(n1);
                        break;
                    }
                    else
                    {
                        int n2 = queue1.poll();
                        queue2.add((n1 + n2) % 10);
                    }
                }
            }

            len = (len + 1) / 2;
        }

        int num = queue1.poll();
        if(num % 2 == 0)
            System.out.println("You're the winner?");
        else
            System.out.println("I'm a winner!");
    }
}
