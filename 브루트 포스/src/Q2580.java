/*
스도쿠

https://www.acmicpc.net/problem/2580
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 9:10
 */

public class Q2580
{
    static int[][] ary = new int[9][9];
    static ArrayList<Integer> rows = new ArrayList<>();
    static ArrayList<Integer> cols = new ArrayList<>();
    static int size;
    static boolean[][] rowCheck = new boolean[9][10];
    static boolean[][] colCheck = new boolean[9][10];
    static boolean[][] squareCheck = new boolean[9][10];
    static StringBuilder sb = new StringBuilder();

    public static boolean sudoku(int index)
    {
        if(index == size)
        {
            for(int i=0; i<9; i++)
            {
                for(int j=0; j<9; j++)
                    sb.append(ary[i][j]).append(" ");

                sb.append("\n");
            }

            return true;
        }

        int row = rows.get(index);
        int col = cols.get(index);

        for(int n=1; n<=9; n++)
        {
            // 겹치는 게 없으면 다음 칸을 채운다.
            if(!rowCheck[row][n] && !colCheck[col][n] && !squareCheck[row/3*3 + col/3][n])
            {
                ary[row][col] = n;
                rowCheck[row][n] = true;
                colCheck[col][n] = true;
                squareCheck[row/3*3 + col/3][n] = true;

                boolean isFound = sudoku(index + 1);

                // 찾았으면 종료
                if(isFound)
                    return true;

                ary[row][col] = 0;
                rowCheck[row][n] = false;
                colCheck[col][n] = false;
                squareCheck[row/3*3 + col/3][n] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                int num = ary[i][j];

                // i번째 행에 num이라는 수가 있다.
                rowCheck[i][num] = true;
                // j번째 열에 num이라는 수가 있다.
                colCheck[j][num] = true;
                // n번째 사각형에 num이라는 수가 있다.
                squareCheck[i/3*3 + j/3][num] = true;

                if(num == 0)
                {
                    // 0의 위치 저장
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        size = rows.size();

        sudoku(0);

        System.out.println(sb.toString());
    }
}
