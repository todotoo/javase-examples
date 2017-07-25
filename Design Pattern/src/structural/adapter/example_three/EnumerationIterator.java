package structural.adapter.example_three;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * ö��������
 * 
 * @author wang.gang
 *
 * @param <E>
 */
public class EnumerationIterator<E> implements Iterator<E> {
	Enumeration<E> enumeration;

	public EnumerationIterator(Enumeration<E> enumeration) {
		this.enumeration = enumeration;
	}

	@Override
	public boolean hasNext() {

		return enumeration.hasMoreElements();
	}

	@Override
	public E next() {

		return enumeration.nextElement();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
