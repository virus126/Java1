package lesson6;
//1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//2.	Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
//4.	** Написать программу, которая проверит, присутствует ли указанное пользователем слово в ПАПКЕ, в которой будут находиться
//        10 файлов, подобных тем, что созданы в пункте 1.

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Lesson6 {

    static boolean isWordInFile (String word, String file) throws Exception {
        FileInputStream fin = new FileInputStream(file);
        String nextword = "";
        int symbol;
        while ((symbol = fin.read()) != -1) {
            switch (symbol) {
                case 46: // .
                case 44: // ,
                case 63: // ?
                case 33: // !
                case 13: // перенос строки
                    symbol = fin.read();
                case 32: // пробел
                    if (nextword.equals(word))
                        return true;
                    else
                        nextword = "";
                    break;
                default: // любой другой символ
                    nextword += (char)symbol;
                    break;
            }
        }
        fin.close();
        return false;
    }

    static void unit2 () throws Exception {
        FileInputStream fin = new FileInputStream("examples/text1.txt");
        FileOutputStream fos = new FileOutputStream("examples/text3.txt");
        int symbol;
        while ((symbol = fin.read()) != -1) {
            fos.write(symbol);
        }
        fin.close();
        fos.write(13); // переносим
        fos.write(10); // строку
        fin = new FileInputStream("examples/text2.txt");
        while ((symbol = fin.read()) != -1) {
            fos.write(symbol);
        }
        fin.close();
        fos.flush();
        fos.close();
    }

    static boolean unit3() throws Exception {
        return isWordInFile("java", "examples/text1.txt");
    }

    static boolean unit4() throws Exception {
        File[] files = new File("examples").listFiles();
        for (File file : files) {
            if (isWordInFile("java", file.getPath()))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            //unit2();
            //System.out.println(unit3());
            //System.out.println(unit4());
        }
        catch (Exception e) {}
    }
}
