import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오후 4:48
 */

public class Q1261
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j) - '0';
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] check = new int[101][101];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                check[i][j] = Integer.MAX_VALUE;
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        queue.add(new int[]{0, 0, 0});
        check[0][0] = 0;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR < 0 || newR >= N)
                    continue;
                int newC = tmp[1] + dc[i];
                if(newC < 0 || newC >= M)
                    continue;

                int crash = (ary[newR][newC] == 1 ? tmp[2] + 1 : tmp[2]);
                if(crash < check[newR][newC])
                {
                    check[newR][newC] = crash;
                    queue.add(new int[]{newR, newC, crash});
                }
            }
        }

        System.out.println(check[N-1][M-1]);
    }
}
