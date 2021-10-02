import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-08
 * Time: 오후 3:33
 */

public class Q1924
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int total = y;
        for(int i=1; i<x; i++)
            total += day[i-1];

        System.out.println(days[total%7]);
    }
}
