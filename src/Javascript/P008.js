/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function(str) {
    str=str.replace(/^\s+/, '');
    console.log("after trim:", str);
    var num = '';
    for (var i in str){
        if (str.charCodeAt(i)>="0".charCodeAt(0) && str.charCodeAt(i)<="9".charCodeAt(0)){
            num+=str[i];
        }else if (num.length>0){
            break;
        }else if (str.charCodeAt(i)==="-".charCodeAt(0)){
            num+='-';
        }else if (str.charCodeAt(i)==="+".charCodeAt(0)){
            num+='+';
        }else break;
    }
    if (isNaN(num)) return 0;
    num = Number(num);
    if (num<-2147483648) return -2147483648;
    if (num>2147483647) return 2147483647;
    return num;
};

console.log(myAtoi(" - 010")); 
