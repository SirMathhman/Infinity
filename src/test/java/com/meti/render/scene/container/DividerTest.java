package com.meti.render.scene.container;

import com.meti.example.Header;
import com.meti.example.HeaderSize;
import com.meti.render.scene.style.PixelConstraint;
import com.meti.render.scene.style.RGBColors;
import com.meti.render.scene.style.border.Border;
import com.meti.render.scene.style.border.BorderType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DividerTest {

    @Test
    void render() {
        Container divider = new Divider();
        divider.position().set(PositionType.ABSOLUTE);
        divider.addAll(new Header(HeaderSize.H1, "Test"));
        divider.dimensions().set(new PixelConstraint(10), new PixelConstraint(10));
        divider.border().setAll(new Border(BorderType.SOLID, RGBColors.RED, new PixelConstraint(10)));
        Assertions.assertEquals("<div style=\"" +
                "border-bottom:solid rgb" +
                "(255,0,0) 10px;" +
                "border-left:solid rgb(255,0,0) 10px;" +
                "border-right:solid rgb(255,0,0) 10px;" +
                "border-top:solid rgb(255,0,0) 10px;" +
                "height:10px;" +
                "position:absolute;" +
                "width:10px\">" +
                "<h1>Test</h1>" +
                "</div>", divider.render().render());
    }
}