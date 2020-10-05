/*
문제
Hello World!를 출력하시오.

입력
없음

출력
Hello World!를 출력하시오.
 */

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-05
 * Time: 오후 2:31
 */

public class Q2557
{
    public static void main(String[] args)
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        try
        {
            writer.write("Hello World!");
            writer.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try { writer.close(); } catch(Exception e) {}
        }
    }
}
