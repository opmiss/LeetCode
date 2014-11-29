package com.leetcode.problems.math;

import java.util.HashMap;

/* 
 * Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line.
 */

public class MaxPointsLine {
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	class Pt extends Point{
		Pt(){super();}
		Pt(int a, int b){super(a, b); } 
		Pt(Point p){x=p.x; y=p.y; }
		
		@Override
		public boolean equals(Object p){
			if (p==null) return false; 
			if (this==p) return true; 
			if (!(p instanceof Pt)) return false; 
			Pt pt = (Pt)p; 
			if (pt.x==x && pt.y==y) return true; 
			return false; 
		}
		@Override
		public int hashCode(){
			return x*17+y*37; 
		}
	}
	
	class Line{
		int a, b, c; 
		Line(int x, int y, int z){
			a=x; b=y; c=z; 
		}
		@Override
		public boolean equals(Object l){
			if (l==null) return false; 
			if (!(l instanceof Line)) return false; 
			Line li=(Line)l; 
			if (li.a==a && li.b==b && li.c==c) return true; 
			return false; 
 		}
		@Override
		public int hashCode(){
			return a*17+b*37+c*53; 
		}
	}
	
	HashMap<Line, Integer> linemap = new HashMap<Line, Integer>(); 
	HashMap<Pt, Integer> ptmap = new HashMap<Pt, Integer>(); 
	int maxcount=2; 
	
	public void insertPt(Pt pt){
		Integer c = ptmap.get(pt); 
		if (c==null) c=0; 
		ptmap.put(pt, ++c); 
	}
	
	public void buildPtmap(Point[] points){
		ptmap.clear();  
		for (int i=0; i<points.length; i++){
			insertPt(new Pt(points[i])); 
		}
	}
	
	public void insertLine(Line line, Pt pi, Pt pj){
		Integer c = linemap.get(line);
		if (c==null) c=ptmap.get(pi); 
		c+=ptmap.get(pj);
		maxcount = Math.max(maxcount, c); 
		linemap.put(line, c); 
	}
	
	public int gcd(int a, int b){
		if (b==0) return a; 
		return gcd(b, a%b); 
	}
	
	public void buildLinemap(){
		maxcount=2; 
		Pt[] pts = (Pt[])ptmap.keySet().toArray(); 
		for (int i=0; i<pts.length; i++){
			linemap.clear(); 
			for (int j=i+1; j<pts.length; j++){
				int dx = pts[i].x-pts[j].x; 
				int dy = pts[i].y-pts[j].y;
				if (dx<0) {dx = -dx; dy = -dy; }
				int gd = gcd(dx, dy);
				dx/=gd; 
				dy/=gd; 
				int c = pts[i].y*dx - pts[i].x*dy; 
				Line line = new Line(dx, dy, c);
				insertLine(line, pts[i], pts[j]); 
			}
		}
	}
	
	public int maxPoints(Point[] points){
		if (points.length<3) return points.length; 
		buildPtmap(points); 
		if (ptmap.keySet().size()<3) return points.length; 
		buildLinemap(); 
		return maxcount;
	}
}
