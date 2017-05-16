package lesson1;

public class Lesson1 {

    public static float unit3 (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean unit4 (int a, int b) {
        if ((a + b <= 20) & (a + b >= 10))
            return true;
        else
            return false;
    }

    public static boolean unit5 (int year) {
        if (year % 400 == 0)
            return true;
        else
            if (year % 100 == 0)
                return false;
            else
                if (year % 4 == 0)
                    return true;
                else
                    return false;
    }

    public static void main(String[] args) {
        byte b = 0;
        short s = 0;
        int i = 0;
        long l = 0;

        char c = 'a';

        float f = 0.0f;
        double d = 0.0d;

        boolean bool = false;

        System.out.println(unit3(1.0f, 2.0f, 3.0f, 4.0f));
        System.out.println(unit4(10,5));
        System.out.println(unit5(2016));
    }
}
