package com.ohgiraffers.section02.set.run;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        Set<String> tSet = new TreeSet<>();
        tSet.add("ramen");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("friedEgg");
        tSet.add("soup");
        System.out.println("tSet = " + tSet);

        /* 설명. 과제 중복되지 않는 번호를 발생시켜 로또 번호 발생기 만들기(TreeSet 사용하지 않고) */

        Set<Integer> lotto = new TreeSet<>();

        /* 설명. 1부터 45까지의 6자리 중복되지 않는 난수를 발생하며 값 저장 */
        while(lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45) +1);
        }

        /* 설명. 출력 시에는 오름차순으로 출력 되도록 작성 */
        System.out.println("lotto: " + lotto);

    }
}
