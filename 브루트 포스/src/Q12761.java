import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-20
 * Time: 오후 10:48
 */

public class Q12761
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N == M)
        {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        boolean[] check = new boolean[100001];
        check[N] = true;
        while(!queue.isEmpty())
        {
            int[] ary = queue.poll();
            int num = ary[0];
            int cnt = ary[1] + 1;

            // +1
            int tmp = num + 1;
            if(tmp <= 100000 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // -1
            tmp = num - 1;
            if(tmp >= 0 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // +A
            tmp = num + A;
            if(tmp <= 100000 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // -A
            tmp = num - A;
            if(tmp >= 0 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // +B
            tmp = num + B;
            if(tmp <= 100000 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // -B
            tmp = num - B;
            if(tmp >= 0 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // *A
            tmp = num * A;
            if(tmp <= 100000 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
            // *B
            tmp = num * B;
            if(tmp <= 100000 && !check[tmp])
            {
                if(tmp == M)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp, cnt});
                check[tmp] = true;
            }
        }
    }
}
