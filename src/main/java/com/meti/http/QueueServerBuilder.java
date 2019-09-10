package com.meti.http;

import com.meti.server.ServerBuilder;
import com.meti.response.Response;

public interface QueueServerBuilder extends ServerBuilder<QueueServerBuilder, Response> {
    ServerBuilder<QueueServerBuilder, Response> withBacklog(int backlog);
}
