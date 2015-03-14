/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function(s, p) {
    if (p.length===0) {
        if (s.length===0) return true;
        else return false;
    }
    if (s.length===0){
        if (p.length>1 && p[1]==='*') return isMatch(s, p.substring(2));
        else return false;
    }
    if (p.length>1&&p[1]==='*'){
        if (isMatch(s, p.substring(2))) return true;
        for (var i=0; i<s.length && (p[0]==='.'||p[0]===s[i]); i++){
            if (isMatch(s.substring(i+1), p.substring(2))) return true;
        }
        return false;
    }
    if (p[0]==='.'||s[0]===p[0]) return isMatch(s.substring(1), p.substring(1));
    return false;
};