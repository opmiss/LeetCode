var lengthOfLongestSubstring = function(s) {
    var map = {};
    var i=0, j=0;
    var leng=0;
    while (j<s.length){
        if (typeof map[s[j]]==="undefined"){
            map[s[j]]=1; j++;
            leng = Math.max(leng, (j-i));
        }else {
            delete map[s[i]];
            i++;
        }
    }
    return leng;
};