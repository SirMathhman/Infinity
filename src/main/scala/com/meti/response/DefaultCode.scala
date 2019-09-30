package com.meti.response

object DefaultCode extends Enumeration {
	val OK = InlineResponseCode(200)
  val INTERNAL_SERVER_ERROR = InlineResponseCode(500)
}
