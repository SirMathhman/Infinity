package com.meti

import java.io.ByteArrayInputStream

import com.meti.response.Response
import com.meti.route.Router
import fi.iki.elonen.NanoHTTPD
import fi.iki.elonen.NanoHTTPD.{IHTTPSession, newFixedLengthResponse}

case class NanoServer(port: Int, router: Router) extends Server {
	val internalServer = InternalServer(port, router)

	override def start(): Unit = internalServer.start()

	override def stop(): Unit = internalServer.stop()

	case class InternalServer(port: Int, router: Router) extends NanoHTTPD(port) {
		override def serve(session: IHTTPSession): NanoHTTPD.Response = toResponse(router.process)

		private def toResponse(response: Response): NanoHTTPD.Response = {
			val status = NanoHTTPD.Response.Status.lookup(response.getCode.getValue)
			val responseType = response.getType.value
			val stream = new ByteArrayInputStream(response.getData)
			val length = response.getData.length
			newFixedLengthResponse(status, responseType, stream, length)
		}
	}

}
