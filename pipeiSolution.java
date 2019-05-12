import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pipeiSolution {
    public static String mapping(char n){  //数字到字母的对应
        String str=null;
        switch(n){
            case '0':
                str="";
                break;
            case'1':
                str="";
                break;
            case'2':
                str="abc";
                break;
            case'3':
                str="def";
                break;
            case'4':
                str="ghi";
                break;
            case'5':
                str="jkl";
                break;
            case'6':
                str="mno";
                break;
            case'7':
                str="pqrs";
                break;
            case'8':
                str="tuv";
                break;
            case'9':
                str="wxyz";
                break;
        }
        return str;
    }
    public static  List<String> letterCombinations(String datas){
        List<String> ret=new ArrayList<>();
        int i=0;
        for(i = 0;i<datas.length();i++){
            char c=datas.charAt(i);
            int length=ret.size();
            String substring=mapping(c);
            if(length==0){
                for(int j=0;j<substring.length();j++){
                    ret.add(" "+substring.charAt(j));    //直接加
                }
            }
            else{
                for(int p=0;p<length;p++){
                    for(int m=0;m<substring.length();m++){
                        ret.add(ret.get(p)+substring.charAt(m));  //加入除第一组的其他组合
                    }
                    ret.set(p,(ret.get(p)+substring.charAt(0)));  //覆盖之前的
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
        System.out.println("please input the string: ");
        String datas=scan.nextLine();
        System.out.println(letterCombinations(datas));

    }
}
