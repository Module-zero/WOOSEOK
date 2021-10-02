import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-30
 * Time: 오후 8:00
 */

public class Q19237
{
    static class Shark
    {
        int r;
        int c;
        boolean died = false;

        public Shark(int r, int c, boolean died)
        {
            this.r = r;
            this.c = c;
            this.died = died;
        }
    }

    static class Smell
    {
        int id;
        int cnt;

        public Smell(int id, int cnt)
        {
            this.id = id;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] ary = new int[21][21];
        Shark[] shark = new Shark[401];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] != 0)
                    shark[ary[i][j]] = new Shark(i, j, false);
            }
        }

        int[][][] info = new int[401][4][4];
        int[] d = new int[401];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++)
            d[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=M; i++)
        {
            for(int j=0; j<4; j++)
            {
                st = new StringTokenizer(br.readLine());

                for(int l=0; l<4; l++)
                    info[i][j][l] = Integer.parseInt(st.nextToken());
            }
        }

        Smell[][] smell = new Smell[21][21];

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int time = 0;
        while(true)
        {
            // 냄새를 뿌린다.
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    if(ary[i][j] == 0)
                    {
                        if(smell[i][j] == null)
                            continue;

                        smell[i][j].cnt--;
                        if(smell[i][j].cnt == 0)
                            smell[i][j] = null;
                    }
                    else
                        smell[i][j] = new Smell(ary[i][j], k);
                }
            }

            boolean isEnd = true;
            for(int i=2; i<=M; i++)
            {
                if(!shark[i].died)
                    isEnd = false;
            }
            if(isEnd)
            {
                System.out.println(time);
                return;
            }
            else
            {
                if(time >= 1000)
                    break;
            }

            for(int i=1; i<=M; i++)
            {
                if(shark[i].died)
                    continue;

                Shark s = shark[i];
                boolean noSmellZone = false;
                int direction = d[i]-1;

                // 우선순위 낮은 것부터 역으로 찾는다.
                int nextR = -1; int nextC = -1; int nextD = -1;
                for(int j=3; j>=0; j--)
                {
                    int next = info[i][direction][j] - 1;
                    int newR = s.r + dr[next];
                    int newC = s.c + dc[next];
                    if(newR >= 0 && newR < N && newC >= 0 && newC < N)
                    {
                        if(smell[newR][newC] == null)
                        {
                            noSmellZone = true;
                            nextR = newR;
                            nextC = newC;
                            nextD = next+1;
                        }

                        // 아무 냄새가 없는 칸을 못찾았으면
                        if(!noSmellZone)
                        {
                            // 자신의 냄새가 있는 칸을 찾는다.
                            if(smell[newR][newC].id == i)
                            {
                                nextR = newR;
                                nextC = newC;
                                nextD = next+1;
                            }
                        }
                    }
                }

                // 다 막혔으면 이동할 수 없다.
                if(nextR == -1 || nextC == -1)
                    continue;

                ary[s.r][s.c] = 0;
                // 다른 상어가 칸에 이미 있을 경우
                if(ary[nextR][nextC] != 0)
                {
                    // 보다 어른 상어가 칸에 존재하면 격자 밖으로 나간다.
                    if(ary[nextR][nextC] < i)
                    {
                        s.died = true;
                        continue;
                    }
                    // 보다 어린 상어면 밖으로 내쫓는다.
                    else
                        shark[ary[nextR][nextC]].died = true;
                }

                ary[nextR][nextC] = i;
                s.r = nextR;
                s.c = nextC;
                d[i] = nextD;
            }

            time++;
        }

        System.out.println(-1);
    }
}
