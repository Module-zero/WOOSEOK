/*
나무 재테크

https://www.acmicpc.net/problem/16235
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-06
 * Time: 오전 1:11
 */

public class Q16235
{
    static class Tree implements Comparable<Tree>
    {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age)
        {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o)
        {
            return age - o.age;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] A = new int[11][11];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> trees[][] = new ArrayList[11][11];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
                trees[i][j] = new ArrayList<>();
        }

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            trees[x][y].add(a);
        }

        // 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
        int[][] food = new int[11][11];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
                food[i][j] = 5;
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int year=0; year<K; year++)
        {
            Stack<Tree> dead = new Stack<>();
            Stack<Tree> newTrees = new Stack<>();

            // 봄
            for(int i=1; i<=N; i++)
            {
                for(int j=1; j<=N; j++)
                {
                    int size = trees[i][j].size();

                    if(size > 0)
                    {
                        Collections.sort(trees[i][j]);
                        ArrayList<Integer> tmp = new ArrayList<>();
                        for(int k=0; k<size; k++)
                        {
                            int age = trees[i][j].get(k);

                            if(food[i][j] - age >= 0)
                            {
                                food[i][j] -= age;
                                tmp.add(age+1);

                                if((age+1) % 5 == 0)
                                    newTrees.add(new Tree(i, j, age+1));
                            }
                            // 양분을 먹지 못하면 죽는다.
                            else
                                dead.add(new Tree(i, j, age/2));
                        }

                        trees[i][j] = tmp;
                    }
                }
            }

            // 여름
            while(!dead.isEmpty())
            {
                Tree tree = dead.pop();

                food[tree.x][tree.y] += tree.age;
            }

            // 가을
            while(!newTrees.isEmpty())
            {
                Tree tree = newTrees.pop();

                for(int k=0; k<8; k++)
                {
                    int newR = tree.x + dr[k];
                    if(newR <= 0 || newR > N)
                        continue;
                    int newC = tree.y + dc[k];
                    if(newC <= 0 || newC > N)
                        continue;

                    trees[newR][newC].add(1);
                }
            }

            // 겨울
            for(int j=1; j<=N; j++)
            {
                for(int k=1; k<=N; k++)
                    food[j][k] += A[j][k];
            }
        }

        int cnt = 0;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
            {
                cnt += trees[i][j].size();
            }
        }

        System.out.println(cnt);
    }
}
