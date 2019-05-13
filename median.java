import java.util.Scanner;

public class median {
    public double findMedianSortedArrays(int[] array1, int[] array2) {
        int i=0,j=0,k=0;
        int[] array3=new int[array1.length+array2.length];         //引入第三个数组
        while(i<array1.length&&j<array2.length){
            if(array1[i]<=array2[j]){
                array3[k++]=array1[i++];
            }
            else if(array1[i]>=array2[j]){
                array3[k++]=array2[j++];
            }

        }
        while(i<array1.length){   //只有一个数组中有元素
            array3[k++]=array1[i++];
        }
        while(j<array2.length){
            array3[k++]=array2[j++];
        }
        //若数组中的元素为偶数个
        if(array3.length%2==0){
            double result=(array3[array3.length/2]+array3[(array3.length-1)/2])/2.0;
            return result;
        }
        double result=array3[array3.length/2];
        return result;
    }

    public static void main(String[] args) {
     int[] array1={1,2,4,5,7,9};
     int[] array2={1,4,5,7,8};
     median m=new median();
        System.out.println( "中间值为：" +m.findMedianSortedArrays(array1,array2));
    }
}
