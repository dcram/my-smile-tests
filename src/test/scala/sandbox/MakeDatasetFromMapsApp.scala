package sandbox

import com.typesafe.scalalogging.LazyLogging
import smile.data.DataFrame
import smile.data.`type`.{DataTypes, StructField, StructType}
import smile.data.measure.NominalScale

import java.util


object MakeDatasetFromMapsApp extends App with LazyLogging {
  logger.info("Started")


//  case class Toto(flag:Boolean, score:Double, cls:Int)

  private val clsScale = new NominalScale("bad", "wrong", "unk")
  private val mySchema:StructType = DataTypes.struct(
    new StructField("flag", DataTypes.BooleanType),
    new StructField("score", DataTypes.DoubleType),
    new StructField("cls", DataTypes.ByteType, clsScale),
  )

  private val totoes:util.List[util.Map[String, Any]] = new util.ArrayList[util.Map[String, Any]]()

  totoes.add(util.Map.of("flag", true, "score", Double.NaN, "cls", clsScale.valueOf("bad")));
  totoes.add(util.Map.of("flag", true, "score", 3d, "cls", clsScale.valueOf("bad")));
  totoes.add(util.Map.of("flag", true, "score", 3d, "cls", clsScale.valueOf("unk")));
  val dataFrame = DataFrame.of(totoes, mySchema)

  logger.info(s"nrows:  ${dataFrame.nrows()}")
  logger.info(s"ncols:  ${dataFrame.ncols()}")
  logger.info(s"names:  ${dataFrame.names().mkString(", ")}")
  logger.info(s"schema: ${dataFrame.schema()}")

  println("-"*80)
  println(dataFrame)
  println("-"*80)
  logger.info("Finished")
}
