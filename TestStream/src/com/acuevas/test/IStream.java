package com.acuevas.test;

import java.io.File;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface IStream extends Stream<File> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.stream.Stream#forEach(java.util.function.Consumer)
	 */
	@Override
	default void forEach(Consumer<? super File> arg0) {
		new CustomConsumer<File>() {

			@Override
			public void accept(File t) throws Exception {
				arg0.accept(t);
			}
		};

	}

	public interface CustomConsumer<T> {

		void accept(T t) throws Exception;
	}
}