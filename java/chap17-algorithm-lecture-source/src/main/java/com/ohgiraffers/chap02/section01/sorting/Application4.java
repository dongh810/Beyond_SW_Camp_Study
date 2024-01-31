package com.ohgiraffers.chap02.section01.sorting;

import java.util.Scanner;

/* 수업목표. 퀵 정렬을 이해할 수 있다. */
/* 필기.
 *  퀵 정렬(Quick Sort)
 *  기준값(pivot)을 선정해 해당 값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해서 정렬하는 것으로
 *  병합 알고리즘과 함께 실제 정렬 알고리즘으로 많이 활용되고 있다.
 *  시간 복잡도는 O(nlogn) 이지만 최악의 경우는 O(n^2)이다.
* */

public class Application4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        solution(0, arr.length - 1, arr);

        for(int i:arr){
            System.out.print(i + " ");
        }
    }

    public static void solution(int lo,int hi, int[] arr){
        if(lo >= hi) {
            return;
        }

        System.out.println("---- process call----");
        int pivot = process(lo, hi, arr);
        System.out.println("lo = "+lo+", hi = "+ hi + ", pivot = "+pivot);
        System.out.println("---- process end----");
        solution(lo,pivot,arr);
        solution(pivot+1,hi,arr);
    }

    /* 설명. lo에 해당하는 포인터와 hi에 해당하는 포인터를 최대한 움직여 pivot을 반환하는 메소드 */
    private static int process(int left, int right, int[] arr) {
        int lo = left -1;
        int hi = right + 1;
        int pivot = arr[(left + right) / 2];
        while(true) {

            /* 설명. pivot위치에 있는 값보다 작은 값을 가리키면 lo 포인터를 증가한다. */
            do {
                lo++;
            } while(arr[lo] < pivot);

            /* 설명. pivot위치에 있는 값보다 크면서 lo 포인터의 위치보다 크거나 같은 위치이면 감소한다. */
            do {
                hi--;
            } while (arr[hi] > pivot && lo <= hi);

            /* 설명. lo포인터의 위치가 hi포인터를 앞지르려고 하면 hi위치를 반환한다. (분할 기준 반환) */
            if(lo >= hi) {
                return hi;
            }
            System.out.println("111111111111111");
            System.out.println("lo = "+lo+", hi = "+ hi + ", pivot = "+pivot);
            System.out.println("111111111111111");
            swap(arr, lo, hi);
        }
    }

    /* 설명. 전달된 배열과 인덱스들을 바탕으로 위치를 스왑(바꾸는)하는 메소드 */
    private static void swap(int[] arr, int lo, int hi){
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}
