/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if (x<0) return false;
    if (x<10) return true;
    if (x%10===0) return false;
    var tail = x%10;
    x = Math.floor(x/10);
    while (tail<=x){
        if (tail===x || tail===Math.floor(x/10)){
            return true;
        }
        tail = tail*10+x%10;
        x = Math.floor(x/10);
    }
    return false;
};