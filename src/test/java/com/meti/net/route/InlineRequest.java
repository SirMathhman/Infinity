package com.meti.net.route;

import com.meti.net.Method;
import com.meti.net.Request;
import com.meti.net.RequestBody;

class InlineRequest implements Request {
    private final String path;
    private final Method method;
    private final RequestBody requestBody;

    InlineRequest(String path, Method method, RequestBody requestBody) {
        this.path = path;
        this.method = method;
        this.requestBody = requestBody;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public RequestBody parseRequestBody() {
        return requestBody;
    }

    @Override
    public Method getMethod() {
        return method;
    }
}
