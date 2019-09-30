package com.meti

import fi.iki.elonen.NanoHTTPD

case class SessionRequest(session: NanoHTTPD.IHTTPSession) extends Request {
  override def getPath(): String = session.getUri
}
