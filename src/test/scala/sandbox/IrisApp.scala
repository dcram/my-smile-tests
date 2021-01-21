package sandbox

import com.typesafe.scalalogging.LazyLogging
import smile.data.`type`.{DataTypes, StructField, StructType}
import smile.data.measure.NominalScale
import smile.read

import java.nio.file.Paths


object IrisApp extends App with LazyLogging {
  logger.info("Started")


  val iris = read.arff(Paths.get("data/weka/iris.arff"))


  logger.info(s"nrows:  ${iris.nrows()}")
  logger.info(s"ncols:  ${iris.ncols()}")
  logger.info(s"names:  ${iris.names().mkString(", ")}")
  private val structType: StructType = iris.schema()
  logger.info(s"schema: $structType")

  private val classField: StructField = structType.field("class")
  logger.info(s"Class field: ${classField}")
  println("-"*80)
  println(iris)
  println("-"*80)
  logger.info("Finished")
}
