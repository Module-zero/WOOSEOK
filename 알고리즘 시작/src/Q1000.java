/*
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A+B를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-05
 * Time: 오후 2:28
 */

public class Q1000
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arrays = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<2; i++)
            arrays[i] = Integer.parseInt(st.nextToken());

        System.out.println(arrays[0] + arrays[1]);
    }
}
