/**
 * @param {string} s
 * @return {boolean}
 */
var map = {'(':')', '{':'}', '[':']'};
var isValid = function(s) {
    var stack = [];
    for (var i=0; i<s.length; i++){
        if (typeof map[s[i]]!=="undefined"){
            stack.push(s[i]);
        }else {
            if (s[i]!==map[stack.pop()]) return false;
        }
    }
    return (stack.length<1);
};