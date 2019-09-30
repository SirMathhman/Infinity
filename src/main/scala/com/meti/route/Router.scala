package com.meti.route

import com.meti.Request
import com.meti.response.Response

trait Router {
  def process(request: Request): Response
}
