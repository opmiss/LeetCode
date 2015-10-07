package java;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class P284_PeekingIterator implements Iterator<Integer> {
 Integer next = null; 
 Iterator<Integer> itr = null; 
	public P284_PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    itr = iterator; 
	}
 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     if (next!=null) return next; 
     next = itr.next(); 
     return next; 
	}
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (next!=null) {
	        Integer res = next; 
	        next=null; 
	        return res; 
	    }
	    return itr.next();  
	}
	@Override
	public boolean hasNext() {
	    return (next!=null||itr.hasNext());             
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}
}
