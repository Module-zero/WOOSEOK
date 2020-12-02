import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-16
 * Time: 오후 5:27
 */

public class Q2251
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean[][] check = new boolean[201][201];
        check[0][0] = true;
        boolean[] ans = new boolean[201];
        ans[C] = true;

        int[] limit = {A, B, C};
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            int tmpA = tmp[0];
            int tmpB = tmp[1];
            int tmpC = C - tmp[0] - tmp[1];

            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(i == j)
                        continue;

                    int[] copy = {tmpA, tmpB, tmpC};
                    // 물이 넘치면 안된다.
                    if(copy[j] + copy[i] > limit[j])
                    {
                        int water = limit[j] - copy[j];
                        copy[j] += water;
                        copy[i] -= water;
                    }
                    else
                    {
                        copy[j] += copy[i];
                        copy[i] = 0;
                    }

                    if(!check[copy[0]][copy[1]])
                    {
                        if(copy[0] == 0)
                            ans[copy[2]] = true;

                        check[copy[0]][copy[1]] = true;
                        queue.add(new int[]{copy[0], copy[1]});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=C; i++)
        {
            if(ans[i])
                sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }
}
