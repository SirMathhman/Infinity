package com.meti.response

case class InlineResponse(code: ResponseCode, responseType: ResponseType, data: Array[Byte]) extends Response {
  override def getCode: ResponseCode = code

  override def getType: ResponseType = responseType

  override def getData: Array[Byte] = data
}
