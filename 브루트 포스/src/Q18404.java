import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-09
 * Time: 오후 3:38
 */

public class Q18404
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

        int[][] ary = new int[1001][2];
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            ary[i][0] = Integer.parseInt(st.nextToken());
            ary[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        int[][] cnt = new int[501][501];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, Y, 1});
        cnt[X][Y] = 1;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            for(int i=0; i<8; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR <= 0 || newR > N)
                    continue;

                int newC = tmp[1] + dc[i];
                if(newC <= 0 || newC > N)
                    continue;

                if(cnt[newR][newC] != 0)
                    continue;

                cnt[newR][newC] = cnt[tmp[0]][tmp[1]] + 1;
                queue.add(new int[]{newR, newC, cnt[newR][newC]});
            }
        }

        for(int i=0; i<M; i++)
            sb.append(cnt[ary[i][0]][ary[i][1]] - 1).append(' ');

        System.out.println(sb.toString());
    }
}
