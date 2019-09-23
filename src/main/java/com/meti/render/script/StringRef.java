package com.meti.render.script;

interface StringRef extends Ref<StringRef> {
    StringRef concat(StringRef other);
}
