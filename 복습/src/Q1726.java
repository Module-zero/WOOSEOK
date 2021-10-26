import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-26
 * Time: 오후 9:04
 */

public class Q1726
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] ary = new int[101][101];
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        int[][] info = new int[2][3];
        for(int i=0; i<2; i++)
        {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken()) - 1;
        }

        if(info[0][0] == info[1][0] && info[0][1] == info[1][1] && info[0][2] == info[1][2])
        {
            System.out.println(0);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] check = new boolean[101][101][4];

        queue.add(new int[]{info[0][0], info[0][1], info[0][2], 0});
        check[info[0][0]][info[0][1]][info[0][2]] = true;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            int d = tmp[2];
            tmp[3]++;

            for(int i=1; i<=3; i++)
            {
                int newR = tmp[0] + i*dr[d];
                if(newR < 1 || newR > M)
                    break;

                int newC = tmp[1] + i*dc[d];
                if(newC < 1 || newC > N)
                    break;

                if(ary[newR][newC] == 1)
                    break;

                if(check[newR][newC][d])
                    continue;

                if(newR == info[1][0] && newC == info[1][1] && d == info[1][2])
                {
                    System.out.println(tmp[3]);
                    return;
                }

                check[newR][newC][d] = true;
                queue.add(new int[]{newR, newC, d, tmp[3]});
            }

            if(d % 2 == 0)
                d++;

            d = 3 - d;
            if(!check[tmp[0]][tmp[1]][d])
            {
                if(tmp[0] == info[1][0] && tmp[1] == info[1][1] && d == info[1][2])
                {
                    System.out.println(tmp[3]);
                    return;
                }

                check[tmp[0]][tmp[1]][d] = true;
                queue.add(new int[]{tmp[0], tmp[1], d, tmp[3]});
            }

            d++;
            if(!check[tmp[0]][tmp[1]][d])
            {
                if(tmp[0] == info[1][0] && tmp[1] == info[1][1] && d == info[1][2])
                {
                    System.out.println(tmp[3]);
                    return;
                }

                check[tmp[0]][tmp[1]][d] = true;
                queue.add(new int[]{tmp[0], tmp[1], d, tmp[3]});
            }
        }
    }
}
