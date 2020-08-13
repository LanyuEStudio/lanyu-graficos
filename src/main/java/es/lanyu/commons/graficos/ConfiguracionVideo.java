package es.lanyu.commons.graficos;

import es.lanyu.commons.config.ConfiguracionBase;
import es.lanyu.commons.config.Propiedades;

public class ConfiguracionVideo extends ConfiguracionBase {
    float velocidadZoom = 1.8f;
    float maximoZoom = 1.1f;
    String idCamaraActivada = "camaraActivada";

    public ConfiguracionVideo(Propiedades propiedades) {
        super(propiedades);
    }

    public float getVelocidadZoom() {
        return velocidadZoom;
    }

    public float getMaximoZoom() {
        return maximoZoom;
    }

    public boolean isCamaraActivada() {
        return Boolean.valueOf(getPropiedades().getProperty(idCamaraActivada));
    }

    public void setCamaraActivada(boolean camaraActivada) {
        getPropiedades().actualizarPropiedad(idCamaraActivada, Boolean.toString(camaraActivada));
    }

    public void alternarCamaraActivada() {
        setCamaraActivada(!isCamaraActivada());
    }
}
