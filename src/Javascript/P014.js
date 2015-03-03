/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (strs.length<1) return '';
    if (strs.length===1) return strs[0];
    var first = strs[0];
    var prefix = '';
    for (var p=0; p<strs[0].length; p++){
        for (var i=1; i<strs.length; i++){
            if (p<strs[i].length && strs[i][p]===first[p]) continue;
            else return prefix;
        }
        prefix+=first[p];
    }
    return prefix;
};