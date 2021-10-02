import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-16
 * Time: 오후 7:44
 */

public class Q3187
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] ary = new char[250][250];
        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
                ary[i][j] = str.charAt(j);
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dr = {-1, 0, 0, 1};;
        int[] dc = {0, -1, 1, 0};
        boolean[][] check = new boolean[250][250];
        int vans = 0;
        int kans = 0;
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(check[i][j])
                    continue;

                if(ary[i][j] == '#')
                    continue;

                queue.add(new int[]{i, j});
                check[i][j] = true;
                int vcnt = 0;
                int kcnt = 0;

                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();
                    if(ary[tmp[0]][tmp[1]] == 'v')
                        vcnt++;
                    else if(ary[tmp[0]][tmp[1]] == 'k')
                        kcnt++;

                    for(int k=0; k<4; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR < 0 || newR >= R)
                            continue;
                        int newC = tmp[1] + dc[k];
                        if(newC < 0 || newC >= C)
                            continue;

                        if(check[newR][newC])
                            continue;
                        if(ary[newR][newC] == '#')
                            continue;

                        check[newR][newC] = true;
                        queue.add(new int[]{newR, newC});
                    }
                }

                if(kcnt > vcnt)
                    kans += kcnt;
                else
                    vans += vcnt;
            }
        }

        System.out.println(kans + " " + vans);
    }
}
