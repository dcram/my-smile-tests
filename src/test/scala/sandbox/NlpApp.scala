package sandbox

import com.typesafe.scalalogging.LazyLogging

object NlpApp extends App with LazyLogging {
  logger.info("Started")

  import smile.nlp._

  val mail1 =
    """ Bonjour,
      |
      | Je ne suis pas interessé ! Merci de me désinscrire tout de suite !
      |
      |Cordialement,
      |Toto
      |""".stripMargin

  println("-"*80)
  println(mail1.normalize)
  println("-"*80)
  println(mail1.normalize.words().mkString(" | "))
  println("-"*80)
  println(mail1.normalize.sentences.map(s => s"* $s *").mkString("\n"))

  logger.info("Finished")
}
