package code_practice;

import org.junit.Assert;
import org.junit.Test;

public class First_Unique_character {
    public char firstUniqChar(String str) {
        if (str == null || str.length()== 0){
            return '0';
        }
        int[] record = new int[256];
        for (int i =0;i<str.length();i++){
            record[str.charAt(i)]++;
        }
        for(int i = 0; i < str.length(); i++){
            if(record[str.charAt(i)] == 1){
                return str.charAt(i);
            }
        }
        return '0';
    }
    @Test
    public void test(){
        String str = "abcaacc";
        char res = firstUniqChar(str);
        Assert.assertEquals(res,'b');
    }

}
