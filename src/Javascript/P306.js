/**
 * @param {string} num
 * @return {boolean}
 */
var isAdditiveNumber = function(inputnum) {
	var move = function(que, num){
			// console.log(que);
		if (num.length<1) return false;
		else if (que.length===2){
			if (num[0]!=='0'){
				for (var k=0; k<num.length; k++){
					que.push(num.substring(0, k+1));
					if (Number(que[2])===Number(que[1])+Number(que[0])){
						if (k===num.length-1) return true;
						var left = que.shift();
						if (move(que, num.substring(k+1))) return true;
						que.unshift(left);
					}
					else if (Number(que[2])>Number(que[1])+Number(que[0])){
						que.pop();
						break;
					}
					que.pop();
				}
				return false;
			}else{
				que.push(num[0]);
				if (Number(que[2])===Number(que[1])+Number(que[0])){
					if (num.length===1) return true;
					var left = que.shift();
					if (move(que, num.substring(1))) return true;
					que.unshift(left);
				}
				que.pop();
				return false;
			}
		}
		else if (que.length===1){
			if (num[0]!=='0'){
				for (var j=0; j<num.length/2; j++){
					que.push(num.substring(0, j+1));
					if (move(que, num.substring(j+1))) return true;
					que.pop();
				}
				return false;
			}else{
				que.push(num[0]);
				if (move(que, num.substring(1))) return true;
				que.pop();
				return false;
			}
		}
		else {
			if (num[0]!=='0'){
				for (var i=0; i<num.length/2; i++){
					que.push(num.substring(0, i+1));
					if (move(que, num.substring(i+1))) return true;
					que.pop();
				}
				return false;
			}else{
				que.push(num[0]);
				if (move(que, num.substring(1))) return true;
				que.pop();
				return false;
			}
		}
	};
	return move([], inputnum);
};