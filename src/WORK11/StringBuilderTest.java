package WORK11;

public class StringBuilderTest {
    public static void main(String[] args) {
        String result = myFormat("This is {} {}. Now testing format.", "pos1", "pos2"); // expect result = "This is pos1 pos2"
        System.out.println(result);
    }
    public static String myFormat(String format, String... args) {
        StringBuilder stringBuilder = new StringBuilder(format);
        for(int aindex = 0;aindex < args.length;aindex++){
            int rep = stringBuilder.indexOf("{}");
            stringBuilder.replace(rep,rep+2,args[aindex]);
        }


        return stringBuilder.toString();
    }
}
