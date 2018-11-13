package com.jonathanq.data;

public class ZipRange {
	private int first;
	private int second;
	
	public ZipRange(int first, int second) {
		this.first = first;
		this.second = second;
	}
	
	public int getFirst() {
		return first;
	}
	
	public int getSecond() {
		return second;
	}
	
	/**
	 * Checks if there exists an intersection for the current ZipRange 
	 * and an other ZipRange
	 * 
	 * @param other A ZipRange that we would like to check for intersection
	 * @return true if intersection found, else false
	 */
	public boolean intersect(ZipRange other) {
		if (other == null) {
			return false;
		}
		// Case 1: This ZipRange completely contains the other ZipRange
		if (this.first <= other.getFirst()
				&& this.second >= other.getSecond()) {
			return true;
		}
		// Case 2: The other ZipRange completely contains this ZipRangge
		if (this.first >= other.getFirst()
				&& this.second <= other.getSecond()) {
			this.first = other.getFirst();
			this.second = other.getSecond();
			return true;
		}
		// Case 3: Intersection with this ZipRange having the smaller/equal
		// first value and the other ZipRange having the larger/equal second value
		if (this.first <= other.getFirst()
				&& other.getFirst() <= this.second
				&& this.first <= other.getSecond()) {
			this.second = other.getSecond();
			return true;
		}
		// Case 4: Intersection with this ZipRange having the larger/equal
		// first value and the other ZipRange having the smaller/equal second value
		if (this.first >= other.getFirst()
				&& other.getSecond() >= this.first
				&& this.second >= other.getSecond()) {
			this.first = other.getFirst();
			return true;
		}
		// Case 5: No intersection
		return false;
	}
	
	@Override
	public String toString() {
		return "[" + first + "," + second +"]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ZipRange)) {
			return false;
		}
		ZipRange other = (ZipRange) o;
		return this.first == other.getFirst()
				&& this.second == other.getSecond();
	}
	
	@Override
	public int hashCode() {
		int hash = 13;
		hash = 31 * hash + first;
		hash = 31 * hash + second;
		return hash;
	}
}
