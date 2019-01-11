/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intel.hibench.common.streaming.metrics

object MetricsReader extends App {

//  if (args.length < 5) {
//    System.err.println("args: <bootstrapServers> <topic> <outputDir> <sampleNumber> <threadNumber> need to be specified!")
//    System.exit(1)
//  }
  if (args.length < 6) {
    System.err.println("args: <zkConnect> <bootstrapServers> <topic> <outputDir> <sampleNumber> <threadNumber> need to be specified!")
    System.exit(1)
  }

  val zkConnect = args(0)
  val bootstrapServers = args(1)
  val topic = args(2)
  val outputDir = args(3)
  val sampleNum = args(4).toInt
  val threadNum = args(5).toInt

//  val zkConnect = "hadoop001:2181,hadoop002:2181,hadoop003:2181/kafka011"
//  val bootstrapServers = "hadoop001:9092,hadoop002:9092,hadoop003:9092"
//  val topic = "SPARK_wordcount_2_1000_50_1547120909384"
//  val outputDir = "D:/"
//  val sampleNum = 5000000
//  val threadNum = 20
  val latencyCollector = new KafkaCollector(zkConnect,bootstrapServers, topic, outputDir, sampleNum, threadNum)
  latencyCollector.start()
}
