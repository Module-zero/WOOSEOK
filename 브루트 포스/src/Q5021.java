import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-19
 * Time: 오전 9:04
 */

public class Q5021
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String king = br.readLine();
        map.put(king, 0);

        ArrayList<Integer>[] list = new ArrayList[301];
        for(int i=0; i<=300; i++)
            list[i] = new ArrayList<>();

        int[] indeg = new int[301];
        String[] s = new String[301];
        s[0] = king;
        int cnt = 1;
        while(N-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String f = st.nextToken();
            String m = st.nextToken();

            Integer nv = map.putIfAbsent(name, cnt);
            if(nv == null)
            {
                nv = cnt;
                cnt++;
            }

            indeg[nv] = 2;
            s[nv] = name;

            Integer fv = map.putIfAbsent(f, cnt);
            if(fv == null)
            {
                fv = cnt;
                cnt++;
            }

            list[fv].add(nv);
            s[fv] = f;

            Integer mv = map.putIfAbsent(m, cnt);
            if(mv == null)
            {
                mv = cnt;
                cnt++;
            }

            list[mv].add(nv);
            s[mv] = m;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<cnt; i++)
        {
            if(indeg[i] == 0)
                queue.add(i);
        }

        double[] d = new double[301];
        d[0] = 1;

        while(!queue.isEmpty())
        {
            Integer tmp = queue.poll();

            for(int i : list[tmp])
            {
                d[i] += d[tmp];
                indeg[i]--;
                if(indeg[i] == 0)
                {
                    d[i] /= 2;
                    queue.add(i);
                }
            }
        }

        double max = Double.MIN_VALUE;
        String ans = null;
        while(M-- > 0)
        {
            String name = br.readLine();
            Integer i = map.get(name);
            if(i == null)
                continue;

            if(Double.compare(d[i], max) > 0)
            {
                max = d[i];
                ans = name;
            }
        }

        System.out.println(ans);
    }
}
