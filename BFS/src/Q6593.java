/*
상범 빌딩

https://www.acmicpc.net/problem/6593
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-03
 * Time: 오후 9:16
 */

public class Q6593
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)
                break;

            char[][][] ary = new char[31][31][31];
            int[] dl = {0, 0, 0, 0, -1, 1};
            int[] dr = {-1, 0, 0, 1, 0, 0};
            int[] dc = {0, -1, 1, 0, 0, 0};
            int sL = 0;
            int sR = 0;
            int sC = 0;
            for(int i=0; i<L; i++)
            {
                for(int j=0; j<R; j++)
                {
                    String str = br.readLine();

                    for(int k=0; k<C; k++)
                    {
                        ary[i][j][k] = str.charAt(k);
                        if(ary[i][j][k] == 'S')
                        {
                            sL = i;
                            sR = j;
                            sC = k;
                        }
                    }
                }

                // 공백 제거
                br.readLine();
            }

            int[][][] time = new int[31][31][31];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{sL, sR, sC});
            time[sL][sR][sC] = 1;

            boolean escape = false;
            while(!queue.isEmpty())
            {
                int[] tmp = queue.poll();

                for(int i=0; i<6; i++)
                {
                    int newL = tmp[0] + dl[i];
                    if(newL < 0 || newL >= L)
                        continue;
                    int newR = tmp[1] + dr[i];
                    if(newR < 0 || newR >= R)
                        continue;
                    int newC = tmp[2] + dc[i];
                    if(newC < 0 || newC >= C)
                        continue;

                    if(ary[newL][newR][newC] == '#' || time[newL][newR][newC] != 0)
                        continue;

                    if(ary[newL][newR][newC] == 'E')
                    {
                        sb.append("Escaped in ").append(time[tmp[0]][tmp[1]][tmp[2]]).append(" minute(s).\n");
                        escape = true;
                        break;
                    }

                    time[newL][newR][newC] = time[tmp[0]][tmp[1]][tmp[2]] + 1;
                    queue.add(new int[]{newL, newR, newC});
                }

                if(escape)
                    break;
            }

            if(!escape)
                sb.append("Trapped!\n");
        }

        System.out.print(sb.toString());
    }
}
