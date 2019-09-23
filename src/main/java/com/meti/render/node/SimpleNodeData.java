package com.meti.render.node;

import java.util.HashMap;
import java.util.Map;

public class SimpleNodeData implements NodeData {
    private final String id;

    SimpleNodeData(String id) {
        this.id = id;
    }

    @Override
    public Map<String, String> build() {
        Map<String, String> values = new HashMap<>();
        if (id != null) values.put("id", id);
        return values;
    }
}
