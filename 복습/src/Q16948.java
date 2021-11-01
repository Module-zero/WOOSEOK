import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-01
 * Time: 오후 12:27
 */

public class Q16948
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        if(r1 == r2 && c1 == c2)
        {
            System.out.println(0);
            return;
        }

        boolean[][] check = new boolean[201][201];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r1, c1, 0});
        check[r1][c1] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<6; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR < 0 || newR >= N)
                    continue;
                int newC = tmp[1] + dc[i];
                if(newC < 0 || newC >= N)
                    continue;

                if(check[newR][newC])
                    continue;

                if(r2 == newR && c2 == newC)
                {
                    System.out.println(tmp[2] + 1);
                    return;
                }

                check[newR][newC] = true;
                queue.add(new int[]{newR, newC, tmp[2]+1});
            }
        }

        System.out.println(-1);
    }
}
