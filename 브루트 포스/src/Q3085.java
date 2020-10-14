/*
사탕 게임

문제
상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.

가장 처음에 N×N크기에 사탕을 채워 놓는다. 사탕의 색은 모두 같지 않을 수도 있다. 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다. 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다. 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다.

사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)

다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.

사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.

출력
첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-14
 * Time: 오후 8:58
 */

public class Q3085
{
    public static void swap(char[] ary1, char[] ary2, int index1, int index2)
    {
        char tmp = ary1[index1];
        ary1[index1] = ary2[index2];
        ary2[index2] = tmp;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] ary = new char[N][N];

        for(int i=0; i<N; i++)
        {
            ary[i] = br.readLine().toCharArray();
        }

        int max = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(i != N-1)
                {
                    swap(ary[i], ary[i+1], j, j);

                    int cnt = 1;
                    for(int k=i; k<=i+1; k++)
                    {
                        cnt = 1;
                        for(int l=0; l<N-1; l++)
                        {
                            if(ary[k][l] == ary[k][l+1])
                            {
                                cnt++;

                                if(max < cnt)
                                    max = cnt;
                            }
                            else
                                cnt = 1;
                        }
                    }

                    cnt = 1;
                    for(int k=0; k<N-1; k++)
                    {
                        if(ary[k][j] == ary[k+1][j])
                        {
                            cnt++;

                            if(max < cnt)
                                max = cnt;
                        }
                        else
                            cnt = 1;
                    }

                    swap(ary[i], ary[i+1], j, j);
                }

                if(j != N-1)
                {
                    swap(ary[i], ary[i], j, j+1);

                    int cnt = 1;
                    for(int l=j; l<=j+1; l++)
                    {
                        cnt = 1;
                        for(int k=0; k<N-1; k++)
                        {
                            if(ary[k][l] == ary[k+1][l])
                            {
                                cnt++;
                                if(max < cnt)
                                    max = cnt;
                            }
                            else
                                cnt = 1;
                        }
                    }

                    cnt = 1;
                    for(int l=0; l<N-1; l++)
                    {
                        if(ary[i][l] == ary[i][l+1])
                        {
                            cnt++;
                            if(max < cnt)
                                max = cnt;
                        }
                        else
                            cnt = 1;
                    }

                    swap(ary[i], ary[i], j, j+1);
                }
            }
        }

        System.out.println(max);
    }
}
