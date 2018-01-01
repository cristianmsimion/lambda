package cristi.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * @author cristian
 *
 */
@FunctionalInterface
public interface CristiFunction {

	
	/**
	 * @param t
	 * @return
	 */
	Integer compute(Integer t);

	default CristiFunction sum10 () {
		CristiFunction cf = f -> f + 10;
		return cf;
	}

	default CristiFunction modulo3 () {
		CristiFunction cf = f -> f % 3;
		return cf;
	}
}
