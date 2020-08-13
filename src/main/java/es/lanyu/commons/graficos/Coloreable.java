package es.lanyu.commons.graficos;

import java.awt.Color;

import es.lanyu.commons.math.MathUtils;

public interface Coloreable {

    public static String leerDatosColor(Coloreable color) {
        Color c = color.getColor();
        // Ver https://stackoverflow.com/a/18194652
        return "hex:" + color.getHexFromRGB()
            + " | r:" + c.getRed() + ", g:" + c.getGreen() + ", b:" + c.getBlue()
            + ", a:" + c.getAlpha();
    }

    static Color generarColor() {
        return generarColor(false);
    }

    static Color generarColor(boolean randomAlpha) {
        return new Color(MathUtils.nextFloat(), MathUtils.nextFloat(), MathUtils.nextFloat(),
                randomAlpha ? MathUtils.nextFloat() : 1f);
    }

    static Coloreable generarColoreableRandom() {
        return generarColoreableRandom(false);
    }

    static Coloreable generarColoreableRandom(boolean randomAlpha) {
        return generarColoreable(generarColor(randomAlpha));
    }

    static Coloreable generarColoreable(Color color) {
        return new Coloreable() {
            @Override
            public Color getColor() { return color; }
        };
    }

    Color getColor();

    default String getHexFromRGB() {
        String hex = Integer.toHexString(getColor().getRGB());
        int length = hex.length();
        return "#" + hex.substring(length - 6, length).toUpperCase();
    }

}
