/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if (numRows===1) return s;
    var rows = [];
    for (var i = 0; i<numRows; i++){
        rows.push([]);
    }
    var rid = 0;
    var down = true;
    for (var i=0; i<s.length; i++){
        rows[rid].push(s[i]);
        if (down) {
            rid++;
            if (rid>=numRows){
                rid = numRows-2;
                down = false;
            }
        }else {
            rid--;
            if (rid<0){
                rid = 1;
                down = true;
            }
        }
    }
    return (rows.map(function(r){ return r.join('');})).join('');
};