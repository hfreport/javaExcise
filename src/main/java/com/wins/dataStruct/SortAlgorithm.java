package com.wins.dataStruct;

/**
 * 常见排序算法
 */
public class SortAlgorithm {

    //插入排序
    public static void insertSort(int[] ars) {
        for (int i = 0; i < ars.length; i++) {
            for (int j = i; j > 0; j--) {
                //升序排序
                if (ars[j-1] > ars[j]) {
                    //待排序的元素
                    int temp = ars[j];
                    ars[j] = ars[j-1];
                    ars[j-1] = temp;
                }
            }
        }
    }


    //希尔排序
    public static void xierSort(int[] data) {
    }

    //简单选择排序
    public static void simpleSort(int[] data){

        for (int i = 0; i < data.length; i++) {
            //保存待比较的数据
            int temp = data[i];
            //交换数据
            for (int j = i; j < data.length; j++) {
                if (data[j] < temp) {
                    int t = data[j];
                    data[j] = temp;
                    temp = t;
                }
            }
            data[i] = temp;
        }

    }

    public static void bubbleSort(int[] data) {

        for (int i = 0; i < data.length; i++) {

            for (int j = 0; j < data.length - i; j++) {

            }


        }



    }









    public static void main(String[] args) {

        int[] ars = new int[]{2,4,7,9,10,1,3};

//        insertSort(ars);

        simpleSort(ars);

        for (int i : ars) {

            System.out.println(i);
        }
    }




}
