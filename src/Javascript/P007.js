/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    var neg = (x<0);
    var str = x.toString().split('').reverse().join('');
    var res = (neg)?(0-Number(str.substring(0, str.length-1))):(Number(str));
    if (res>2147483647) return 0;
    if (res<-2147483648) return 0;
    return res;
    
};