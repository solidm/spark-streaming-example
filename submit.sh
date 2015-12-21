#!/bin/bash
spark-submit \
  --class com.reaktor.App \
  --master local[4] \
  --deploy-mode client \
  --verbose \
  /Users/monoiddroid/veikkaus/spark-consumer/target/spark-streaming-1.0-SNAPSHOT.jar 
