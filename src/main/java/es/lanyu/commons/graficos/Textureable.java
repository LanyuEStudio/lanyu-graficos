package es.lanyu.commons.graficos;

import es.lanyu.commons.io.AsociableConArchivo;

public interface Textureable<T> extends AsociableConArchivo {

    T getTextura();

}
