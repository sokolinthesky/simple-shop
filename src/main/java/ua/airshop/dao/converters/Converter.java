package ua.airshop.dao.converters;

public interface Converter<I, M> {
    M convert(I i);
}
