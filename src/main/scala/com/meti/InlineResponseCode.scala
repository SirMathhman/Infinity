package com.meti

case class InlineResponseCode(value: Int) extends ResponseCode {
	override def getValue: Int = value
}
