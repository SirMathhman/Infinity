package com.meti.render.script;

import java.util.function.Supplier;

class MonadStatements {
    static final Supplier<MonadStatement<BoolRef>> IF = If::new;
}
