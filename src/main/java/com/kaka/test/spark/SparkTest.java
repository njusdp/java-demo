package com.kaka.test.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

/**
 * Created by sundaoping on 2018/2/23.
 */
public class SparkTest {
    private static final String SPARK_HOME = "/Users/sundaoping/dev-env/spark/spark-2.2.1-bin-hadoop2.7/";
    public static void main(String[] args) {
        String logFile = SPARK_HOME + "README.md"; // Should be some file on your system
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();

        long numAs = logData.filter(s -> s.contains("Spark")).count();
        long numBs = logData.filter(s -> s.contains("Scala")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }

}
