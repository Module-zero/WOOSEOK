/*
시그널

https://www.acmicpc.net/problem/16113
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-29
 * Time: 오후 8:50
 */

public class Q16113
{
    public static int[][][] d =
            {
                {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 2}, {3, 0}, {3, 2}, {4, 0}, {4, 1}, {4, 2}}, // 0
                {{1, 0}, {2, 0}, {3, 0}, {4, 0}}, // 1
                {{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {3, 0}, {4, 0}, {4, 1}, {4, 2}}, // 2
                {{0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {3, 2}, {4, 2}, {4, 1}, {4, 0}}, // 3
                {{0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 2}}, // 4
                {{0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 2}, {4, 1}, {4, 0}}, // 5
                {{0, 1}, {0, 2}, {1, 0}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}, {4, 0}, {4, 1}, {4, 2}}, // 6
                {{0, 1}, {0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2}}, // 7
                {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 0}, {3, 2}, {4, 0}, {4, 1}, {4, 2}}, // 8
                {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}, {3, 2}, {4, 0}, {4, 1}, {4, 2}} // 9
            }; // [10][12][2]

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[][] ary = new char[6][20001];

        for(int i=0; i<5; i++)
        {
            int id = N/5*i;

            for(int j=0; j<N/5; j++)
                ary[i][j] = str.charAt(id + j);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N/5; i++)
        {
            int r = 0;
            int c = i;

            boolean[] check = new boolean[10];

            if(ary[r][c] == '#')
            {
                for(int k=0; k<10; k++)
                {
                    int len = d[k].length;

                    int l;
                    for(l=0; l<len; l++)
                    {
                        int newR = r + d[k][l][0];
                        if(newR < 0 || newR > 5)
                            break;

                        int newC = c + d[k][l][1];
                        if(newC < 0 || newC >= N/5)
                            break;

                        if(ary[newR][newC] != '#')
                            break;
                    }

                    if(l == len)
                        check[k] = true;
                }

                int[] dk = {8, 2, 0, 9, 6, 3, 5, 4, 7, 1};
                for(int k=0; k<10; k++)
                {
                    if(check[dk[k]])
                    {
                        if(dk[k] != 1)
                            i+=2;

                        sb.append(dk[k]);
                        break;
                    }
                }
            }
        }

        System.out.println(sb.toString());
    }
}
