import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-10-13
 * Time: 오후 9:11
 */

public class Q21923
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[1001][1001];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] upMap = new int[1001][1001];
        int[][] downMap = new int[1001][1001];
        upMap[N-1][0] = ary[N-1][0];
        for(int i=N-1; i>=0; i--)
        {
            for(int j=0; j<M; j++)
            {
                if(i+1 < N && j-1 >= 0)
                    upMap[i][j] = Integer.max(upMap[i][j-1] + ary[i][j], upMap[i+1][j] + ary[i][j]);
                else if(j-1 >= 0)
                    upMap[i][j] = upMap[i][j-1] + ary[i][j];
                else
                    upMap[i][j] = upMap[i+1][j] + ary[i][j];
            }
        }

        downMap[N-1][M-1] = ary[N-1][M-1];
        for(int i=N-1; i>=0; i--)
        {
            for(int j=M-1; j>=0; j--)
            {
                if(i+1 < N && j+1 < M)
                    downMap[i][j] = Integer.max(downMap[i+1][j] + ary[i][j], downMap[i][j+1] + ary[i][j]);
                else if(i+1 < N)
                    downMap[i][j] = downMap[i+1][j] + ary[i][j];
                else
                    downMap[i][j] = downMap[i][j+1] + ary[i][j];
            }
        }

        int ans = upMap[0][0] + downMap[0][0];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                ans = Integer.max(ans, upMap[i][j] + downMap[i][j]);
        }

        System.out.println(ans);
    }
}
