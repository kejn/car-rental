package pl.wroc.edu.model.helper;

/**
 * Let you define objects containing pair of different values.
 * 
 * @param <F>
 *            object type of the <b>first</b> field
 * @param <S>
 *            object type of the <b>second</b> field
 */
public class Pair<F, S> {
	
	public F first;
	public S second;
	
	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}
	
	@Override
	public String toString() {
		return "<first: " + first.toString() + "; second: " + second.toString() + ">";
	}

	public boolean equals(Pair<F, S> other) {
		return first.equals(other.first) && second.equals(other.second);
	}
	
	public static <F, S> Pair<F, S> makePair(F first, S second){
		return new Pair<>(first, second);
	}
}
