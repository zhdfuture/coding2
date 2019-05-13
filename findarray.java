import java.util.*;

//使得a+b+c=0，输出不重复数组
public class findarray {
    public static List<List<Integer>> findarray(int[] array) {  //一个数组，两个指针
        List<List<Integer>> ret = new ArrayList<>();
        if (array == null || array.length < 3) {
            return ret;
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; ) {
            int left=i+1;
            int right=array.length-1;
            while (left < right) {
                if ( array[i] + array[left] + array[right] == 0) {
                    ret.add(Arrays.asList(new Integer[]{array[i], array[left], array[right]}));
                    //移动到下一个位置，找下一组解
                    left++;
                    right--;
                    while (left < right && array[left] == array[left - 1]) { //从左向右找第一个与之前处理的数不同的数的下标

                        left++;
                    }
                    while (left < right && array[right] == array[right + 1]) {
                        right--;//从右向左找第一个与之前处理的数不同的数的下标
                    }
                } else if ((array[i] + array[left] + array[right]) < 0) {

                    left++;
                    while (left < right && array[left] == array[left - 1]) { //从左向右找第一个与之前处理的数不同的数的下标

                        left++;
                    }
                } else {
                    right--;
                    while (left < right && array[right] == array[right + 1]) {
                        right--;//从右向左找第一个与之前处理的数不同的数的下标
                    }
                }

            }
            i++;//指向下一个要处理的数
            while(i<array.length-2&&array[i]==array[i-1]){
                i++;
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        findarray f=new findarray();
        int[] array={1,4,5,6,7,6,5,3,3-1,-2,-4,-6,6,0};
        System.out.println(f.findarray(array));
    }
}
