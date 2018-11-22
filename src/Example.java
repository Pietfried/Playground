import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.StringReader;

import java.net.DatagramSocket;

public class Example {

    private String str = "ExampleField";
    
    private int number = 5;
    
    int[] array = new int[]{4,2};
    
    int[][] _table = new int[2][3]; 
    
    private String getSomeString() {
        return "nice access to this method.";
    }
    
    private int getNumber() {
        return 100;
    }
    
    public static void main(String[] args) throws IOException {
        PushbackReader r = new PushbackReader(new StringReader("What's up?"));
        
        char x = (char) r.read();
        System.out.println(Character.toString(x));
        
        char y = (char) r.read();
        System.out.println(Character.toString(y));
        
        r.unread(72);
        
        char z = (char) r.read();
        System.out.println(Character.toString(z));
        
        System.out.println((int) '\b');
    }
}
