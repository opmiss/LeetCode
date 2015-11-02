/**
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 */
var getHint = function(secret, guess) {
    var A=0, B=0;
    var map = {};
    for (var i=0; i<secret.length; i++){
        if (secret[i]===guess[i]) {
            A++;continue;
        }
        if (typeof map[secret[i]]==="undefined"){
            map[secret[i]] = 0;
        }
        map[secret[i]]++;
    }
    for (i=0; i<guess.length; i++){
        if (secret[i]===guess[i]) continue;
        if (typeof map[guess[i]]==="undefined") continue;
        if (--map[guess[i]]>=0) B++;
    }
    return [A, 'A', B, 'B'].join('');
};