package com.reaktor

object App {

  import org.apache.spark.streaming.{Seconds, StreamingContext}
  import org.apache.spark.{SparkContext, SparkConf}
  import org.apache.spark.storage.StorageLevel
  import org.apache.spark.streaming.kafka._
  import org.apache.spark._

  import org.apache.spark.SparkConf

  val conf = new SparkConf().setMaster("local[4]").setAppName("SampleApp")
  val ssc = new StreamingContext(conf, Seconds(1))

  val kafkaStream = KafkaUtils.createStream(ssc, "localhost", "test", Map("topicname"-> 1), StorageLevel.MEMORY_ONLY)

  def main(args : Array[String]) {
    println( "Hello World!" )


    kafkaStream.foreachRDD { rdd =>
      rdd.foreach(println)

    }

    ssc.start()
    ssc.awaitTermination()
  }

}
