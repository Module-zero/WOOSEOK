/*
2진수 8진수

문제
2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-07
 * Time: 오후 4:42
 */

public class Q1373
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int sLen = str.length();
        StringBuilder sb = new StringBuilder();

        int rem = sLen % 3;

        if(rem != 0)
        {
            int sum = 0;
            int power = 1;
            for(int i=rem-1; i>=0; i--)
            {
                sum += (str.charAt(i) - '0') * power;
                power *= 2;
            }

            sb.append(sum);
        }

        for(int i=rem; i<sLen; i+=3)
        {
            int sum = 0;
            int power = 1;

            for(int j=i+2; j>=i; j--)
            {
                sum += (str.charAt(j) - '0') * power;
                power <<= 1;
            }

            // 시간 초과의 원인
            // sb.insert(0, sum);
            sb.append(sum);
        }

        System.out.println(sb.toString());
    }
}
