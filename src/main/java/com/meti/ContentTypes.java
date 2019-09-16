package com.meti;

public class ContentTypes implements ContentType {
    public static final ContentType PLAINTEXT = new ContentTypes("text/plain");
    public static final ContentType HTML = new ContentTypes("text/html");
    private final String contentType;

    public ContentTypes(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getValue() {
        return contentType;
    }
}
