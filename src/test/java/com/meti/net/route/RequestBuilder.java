package com.meti.net.route;

import com.meti.net.Method;
import com.meti.net.Request;

public interface RequestBuilder {
    RequestBuilder withPath(String path);

    RequestBuilder withMethod(Method method);

    Request build();
}
