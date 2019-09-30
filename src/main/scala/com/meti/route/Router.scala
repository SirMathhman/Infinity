package com.meti.route

import com.meti.response.Response

trait Router {
	def process: Response
}
