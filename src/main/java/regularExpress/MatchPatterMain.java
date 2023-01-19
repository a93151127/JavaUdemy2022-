package regularExpress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPatterMain {
    public static void main(String[] args) {
        //匹配數字
        /*
        第一個\是java的要求,要使用模糊比對第一個字母一定要是\
        \d=>表示要匹配的數字
        {11}=>表示要有11位數
         */
        Pattern pattern = Pattern.compile("\\d{11}",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("12345678913");
        boolean isFound = matcher.find();
        if(isFound){
            System.out.println("Found");
        }else{
            System.out.println("Not Found");
        }
    }
}
