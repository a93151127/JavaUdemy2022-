package regularExpress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressMain {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Martin", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("MartinLuShaoLun");
        //matcher.find()只能使用一次
        if(matcher.find()){
            System.out.println("found");
        }else{
            System.out.println("Not Found");
        }
        //第二次會找不到
        if(matcher.find()){
            System.out.println("found");
        }else{
            System.out.println("Not Found");
        }
    }
}
