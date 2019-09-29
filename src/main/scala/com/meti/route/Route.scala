package com.meti.route

import com.meti.response.Response

trait Route {
	def process: Response
}
