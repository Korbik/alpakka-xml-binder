import akka.NotUsed
import akka.stream.alpakka.xml.ParseEvent
import akka.stream.scaladsl.Flow

object ParseEventUnmarshaller {
  def unmarshall[T](implicit xmlDecoder: XmlEventDecoder[T]): Flow[ParseEvent,T, NotUsed] = ???
}

