import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-29
 * Time: 오후 2:56
 */

public class Q1711
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[1501][2];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ary[i][0] = x;
            ary[i][1] = y;
        }

        double[][] dist = new double[1501][1501];
        for(int i=0; i<N-1; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                long x = ary[j][0] - ary[i][0];
                long y = ary[j][1] - ary[i][1];
                dist[i][j] = dist[j][i] = Math.sqrt(x*x + y*y);
            }
        }

        int cnt = 0;
        for(int i=0; i<N-2; i++)
        {
            for(int j=i+1; j<N-1; j++)
            {
                for(int k=j+1; k<N; k++)
                {
                    double max;
                    double min;
                    double mid;

                    if(dist[i][j] > dist[i][k] && dist[i][j] > dist[j][k])
                    {
                        max = dist[i][j];
                        if(dist[i][k] < dist[j][k])
                        {
                            min = dist[i][k];
                            mid = dist[j][k];
                        }
                        else
                        {
                            min = dist[j][k];
                            mid = dist[i][k];
                        }
                    }
                    else if(dist[i][k] > dist[i][j] && dist[i][k] > dist[j][k])
                    {
                        max = dist[i][k];
                        if(dist[i][j] < dist[j][k])
                        {
                            min = dist[i][j];
                            mid = dist[j][k];
                        }
                        else
                        {
                            min = dist[j][k];
                            mid = dist[i][j];
                        }
                    }
                    else
                    {
                        max = dist[j][k];
                        if(dist[i][j] < dist[i][k])
                        {
                            min = dist[i][j];
                            mid = dist[i][k];
                        }
                        else
                        {
                            min = dist[i][k];
                            mid = dist[i][j];
                        }
                    }

                    System.out.println(max*max + " : " + Double.sum(mid*mid,min*min));
                    if(Double.compare(max*max, mid*mid + min*min) == 0)
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
