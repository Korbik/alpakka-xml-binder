import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.alpakka.xml.{Characters, EndElement, ParseEvent, StartElement}
import akka.stream.scaladsl.{Sink, Source}
import org.specs2._
import org.specs2.concurrent.ExecutionEnv

import scala.concurrent.Future

object ParseEventDecoderSpecs extends Specification {
  implicit val executionEnv = ExecutionEnv.fromGlobalExecutionContext

  def is =
    s2"""
        Map from <a>a</a> $mappingStringValue
      """

  def mappingStringValue = {
    val system = ActorSystem("TestString")
    val materializer = ActorMaterializer()(system)
    val parseEventList =
      List[ParseEvent](StartElement("a"), Characters("a"), EndElement("a"))
    val f: Future[String] = Source(parseEventList)
      .via(
        ParseEventUnmarshaller.unmarshall(
          XmlEventDecoder.extractStringElement("a")))
      .runWith(Sink.head)(materializer)
    f must beEqualTo("a").await
  }
}
