package com.meti.route

import com.meti.Request
import com.meti.response.Response

case class SingletonRouter(route: Route) extends Router {
	override def process(request: Request): Response = {
		if (route.canProcess(request)) route.process(request)
		throw new NoSuchElementException("Route " + route + " cannot accept request " + request)
	}
}
