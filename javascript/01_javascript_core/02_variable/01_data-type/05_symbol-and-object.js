/* 05. symbol-and-object */

/* symbol 타입 */
/*

 */

// var key1 = 'key';
// var key2 = 'key';
var key1 = Symbol('key');
var key2 = Symbol('key');
console.log(key1);
console.log(key2);

/* 리터럴 객체 생성 */
var obj = {};

obj[key1] = 'value1';       // => {key: 'value1'}
obj[key2] = 'value2';       // => {key: 'value2'}

console.log(obj);
