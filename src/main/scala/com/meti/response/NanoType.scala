package com.meti.response

import java.net.URI

import fi.iki.elonen.NanoHTTPD

case class NanoType(uri: URI) extends ResponseType {
  override def value: String = NanoHTTPD.getMimeTypeForFile(uri.toString)
}
