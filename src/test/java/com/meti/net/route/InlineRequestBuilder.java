package com.meti.net.route;

import com.meti.net.Method;
import com.meti.net.Request;
import com.meti.net.RequestBody;

public class InlineRequestBuilder implements RequestBuilder {
    private final String path;
    private final Method method;
    private final RequestBody requestBody;

    public InlineRequestBuilder() {
        this("/", Method.GET, null);
    }

    private InlineRequestBuilder(String path, Method method, RequestBody requestBody) {
        this.path = path;
        this.method = method;
        this.requestBody = requestBody;
    }

    @Override
    public RequestBuilder withPath(String path) {
        return new InlineRequestBuilder(path, method, requestBody);
    }

    @Override
    public RequestBuilder withMethod(Method method) {
        return new InlineRequestBuilder(path, method, requestBody);
    }

    @Override
    public Request build() {
        return new InlineRequest(path, method, requestBody);
    }
}