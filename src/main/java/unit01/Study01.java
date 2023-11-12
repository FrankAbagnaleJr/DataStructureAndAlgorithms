package unit01;

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
        int i = queryNum(num, 125);
        System.out.println(i);


    }

    /**
     *
     * @param num 要查找的数组
     * @param key 要查找的值
     * @return
     */
    public static int queryNum(int[] num,int key) {
        int start = 0;            //开始索引
        int end = num.length - 1; //结束索引
        while (start <= end) {                      //如果开始索引大于结束索引，那么就没找到，返回-1
            int middle = (start + end) / 2;         //中间数索引等于 （开始+结束） /2
            if (key > num[middle]) start = middle + 1;  //如果查找的树大于中间数，那么从右边开始找
            if (key < num[middle]) end = middle - 1;    //如果查找的树小于中间数，那么从左边开始找
            if (key == num[middle]) return num[middle];  //如果查找的树等于中间数，那么就找到了，返回
        }
        return -1; //开始索引大于结束索引了，就说明没找到，返回-1
    }
}
