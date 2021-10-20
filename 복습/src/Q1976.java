import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-20
 * Time: 오후 1:49
 */

public class Q1976
{
    static int N;
    static int M;
    static int[][] ary = new int[201][201];
    static int[] p = new int[201];

    public static int find(int n)
    {
        // 루트면 자기 자신을 리턴
        if(p[n] < 0)
            return n;

        // 다시 내려오면서 부모를 루트로 변경
        p[n] = find(p[n]);
        return p[n];
    }

    public static void merge(int a, int b)
    {
        // 각자의 부모로 변경
        a = find(a);
        b = find(b);

        // 같은 부모면 그냥 리턴
        if(a == b)
            return;

        // 다른 부모면 병합 후 다른 쪽에 그룹원 수를 매핑
        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++)
            p[i] = -1;

        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] == 1)
                    merge(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = new int[1001];
        for(int i=0; i<M; i++)
            target[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<M-1; i++)
        {
            if(find(target[i]) != find(target[i+1]))
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    /*
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] link = new int[201][201];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                link[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] target = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            target[i] = Integer.parseInt(st.nextToken());

        boolean[][] ok = new boolean[201][201];
        for(int i=1; i<=N; i++)
        {
            boolean[] check = new boolean[201];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            check[i] = true;
            ok[i][i] = true;
            while(!queue.isEmpty())
            {
                int tmp = queue.poll();

                for(int j=1; j<=N; j++)
                {
                    if(check[j])
                        continue;
                    if(link[tmp][j] == 0)
                        continue;

                    queue.add(j);
                    check[j] = true;
                    ok[i][j] = true;
                }
            }
        }

        for(int i=0; i<M-1; i++)
        {
            if(!ok[target[i]][target[i+1]])
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
    */
}
