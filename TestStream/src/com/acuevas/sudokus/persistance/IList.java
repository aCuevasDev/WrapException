package com.acuevas.sudokus.persistance;

import java.io.File;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface IList extends Collection<File> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#stream()
	 */
	@Override
	default Stream<File> stream() {
		return Collection.super.stream();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#forEach(java.util.function.Consumer)
	 */
	@Override
	default void forEach(Consumer<? super File> arg0) {
		// TODO Auto-generated method stub
		Collection.super.forEach(new IStream.CustomConsumer<T>() {
			@Override
			public <T> void accept(T t) throws Exception {
				arg0.accept(t);
			}
		});
	}

}
