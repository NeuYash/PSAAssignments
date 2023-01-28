package edu.neu.coe.info6205.threesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of ThreeSum which follows the approach of dividing the
 * solution-space into N sub-spaces where each sub-space corresponds to a fixed
 * value for the middle index of the three values. Each sub-space is then solved
 * by expanding the scope of the other two indices outwards from the starting
 * point. Since each sub-space can be solved in O(N) time, the overall
 * complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
	/**
	 * Construct a ThreeSumQuadratic on a.
	 * 
	 * @param a a sorted array.
	 */
	public ThreeSumQuadratic(int[] a) {
		this.a = a;
		length = a.length;
	}

	public Triple[] getTriples() {
		List<Triple> triples = new ArrayList<>();
		for (int i = 0; i < length; i++)
			triples.addAll(getTriples(i));
		Collections.sort(triples);
		return triples.stream().distinct().toArray(Triple[]::new);
	}

	/**
	 * Get a list of Triples such that the middle index is the given value j.
	 *
	 * @param j the index of the middle value.
	 * @return a Triple such that
	 */
	public List<Triple> getTriples(int j) {
		List<Triple> triples = new ArrayList<>();
		// FIXME : for each candidate, test if a[i] + a[j] + a[k] = 0.
		/*int i = 0;
		for (i = 0; i < length - 2; i++) {
			if (i == 0 || (i > 0 && a[i] != a[i - 1])) {
				int low = i + 1;
				int high = length - 1;
				int sum = 0 - a[i];

				while (low < high) {

					if ( ( (a[low] + a[high]) == sum) && j == low) {
						// count++;
						// triple found
						triples.add(new Triple(a[i], a[low], a[high]));
						System.out.println("pair found :" + Arrays.asList(a[i], a[low], a[high]));
						// if there are duplicate entries in array at low end
						while (low < high && (a[low] == a[low + 1])) {
							low++;
						}
						// if there are duplicate entries in array at high end
						while (low < high && (a[high] == a[high - 1])) {
							high--;
						}
						// when match found check for next match
						low++;
						high--;

					} else if (a[low] + a[high] > sum) { // if total sum is crossing target then decrement high
						high--;
					} else { // if total sum less than target then increment low.
						low++;
					} // else

				} // first while

			} // if
			
		} // for
		*/
		
		int low=0, high=a.length-1;
		
		while(low<j && high>j) {
			
			int currentsum=a[low]+a[j]+a[high];
			
			if(currentsum==0) {
				triples.add(new Triple(a[low], a[j], a[high]));
				low++;
				high--;
			}else if(currentsum<0) {
				low++;
			}else {
				high--;
			}
			
		}//while
			// END

		return triples;
	}

	private final int[] a;
	private final int length;
}
