package com.meti

case class StringResponse(code: ResponseCode, responseType: ResponseType, value: String) extends Response {
	override def getCode: ResponseCode = code

	override def getType: ResponseType = responseType

	override def getData: Array[Byte] = value.getBytes
}
