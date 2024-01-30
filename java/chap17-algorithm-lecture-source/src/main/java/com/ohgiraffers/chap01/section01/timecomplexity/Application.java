package com.ohgiraffers.chap01.section01.timecomplexity;

import java.util.Arrays;

/* 수업목표. 시간복잡도를 이해할 수 있다. */
/* 필기.
 *  알고리즘 실행 시 입력 값이 증가함에 따라 걸리는 시간의 증가도를 나타낸다.
 * */
public class Application {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 15, 4, 9, 10, 7};
        System.out.println(getFirst(arr));
        System.out.println(binarySearch(arr, 9));
        System.out.println(Arrays.toString(reverse(arr)));
    }

    /* 설명. 상수 시간 0(1) */
    private static int getFirst(int[] arr) {
        return arr[0];
    }

    /* 설명. 로그시간 0(log n) */
    private static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
//        int left = 0;
//        int right = arr.length;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /* 설명. 선형 시간 0(n) */
    public static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            reversed[arr.length - i - 1] = arr[i];
        }
        return reversed;
    }

    /* 설명. 지수 시간 0(n^2) */
    public static int fibonacci(int n) {
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

}
