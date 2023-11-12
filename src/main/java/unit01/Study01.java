package unit01;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @auther: jijin
 * @date: 2023/11/12 10:41 周日
 * @project_name: DataStructureAndAlgorithms
 * @version: 1.0
 * @description 二分查找算法
 */
public class Study01 {
    public static void main(String[] args) {
        int[] num = {2,5,12,35,45,68,88,92,99,101,125};
        int i = queryNum(num, 8);
        System.out.println(i);


    }

    /**
     * TODO 基础版
     * @param num 要查找的数组
     * @param target 要查找的值
     * @return
     */
    public static int queryNum(int[] num,int target) {
        int start = 0;            //开始索引
        int end = num.length - 1; //结束索引
        while (start <= end) {                      //如果开始索引大于结束索引，那么就没找到，返回-1
            /**
             TODO  中间数索引等于（开始+结束）/2,如果索引非常大超过了int范围，则会出现负数，
             // 要用>>>1 无符号向右位移1位表示除以二
             // >>>1 是带符号右移1位，如果是负数位移会出现不正确的值，例如 -8 >>> 1 = 2147483644
             // >>1 负数要使用无符号位移，例如 -8 >>> 1 = -4
             */
            int middle = (start + end) >>> 1;
            if (target < num[middle]) end = middle + 1;  //如果查找的树大于中间数，那么从右边开始找
            if (num[middle] < target ) start = middle - 1;    //如果查找的树小于中间数，那么从左边开始找
            if (target == num[middle]) return num[middle];  //如果查找的树等于中间数，那么就找到了，返回
        }
        return -1; //开始索引大于结束索引了，就说明没找到，返回-1
    }

    /**
     * TODO 高级版（代码逻辑少了一点，速度稍快）
     * @param num
     * @param target
     * @return
     */
    public static int queryNum2(int[] num,int target) {
        int start = 0;
        int end = num.length ;  //FIXME 修改1处  结束索引作为边界，一定不是要查找的数
        while (start < end) {   //FIXME 修改2处
            int middle = (start + end) >>> 1;
            if (target < num[middle]) end = middle; //FIXME 修改3处
            if (num[middle] < target ) start = middle - 1;
            if (target == num[middle]) return num[middle];
        }
        return -1;
    }


    /**
     * TODO 减少的了循环次数，把判断是否是要找到的数放到循环外，之前循环内判断3次，这次只判断1次。缺点是必须走完循环才能判断是否查找到了。
     * TODO 最好最坏情况下，时间复杂度都是 O(log(n))
     * @param num
     * @param target
     * @return
     */
    public static int queryNum3(int[] num,int target) {
        int start = 0;
        int end = num.length ;
        // FIXME 循环用来缩小边界，一直缩到要查找数的两边
        while (1 < end - start) {
            int middle = (start + end) >>> 1;
            if (target < num[middle]) {  // FIXME 如果数再左边，则缩小右边界
                end = middle;
            } else {           // FIXME 如果数再右边，则缩小左边界
                start = middle;
            }
        }
        // FIXME 然后再判断中间数是否是要查找的数，如果是返回，不是则返回-1
        if (target == num[start]) {
            return num[start];
        } else {
            return -1;
        }
    }
}
