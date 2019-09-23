package com.meti.render.script;

interface MonadStatement<A> extends Context {
    MonadStatement<A> with(A argument);
}
