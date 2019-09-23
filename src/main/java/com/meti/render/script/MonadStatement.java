package com.meti.render.script;

import com.meti.render.Binding;

interface MonadStatement<A> {
    Context next(A argument, Binding<Context> binding);
}
