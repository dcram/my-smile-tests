package sandbox

import com.typesafe.scalalogging.LazyLogging
import org.apache.commons.csv.CSVFormat
import sandbox.MakeDatasetFromCsvApp.dataFrame
import smile.data.DataFrame
import smile.data.`type`.{DataTypes, StructField, StructType}
import smile.data.measure.NominalScale

import java.nio.file.Paths
import java.util


object MakeDatasetFromCsvApp extends App with LazyLogging {
  logger.info("Started")
  private val clsScale = new NominalScale("bad", "wrong", "unk")

  private val mySchema:StructType = DataTypes.struct(
    new StructField("flag", DataTypes.BooleanType),
    new StructField("score", DataTypes.DoubleType),
    new StructField("cls", DataTypes.ByteType, clsScale),
  )

  val dataFrame:DataFrame = smile.read.csv(
    Paths.get("src/test/resources/dataset1.csv"),
    CSVFormat.DEFAULT
      .withDelimiter(';')
      .withQuote('"')
      .withSkipHeaderRecord(true),
    mySchema
  )

  logger.info(s"nrows:  ${dataFrame.nrows()}")
  logger.info(s"ncols:  ${dataFrame.ncols()}")
  logger.info(s"names:  ${dataFrame.names().mkString(", ")}")
  logger.info(s"schema: ${dataFrame.schema()}")

  println("-"*80)
  println(dataFrame)
  println("-"*80)
  logger.info("Finished")
}
