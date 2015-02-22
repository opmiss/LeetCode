/**
 * @param {string} digits
 * @return {string[]}
 */
var letters = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz'];
var letterCombinations = function(digits) {
    if (digits.length<1) return [];
    output = [''];
    for (var i=0; i<digits.length; i++){
        var str = letters[digits[i].charCodeAt(0)-'0'.charCodeAt(0)];
        var newoutput = [];
        output.forEach(function(e){for (var c=0; c<str.length; c++)newoutput.push(e+str[c])});
        output = newoutput;
    }
    return output;
};