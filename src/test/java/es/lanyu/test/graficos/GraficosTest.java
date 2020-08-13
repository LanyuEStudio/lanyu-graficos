package es.lanyu.test.graficos;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

import es.lanyu.commons.graficos.Coloreable;

public class GraficosTest {

    @Test
    public void colorTest() {
        Coloreable c;
        boolean alphaMenorDe16 = false, alphaMayorDe16 = false;
        do {
            c = Coloreable.generarColoreableRandom(true);
            String hex = c.getHexFromRGB();
            Color color = c.getColor();
            List<Function<Color, Integer>> funciones = Arrays.asList(Color::getRed, Color::getGreen, Color::getBlue);
            for (int j = 1, k = 0; j < hex.length() - 1; j += 2, k++) {
                boolean coincidencia = funciones.get(k).apply(color).equals(Integer.decode("#" + hex.substring(j, j + 2)));
                assertTrue("No coinciden valores " + hex + " con " + color, coincidencia);
            }
            if (color.getAlpha() < 16) alphaMenorDe16 = true;
            else alphaMayorDe16 = true;
            System.out.println("Color generado: " + Coloreable.leerDatosColor(c));
        } while (!(alphaMenorDe16 && alphaMayorDe16));
    }

}
