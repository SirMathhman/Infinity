package com.meti.render.scene.style;

class RGBColor implements Color {
    private final int blue;
    private final int green;
    private final int red;

    RGBColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public String render() {
        return "rgb(" + red + "," + green + "," + blue + ")";
    }
}
