/*
2048 (Easy)

https://www.acmicpc.net/problem/12100
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-15
 * Time: 오후 9:26
 */

public class Q12100
{
    static class Node
    {
        int num;
        boolean isCombine;

        public Node(int num)
        {
            this.num = num;
            isCombine = false;
        }
    }

    static int N;
    static int[][] ary = new int[21][21];
    final static int LIMIT = 5;

    public static ArrayList<Integer> gen(int num)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<LIMIT; i++)
        {
            list.add(num & 3);
            num >>= 2;
        }

        return list;
    }

    public static int foo(ArrayList<Integer> dirs)
    {
        Node[][] tmp = new Node[21][21];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                tmp[i][j] = new Node(ary[i][j]);
        }

        // 0 : down, 1 : up, 2 : left, 3 : right
        for(int dir : dirs)
        {
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                    tmp[i][j].isCombine = false;
            }

            // 합칠 수 있는 블록들이 모두 합쳐질 때까지 반복
            while(true)
            {
                boolean isOk = false;

                if(dir == 0)
                {
                    for(int i=N-2; i>=0; i--)
                    {
                        for(int j=0; j<N; j++)
                        {
                            if(tmp[i][j].num == 0)
                                continue;

                            if(tmp[i+1][j].num == 0)
                            {
                                tmp[i+1][j].num = tmp[i][j].num;
                                tmp[i+1][j].isCombine = tmp[i][j].isCombine;
                                tmp[i][j].num = 0;
                                isOk = true;
                            }
                            else if(tmp[i+1][j].num == tmp[i][j].num)
                            {
                                if(!tmp[i][j].isCombine && !tmp[i+1][j].isCombine)
                                {
                                    tmp[i+1][j].num *= 2;
                                    tmp[i+1][j].isCombine = true;
                                    tmp[i][j].num = 0;
                                    isOk = true;
                                }
                            }
                        }
                    }
                }
                else if(dir == 1)
                {
                    for(int i=1; i<N; i++)
                    {
                        for(int j=0; j<N; j++)
                        {
                            if(tmp[i][j].num == 0)
                                continue;

                            if(tmp[i-1][j].num == 0)
                            {
                                tmp[i-1][j].num = tmp[i][j].num;
                                tmp[i-1][j].isCombine = tmp[i][j].isCombine;
                                tmp[i][j].num = 0;
                                isOk = true;
                            }
                            else if(tmp[i-1][j].num == tmp[i][j].num)
                            {
                                if(!tmp[i][j].isCombine && !tmp[i-1][j].isCombine)
                                {
                                    tmp[i-1][j].num *= 2;
                                    tmp[i-1][j].isCombine = true;
                                    tmp[i][j].num = 0;
                                    isOk = true;
                                }
                            }
                        }
                    }
                }
                else if(dir == 2)
                {
                    for(int j=1; j<N; j++)
                    {
                        for(int i=0; i<N; i++)
                        {
                            if(tmp[i][j].num == 0)
                                continue;

                            if(tmp[i][j-1].num == 0)
                            {
                                tmp[i][j-1].num = tmp[i][j].num;
                                tmp[i][j-1].isCombine = tmp[i][j].isCombine;
                                tmp[i][j].num = 0;
                                isOk = true;
                            }
                            else if(tmp[i][j-1].num == tmp[i][j].num)
                            {
                                if(!tmp[i][j].isCombine && !tmp[i][j-1].isCombine)
                                {
                                    tmp[i][j-1].num *= 2;
                                    tmp[i][j-1].isCombine = true;
                                    tmp[i][j].num = 0;
                                    isOk = true;
                                }
                            }
                        }
                    }
                }
                else if(dir == 3)
                {
                    for(int j=N-2; j>=0; j--)
                    {
                        for(int i=0; i<N; i++)
                        {
                            if(tmp[i][j].num == 0)
                                continue;

                            if(tmp[i][j+1].num == 0)
                            {
                                tmp[i][j+1].num = tmp[i][j].num;
                                tmp[i][j+1].isCombine = tmp[i][j].isCombine;
                                tmp[i][j].num = 0;
                                isOk = true;
                            }
                            else if(tmp[i][j+1].num == tmp[i][j].num)
                            {
                                if(!tmp[i][j].isCombine && !tmp[i][j+1].isCombine)
                                {
                                    tmp[i][j+1].num *= 2;
                                    tmp[i][j+1].isCombine = true;
                                    tmp[i][j].num = 0;
                                    isOk = true;
                                }
                            }
                        }
                    }
                }

                // 더 이상 블록이 움직이지 않으면 탈출
                if(!isOk)
                    break;
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(ans < tmp[i][j].num)
                    ans = tmp[i][j].num;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i=0; i<(1<<(LIMIT*2)); i++)
        {
            // 방향을 정한다.
            ArrayList<Integer> list = gen(i);
            int cur = foo(list);
            if(ans < cur)
                ans = cur;
        }

        System.out.println(ans);
    }
}
