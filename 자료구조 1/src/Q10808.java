/*
알파벳 개수

문제
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-06
 * Time: 오후 4:28
 */

public class Q10808
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabet = new int[30];

        String str = br.readLine();

        char[] cAry = str.toCharArray();
        int cLen = cAry.length;

        for(int i=0; i<cLen; i++)
        {
            int index = cAry[i] - 'a';
            ++alphabet[index];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(alphabet[0]);
        for(int i=1; i<26; i++)
        {
            sb.append(" " + alphabet[i]);
        }

        System.out.println(sb.toString());
    }
}
