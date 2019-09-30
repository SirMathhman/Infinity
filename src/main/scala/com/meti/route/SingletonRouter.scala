package com.meti.route

import com.meti.response.Response

case class SingletonRouter(route: Route) extends Router {
	override def process: Response = route.process
}
