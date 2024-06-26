/* 
  data-type은 값의 종류를 말하며 자바스크립트(ES6)는 7개의 데이터타입
  (number, string, boolean, null, undefined(아예 값이 없는거), null(주소값이 없는것), symbol, object(함수를 객체로 다룬다))을 제공한다.
 */

/* 01. 숫자타입 */
/* 정수, 실수, 음수 모두 숫자(number)타입이다. (내부적으로는 실수로만 인식) */
var integer = 10;
var double = 5.5;
var negative = -10;

console.log(typeof integer);
console.log(typeof double);
console.log(typeof negative);

console.log(10 / 4);

/* 
  숫자 타입은 추가적으로 세가지 특별한 값도 표현할 수 있다.
  Infinity: 양의 무한대
  -Infinity: 음의 무한대
  NaN: 산술 연산 불가(not-a-number)
 */
console.log(10 / 0);
console.log(10 / -0);
console.log(1 * '문자열');  // 문자열은 홀따옴표(') 또는 쌍따옴표(") 모두 가능하다.
// SAI: 세미콜론을 자동으로 넣어주는 기능이 있다. but 자동으로 달아주지 않을때도 있으니 달도록 하자.
