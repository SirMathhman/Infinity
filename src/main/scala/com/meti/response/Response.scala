package com.meti.response

trait Response {
	def getCode: ResponseCode

	def getType: ResponseType

	def getData: Array[Byte]
}
