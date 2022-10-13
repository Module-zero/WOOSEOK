import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q10703
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        char[][] ary = new char[3002][3001];
        int lCnt = 0;
        int lStart = 3001;
        int lEnd = 0;
        for(int i=0; i<R; i++)
        {
            String str = br.readLine();
            int len = str.length();
            boolean isLine = true;
            for(int j=0; j<len; j++)
            {
                char ch = str.charAt(j);
                if(ch != '.')
                    isLine = false;

                ary[i][j] = ch;
            }

            if(isLine)
            {
                lStart = Math.min(lStart, i);
                lEnd = Math.max(lEnd, i);
                lCnt++;
            }
        }

        int[] dr = new int[]{0, -1, 1, 0};
        int[] dc = new int[]{-1, 0, 0, 1};
        int[][] map = new int[3001][3001];
        int mCnt = 0;
        int eCnt = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<S; j++)
            {
                if(ary[i][j] == '.')
                    continue;
                else if(map[i][j] != 0)
                    continue;

                int cnt = (ary[i][j] == 'X') ? ++mCnt : --eCnt;
                queue.add(new int[]{i, j});

                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();
                    for(int k=0; k<4; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR < 0 || newR >= R)
                            continue;

                        int newC = tmp[1] + dc[k];
                        if(newC < 0 || newC >= S)
                            continue;

                        if(map[newR][newC] != 0 || ary[newR][newC] != ary[tmp[0]][tmp[1]])
                            continue;

                        map[newR][newC] = cnt;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(mCnt > 1)
            lCnt--;
        if(Integer.MAX_VALUE - eCnt > 1)
            lCnt--;

        while(lCnt-- > 0)
        {
            for(int i=0; i<S; i++)
                sb.append('.');
            sb.append('\n');
        }

        for(int i=0; i<lStart; i++)
        {
            for(int j=0; j<S; j++)
                sb.append(ary[i][j]);

            sb.append('\n');
        }

        for(int i=lEnd+1; i<R; i++)
        {
            for(int j=0; j<S; j++)
                sb.append(ary[i][j]);

            sb.append('\n');
        }


        if(Integer.MAX_VALUE - eCnt > 1)
        {
            for(int i=0; i<S; i++)
                sb.append('#');
        }

        System.out.println(sb.toString());
    }
}
