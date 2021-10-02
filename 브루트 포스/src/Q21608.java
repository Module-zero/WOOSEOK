import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 7:32
 */

public class Q21608
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[401];
        int[][] like = new int[401][4];
        int snum = N*N;
        for(int i=0; i<snum; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ary[i] = Integer.parseInt(st.nextToken());
            for(int j=0; j<4; j++)
                like[ary[i]][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int[][] map = new int[21][21];
        for(int i=0; i<snum; i++)
        {
            int maxnear = 0;
            int maxempty = 0;

            int[][] near = new int[21][21];
            int[][] empty = new int[21][21];
            for(int r=0; r<N; r++)
            {
                for(int c=0; c<N; c++)
                {
                    if(map[r][c] != 0)
                        continue;

                    // 카운트용
                    int nearnum = 0;
                    int emptynum = 0;
                    for(int k=0; k<4; k++)
                    {
                        int newR = r + dr[k];
                        if(newR < 0 || newR >= N)
                            continue;
                        int newC = c + dc[k];
                        if(newC < 0 || newC >= N)
                            continue;

                        // 빈 칸
                        if(map[newR][newC] == 0)
                            emptynum++;
                        // 사람이 앉은 칸이면 좋아하는 애인지 본다.
                        else
                        {
                            for(int l=0; l<4; l++)
                            {
                                if(like[ary[i]][l] == map[newR][newC])
                                {
                                    nearnum++;
                                    break;
                                }
                            }
                        }
                    }

                    near[r][c] = nearnum;
                    if(nearnum > maxnear)
                        maxnear = nearnum;
                    empty[r][c] = emptynum;
                    if(emptynum > maxempty)
                        maxempty = emptynum;
                }
            }

            int targetR = 0;
            int targetC = 0;
            boolean isOk = false;

            for(int r=N-1; r>=0; r--)
            {
                for(int c=N-1; c>=0; c--)
                {
                    if(map[r][c] != 0)
                        continue;

                    if(near[r][c] == maxnear)
                    {
                        if(!isOk)
                        {
                            targetR = r;
                            targetC = c;
                            isOk = true;
                        }
                        else
                        {
                            if(empty[r][c] >= empty[targetR][targetC])
                            {
                                targetR = r;
                                targetC = c;
                            }
                        }
                    }
                    else
                        continue;
                }
            }

            map[targetR][targetC] = ary[i];
        }

        int ans = 0;
        int[] score = {0, 1, 10, 100, 1000};
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                int cnt = 0;
                for(int k=0; k<4; k++)
                {
                    int newR = i + dr[k];
                    if(newR < 0 || newR >= N)
                        continue;

                    int newC = j + dc[k];
                    if(newC < 0 || newC >= N)
                        continue;

                    for(int l=0; l<4; l++)
                    {
                        if(like[map[i][j]][l] == map[newR][newC])
                        {
                            cnt++;
                            break;
                        }
                    }
                }

                ans += score[cnt];
            }
        }

        System.out.println(ans);
    }
}
