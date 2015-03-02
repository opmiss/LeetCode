/**
 * @param {string} s
 * @return {number}
 */
var map = {};
map['I'] = 1;
map['V'] = 5;
map['X'] = 10;
map['L'] = 50;
map['C'] = 100;
map['D'] = 500;
map['M'] = 1000;

var romanToInt = function(s) {
    if (s.length<1) return 0;
    var prev = map[s[0]];
    var res = 0;
    for (var i=1; i<s.length; i++){
        var cur = map[s[i]];
        if (prev<cur) res -= prev;
        else res+=prev;
        prev = cur;
    }
    return res+prev;
};