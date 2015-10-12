/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    var p = [];
    for (var i=0; i<s.length; i++){
        p.push([]);
    }
    var start=0, end=0;
    for (var k=0; k<s.length; k++){
        for (i=0; i<s.length-k; i++){
            if (k===0) p[i][i] = 1;
            else if (s.charAt(i)!==s.charAt(i+k)){
                p[i][i+k]=0;
            }else if (k===1){
                p[i][i+k]=2;
                if (end-start+1<2) {
                    start = i; end = i+k;
                }
            }else {
                p[i][i+k] = p[i+1][i+k-1]>0?p[i+1][i+k-1]+2:0;
                if (end-start+1<p[i][i+k]){
                    start = i; end = i+k;
                }
            }
        }
    }
    return s.substring(start, end+1);
};