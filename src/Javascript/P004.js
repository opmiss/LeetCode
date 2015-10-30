/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */ 
 var median = function(nums){
	 if (nums.length<1) throw err;  
	 if (nums.length%2===0){
		 var m = nums.length/2; 
		 return (nums[m]+nums[m-1])/2;  
	 }
	 return nums[Math.floor(nums.length/2)]; 
 }

 var findMedianSortedArrays = function(nums1, nums2){ 
	 //make sure that nums1.length >= nums2.length
	 //console.log("nums1:", nums1); 
	 //console.log("nums2:", nums2); 
	 if (nums1.length<nums2.length){
		 return findMedianSortedArrays(nums2, nums1); 
	 }
	 if (nums2.length<1){
		 return median(nums1);  
	 }
	 if (nums2.length===1){
		 if (nums1.length<4){
			 var nums = nums1.concat(nums2);
			 nums.sort(function(a, b){return a-b;});
			 //console.log("sorted", nums); 
			 return median(nums); 
		 }
		 var m = Math.floor(nums1.length/2); 
		 if (nums1.length%2===0){
			 return findMedianSortedArrays(nums1.slice(m-1, m+1), nums2); 
		 }
		 return findMedianSortedArrays(nums1.slice(m-1, m+2), nums2); 
	 }
	 if (nums2.length===2){
		 if (nums1.length<5){
			 var nums = nums1.concat(nums2);
			 nums.sort(function(a, b){return a-b;}); 
			 return median(nums); 
		 }
		 var m = Math.floor(nums1.length/2);
		 if (nums1.length%2===0){
			 return findMedianSortedArrays(nums1.slice(m-2, m+2), nums2); 
		 }
		 return findMedianSortedArrays(nums1.slice(m-1, m+2), nums2); 
	 }
	 var m1 = median(nums1); 
	 var m2 = median(nums2);
	 if (m1===m2) return m1;
	 var cut = Math.floor((nums2.length-1)/2); 
	 if (m1<m2){
		 return findMedianSortedArrays(nums1.slice(cut, nums1.length), nums2.slice(0, nums2.length-cut)); 
	 }
	 return findMedianSortedArrays(nums1.slice(0, nums1.length-cut), nums2.slice(cut, nums2.length)); 
 }

console.log(findMedianSortedArrays([10], [1, 2, 3, 4, 5, 6, 7, 8, 9]));
