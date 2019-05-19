import java.util.Date;
public class Reflect {
    public static void threadGetClass() throws ClassNotFoundException {
        Date date=new Date();// 创建对象
        //class 关键字   Class 类型
        Class class1=date.getClass();
        System.out.println(class1);
        System.out.println(date instanceof Date);  //若date是Date类，返回true,否则返回false


        Class class2=Date.class;   //通过属性来获取对象
        System.out.println(class2);

        //通过Class.forName  类的全限定名
        try{
            Class class3=Class.forName("java.util.Date");
            System.out.println(class3);

            System.out.println("=====>");

            //当前三个Class对象都是描述iava.util.Date
            System.out.println(class1==class2);
            System.out.println(class2==class3);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
          }

    public static void main(String[] args) {
        Class dateClass=Date.class;
        try{
            Object object=dateClass.newInstance();
            Date date= (Date) object;
            System.out.println(object);
            System.out.println(object instanceof Date);
            System.out.println(object.getClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
