/*
 * @author kumar
 * @author lohia
 * @author pant
 * @author sukrit
 */

public class Utility
{
    public static String toBinary(int num, int size)
    {
        return Utility.toBinary(num, size, 1);
    }
    
    private static String toBinary(int num, int size, int cursize)
    {
        if(num == 0 || num == 1)
        {
            StringBuilder str = new StringBuilder(0);
            if(cursize < size)
            {
                for(int i = 1; i <= size - cursize; i++)
                {
                    str.append(0);
                }
            }
            str.append(num);
            return str.toString();
        }
        StringBuilder str = new StringBuilder(Utility.toBinary(num >> 1, size, cursize + 1));
        str.append(num & 1);
        return str.toString();
    }
    
    public static int hash(int key)
    {
        return key % 16;
    }
}