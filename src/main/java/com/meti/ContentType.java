package com.meti;

public class ContentType {
    public static final ContentType PLAINTEXT = new ContentType("text/plain");
    private final String contentType;

    public ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }
}
