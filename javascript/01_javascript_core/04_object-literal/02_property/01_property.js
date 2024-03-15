/* 01.property */
/* 객체는 프로퍼티의 집합이며, 프로퍼티는 키와 값으로 구성 된다. */

var obj = {
    normal: 'normal value',
    '@ s p a c e @': 'space value',
    '':'',
    0:1 ,
    var: 'var',
    normal: 'new value'
};

/* 동적 프로퍼티 추가 구문(기존에 없는 프로퍼티에 접근하면 프로퍼티가 생성된다.) */
obj.test = 'test value';

// var key = 'test';
// obj[key] = 'test value';

console.log(obj);