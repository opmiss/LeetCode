package java;

import java.util.Arrays;

public class P004_MedianTwoSorted {
	public double findMedianSortedArrays(int A[], int B[]) {
		if (A.length<B.length){
			return findMedian(A, 0, A.length, B, 0, B.length);
		}
		else return findMedian(B, 0, B.length, A, 0, A.length); 
	}
	double findMedian(int A[], int as, int ae, int B[], int bs, int be) {
		int al = ae - as;
		if (al==0) return M(B, bs, be);
		if (al==1) return findMedian(A[as], B, bs, be);
		if (al==2) return findMedian(A[as], A[as + 1], B, bs, be);
		double MA = M(A, as, ae), MB = M(B, bs, be);
		if (MA == MB) return MA;
		int cut=(al%2==1)?al/2:al/2-1;
		if (MA < MB) {
			as += cut;
			be -= cut;
		}else {
			ae -= cut;
			bs += cut;
		}
		return findMedian(A, as, ae, B, bs, be);
	}
	double findMedian(int a, int B[], int bs, int be) {
		int bl = be - bs;
		if (bl == 1) return M(a, B[bs]);
		if (bl == 2) return M(a, B[bs], B[bs + 1]);
		int bm = bs + bl / 2;
		if (bl % 2 == 0) return M(a, B[bm - 1], B[bm]);
		else return M(a, B[bm-1], B[bm], B[bm+1]);
	}

	double findMedian(int n1, int n2, int B[], int bs, int be) {
		int bl = be - bs;
		if (bl==1) return M(n1, n2, B[bs]);
		if (bl==2) return M(n1, n2, B[bs], B[bs + 1]);
		int bm = bs + bl / 2;
		if (bl % 2 == 0) return findMedian(n1, n2, B[bm-2], B[bm - 1], B[bm], B[bm+1]);
		else return findMedian(n1, n2, B[bm - 1], B[bm], B[bm+1]); 
	}
	
	double findMedian(int a1, int a2, int b1, int b2, int b3){
		if (a2<b2) return M(a2, b1, b2); 
		else if (a1>b2) return M(a1, b2, b3);
		else return b2; 
	}
	
	double findMedian(int a1, int a2, int b0, int b1, int b2, int b3){
		if (a2<b0) return M(b0, b1); 
		else if (a1>b3) return M(b2, b3);  
		else return M(a1, a2, b1, b2);
	}
	double M(int A, int B) {
		return ((double) A + (double) B) / 2.0;
	}
	double M(int A, int B, int C, int D) {
		int[] N = new int[] { A, B, C, D };
		Arrays.sort(N);
		return M(N[1], N[2]);
	}
	int M(int A, int B, int C) {
		return (A<B)?((B<C)?B:(A>C)?A:C):((B>C)?B:(A<C)?A:C); 
	}
	double M(int A[], int as, int ae) {
		int al = ae - as;
		if (al % 2 == 0) {
			int am1 = as + al / 2, am2 = am1 - 1;
			return ((double) A[am1] + (double) A[am2]) / 2.0;
		} else {
			int am = as + al / 2;
			return A[am];
		}
	}
}
