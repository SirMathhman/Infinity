package com.meti.route

import com.meti.Request
import com.meti.response.Response

trait Route {
	def canProcess(request: Request): Boolean = true

	def process(request: Request): Response
}
