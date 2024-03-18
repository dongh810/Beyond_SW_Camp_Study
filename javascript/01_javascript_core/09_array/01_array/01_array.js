/* 01. array */
/* 배열은 여러개의 값을 순차적으로(인덱스를 활용하여) 나열한 자료구조이다. */

/* 1. 배열 리터럴을 통해 배열 생성 */
const arr = ['바나나', '복숭아', '키위'];

console.log(arr);
console.log(arr.length);

/* 2. 배열 빌트인 생성자 함수 */
const arr2 = Array();
console.log(arr2);
console.log(arr2.length);

const arr3 = Array(10);
console.log(arr3);
console.log(arr3.length);

const arr4 = Array(1,2,3);
console.log(arr4);

for(let i=0;i< arr4.length;i++) {
    console.log(arr4[i]);
}

console.log(typeof arr4);