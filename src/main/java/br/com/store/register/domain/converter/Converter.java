package br.com.store.register.domain.converter;

import java.util.List;

public interface Converter<T, R> {

    R convertToDto(T t);

    List<R> convertListToDto(List<T> t);

    T convertToEntity(R r);

}
