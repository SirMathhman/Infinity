package com.meti

import java.net.URL

import com.meti.response.{DefaultCode, PlainType, Response, StringResponse}
import com.meti.route.{Route, SingletonRouter}
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.{AfterEach, BeforeEach, Test}

class ServerTest {
	var server: Option[Server] = None

	@BeforeEach
	def setUp(): Unit = {
		val router = SingletonRouter(TestRoute)
		server = Some(NanoServer(80, router))
		server.get.start()
	}

	@AfterEach
	def tearDown(): Unit = {
		server.get.stop()
	}

	@Test
	def construct(): Unit = {
		val url = new URL("http://localhost:80")
		val stream = url.openStream()
		val data = stream.readAllBytes()
		assertEquals("test", new String(data))
		stream.close()
	}

	object TestRoute extends Route {
		override def process(request: Request): Response = StringResponse(DefaultCode.OK, PlainType, "test")
	}

}
