
import java.util.Stack;

//1.将中缀表达式转换为后缀表达式
//2.后缀表达式求值
public class Expression {
    public  static String convert(String expstr) {
        Stack<String> stack = new Stack<>();
        int midindex = 0;   //用来遍历中缀表达式
        String LastStr = "";    //LastStr用来存储后缀表达式

        String currency = "";  //当前
        String nextString = "";  //下一个
        char c = expstr.charAt(midindex);
        while (midindex < expstr.length()) {
            switch (c) {
                case '+':
                case '-':
                    while (!stack.isEmpty() && !stack.getClass().equals("("))
                        LastStr += stack.pop();
                    stack.push(c + "");
                    midindex++;
                    break;


                case '*':
                case '/':
                    while ((!stack.isEmpty()) && (stack.get(midindex) .equals("*") || stack.get(midindex).equals("/")))
                        LastStr += stack.pop();
                    stack.push(c + "");
                    midindex++;
                    break;


                case '(':
                    stack.push(c + "");
                    midindex++;
                    break;
                case ')':
                    String out = stack.pop();
                    while (out != null && !out.equals("(")) {
                        LastStr += out;
                        out = stack.pop();
                    }
                    midindex++;
                    break;

                default:
                    while (midindex < expstr.length() && (c >= '0' && c <= '9') ){
                        LastStr += c;
                        midindex++;
                        if (midindex < expstr.length())
                            c = expstr.charAt(midindex);
                    }
                    LastStr += "";

            }
        }

        while (!stack.isEmpty()) {
            LastStr += stack.pop();
        }

        return LastStr;
    }

    public static int data(String LastStr){  //计算后缀表达式的值
        Stack<Integer> stack=new Stack<Integer>();
        int lastindex=0,result=0;
        while(lastindex<LastStr.length()){
            char c=LastStr.charAt(lastindex);
            if(c>='0'&&c<='9')
            {
                result=0;
                while(c!=' ')     //字符串转化为数字
                {
                    result=result*10+Integer.parseInt(c+"");   //解析一个字符串，并返回一个整数
                    lastindex++;
                    c=LastStr.charAt(lastindex);
                }
                lastindex++;
                stack.push(new Integer(result));   //操作数入栈
            }
            else
            {
                int b=stack.pop().intValue();
                int a=stack.pop().intValue();     //两个操作数出栈
                switch(c)
                {
                    case'+':
                        result=a+b;
                        break;

                    case'-':
                        result=a-b;
                        break;
                    case'*':
                        result=a*b;
                        break;
                    case'/':
                        result=a/b;
                        break;
                }
                stack.push(new Integer(result));
                lastindex++;
            }
        }
        return stack.pop().intValue();

    }

    public static void main(String[] args) {
        String expstr="3*(1+2)-6";
        String LastStr=convert(expstr);
        System.out.println("expstr="+expstr);
        System.out.println("LastStr="+LastStr);
        System.out.println("data= "+data(LastStr));
    }

}


