package com.meti

case class SingletonRouter(route: Route) extends Router {
	override def process: Response = route.process
}
