package sandbox

import com.typesafe.scalalogging.LazyLogging
import smile.data.DataFrame
import smile.data.`type`.{DataTypes, StructField, StructType}

import java.util


object MakeDatasetFromPojosApp extends App with LazyLogging {
  logger.info("Started")

//  case class Toto(flag:Boolean, score:Double, cls:Int)

  private val mySchema:StructType = DataTypes.struct(
    new StructField("feature1", DataTypes.BooleanType),
    new StructField("feature2", DataTypes.DoubleType),
    new StructField("feature3", DataTypes.IntegerType),
  )

  private val totoes:util.List[Toto] = new util.ArrayList[Toto]()
  totoes.add(new Toto(true, 3d, MyCat.bad));
  totoes.add(new Toto(false, 2d, MyCat.bad));
  totoes.add(new Toto(true, 1d, MyCat.unk));
  val dataFrame = DataFrame.of(totoes, classOf[Toto])

  logger.info(s"nrows:  ${dataFrame.nrows()}")
  logger.info(s"ncols:  ${dataFrame.ncols()}")
  logger.info(s"names:  ${dataFrame.names().mkString(", ")}")
  logger.info(s"schema: ${dataFrame.schema()}")

  println("-"*80)
  println(dataFrame)
  println("-"*80)
  logger.info("Finished")
}
