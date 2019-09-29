package com.meti.response

case class InlineResponseCode(value: Int) extends ResponseCode {
	override def getValue: Int = value
}
