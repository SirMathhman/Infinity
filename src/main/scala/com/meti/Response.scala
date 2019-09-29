package com.meti

trait Response {
	def getCode: ResponseCode

	def getType: ResponseType

	def getData: Array[Byte]
}
