/**
 * @param {number} num
 * @returns {string}
 */
var intToRoman = function(num) {
    var s=""; var m;
    m = Math.floor(num/1000);
    s = s.concat(convert(m, "M", "E", "E"));
    num-=m*1000;
    m = Math.floor(num/100);
    s = s.concat(convert(m, "C", "D", "M"));
    num-=m*100;
    m = Math.floor(num/10);
    s = s.concat(convert(m, "X", "L", "C"));
    num-=m*10;
    s = s.concat(convert(num, "I", "V", "X"));
    return s;
};

var convert = function(d, one, five, ten){
    var s="";
    if (d===0) return s;
    if (d<4) for (var i=0; i<d; i++) s=s.concat(one);
    else if (d==4) {s=s.concat(one); s=s.concat(five);}
    else if (d<9){s=s.concat(five); for (i=5; i<d; i++) s=s.concat(one); }
    else {s=s.concat(one); s=s.concat(ten); }
    return s;
};