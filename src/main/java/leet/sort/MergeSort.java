package leet.sort;

import com.google.gson.Gson;

/**
 * 归并排序
 * @author zhangjinchun
 * @date 2020/9/5
 */
public class MergeSort {

    public static void merSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr,0, arr.length-1, tmp);
    }

    private static void mergeSort(int[] arr,int low,int high,int[] tmp){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid,tmp); //对左边序列进行归并排序
            mergeSort(arr,mid+1,high,tmp);  //对右边序列进行归并排序
            merge(arr,low,mid,high,tmp);    //合并两个有序序列
        }
    }

    private static void merge(int[] arr,int low,int mid,int high,int[] tmp){
        int i = 0;
        int j = low,k = mid+1;  //左边序列和右边序列起始索引
        while(j <= mid && k <= high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t=0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 8, 3, 2, 6, 8, 5, 9};
        merSort(nums);
        System.out.println(new Gson().toJson(nums));
    }
}
