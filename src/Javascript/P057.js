/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @param {Interval} newInterval
 * @return {Interval[]}
 */
var insert = function(intervals, newInterval) {
	if (intervals.length<1) return [newInterval];
	var search = function(left, right){
			//find the left most interval that overlap with new interval, return its index
		if (newInterval.end<intervals[left].start) {
			return left-1;
		}
		if (newInterval.start>intervals[right].end) {
			return right+1;
		}
		if (left===right||left===right+1) {
			return left;
		}
		var mid = (left+right)>>1;
		if (newInterval.start>intervals[mid].end){
			return search(mid+1, right);
		}else {
			return search(left, mid);
		}
	};
	var i = search(0, intervals.length-1);
	if (i===-1) {intervals.unshift(newInterval); return intervals; }
	if (i===intervals.length) {intervals.push(newInterval); return intervals; }
	var p = i;
	for (; i<intervals.length; i++){
		if (newInterval.end<intervals[i].start) break;
		if (newInterval.start>intervals[i].end) {p++;  break;}
		newInterval.start = (newInterval.start<intervals[i].start)?newInterval.start:intervals[i].start;
		newInterval.end = (newInterval.end<intervals[i].end)?intervals[i].end:newInterval.end;
	}
	intervals.splice(p, i-p, newInterval);
	return intervals;
};