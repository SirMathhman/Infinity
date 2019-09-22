package com.meti;

interface MutableParentRoute extends ParentRoute {
    ParentRoute with(ParentRoute route);
}
