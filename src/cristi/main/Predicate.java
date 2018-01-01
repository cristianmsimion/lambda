package cristi.main;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author cristian
 *
 * @param <T>
 */
@FunctionalInterface
public interface Predicate<T> {

	
	/**
	 * @param t
	 * @return
	 */
	public boolean test(T t);

	/**
	 * @param other
	 * @return
	 */
	default Predicate<T> and(Predicate<T> other) {
		return h -> {
			boolean test = test(h);
			boolean test2 = other.test(h);
			return test && test2;
		};
	}

	default <t> Collection<T> test1(T ob) {
		Collection<T> c = new ArrayList<T>();
		c.add(ob);
		return c;
	}

	default Collection<T> test2(T ob) {
		Collection<T> c = new ArrayList<T>();
		c.add(ob);
		return c;
	}

}
