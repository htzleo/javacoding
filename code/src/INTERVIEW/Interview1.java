package INTERVIEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;

public class Interview1 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        HashSet<String> set = new HashSet<>();
        while ((line = in.readLine()) != null) {
            for (String retval : line.split("\"",3)) {
                if(retval.charAt(0)=='N'){
                    set.add(retval);
                }
            }
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String str = it.next();
                System.out.println(str);
            }
        }

    }

}
class solution{

}
