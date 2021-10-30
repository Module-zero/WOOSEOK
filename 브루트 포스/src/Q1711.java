import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-29
 * Time: 오후 2:56
 */

public class Q1711
{
    static class Temp
    {
        long a;
        long b;

        public Temp(long a, long b)
        {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Temp temp = (Temp) o;

            if (a != temp.a) return false;
            return b == temp.b;
        }

        @Override
        public int hashCode()
        {
            int result = (int) (a ^ (a >>> 32));
            result = 31 * result + (int) (b ^ (b >>> 32));
            return result;
        }
    }

    public static long gcd(long a, long b)
    {
        while(b != 0)
        {
            long t = a % b;
            a = b;
            b = t;
        }

        return a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Temp[] ary = new Temp[1501];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ary[i] = new Temp(x, y);
        }

        HashMap<Temp, Integer> map = new HashMap<>();
        for(int i=0; i<N-1; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                long x = ary[i].a - ary[j].a;
                long y = ary[i].b - ary[j].b;

                long g = gcd(x, y);
                if(g < 0)
                    g = -g;

                x /= g;
                y /= g;

            }
        }
    }
}
