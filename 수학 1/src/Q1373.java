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
        char[] cAry = str.toCharArray();
        int cLen = str.length();

        int cnt = 0;
        int sum = 0;

        StringBuilder sb = new StringBuilder();

        int startIndex = cLen % 3;

        for(int i=startIndex-1; i>=0; i++)
        {
            if(cAry[startIndex-1 - i] == '1')
                sum += (1 << i);
        }
        sb.append(sum);

        for(int i=startIndex; i<cLen; i+=3)
        {
            if(cAry[i] == '1')
                sum += (1 << cnt);
        }

        if(sum != 0)
            sb.insert(0, sum);

        System.out.println(sb.toString());
    }
}
