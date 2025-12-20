package demel2;

import java.io.FileReader;
import java.io.IOException;

public class test05 {
    public static void main(String[] args) throws IOException
    {
        FileReader  fileReader = new FileReader("src/zqp.txt");
        char [] chars=new char[1024];
        int len;
        while ((len=fileReader.read(chars))!=-1){
            System.out.println(new String(chars,0, len));
        }
    }
}
