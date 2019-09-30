package com.meti.route

import java.io.IOException
import java.nio.file.{Files, Path, Paths}

import com.meti.Request
import com.meti.response._

case class AssetRoute(internalPath: Path, webPath: String) extends Route {
  override def canProcess(request: Request): Boolean = Files.exists(buildPath(request))

  override def process(request: Request): Response = {
    try {
      val path = buildPath(request)
      val data = Files.readAllBytes(path)
      val nanoType = NanoType(buildPath(request).toUri)
      InlineResponse(DefaultCode.OK, nanoType, data)
    } catch {
      case e: IOException => StringResponse(DefaultCode.INTERNAL_SERVER_ERROR, PlainType, e.getLocalizedMessage)
    }
  }

  private def buildPath(request: Request): Path = internalPath.resolve(buildArgsPath(request))

  private def buildArgsPath(request: Request) = request.getPath()
    .replace(webPath + "/", "")
    .split("/")
    .map((value: String) => Paths.get(value))
    .reduce((path0: Path, path1: Path) => path0.resolve(path1))
}
