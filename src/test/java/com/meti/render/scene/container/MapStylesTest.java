package com.meti.render.scene.container;

import com.meti.render.Component;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapStylesTest {

    @Test
    void put() {
        Styles styles = new MapStyles();
        styles.put("color", "red");
        assertEquals("color:red", styles.render());
    }

    @Test
    void render() {
        Component styles = new MapStyles(Map.of("color", "red", "display", "block"));
        assertEquals("color:red;display:block", styles.render());
    }
}