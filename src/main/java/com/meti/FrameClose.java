package com.meti;

import fi.iki.elonen.NanoWSD;

class FrameClose implements Close {
    private final NanoWSD.WebSocketFrame.CloseCode code;
    private final String reason;
    private final boolean initiatedByRemote;

    public FrameClose(NanoWSD.WebSocketFrame.CloseCode code, String reason, boolean initiatedByRemote) {
        this.code = code;
        this.reason = reason;
        this.initiatedByRemote = initiatedByRemote;
    }

    @Override
    public int code() {
        return code.getValue();
    }

    @Override
    public String reason() {
        return reason;
    }

    @Override
    public boolean isRemote() {
        return initiatedByRemote;
    }
}
