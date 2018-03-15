package com.kaka.test.spark;

import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;

import java.util.Arrays;
import java.util.List;


/**
 * Created by sundaoping on 2018/2/23.
 */
public class SparkTest {
    private static final String SPARK_HOME = "/Users/sundaoping/dev-env/spark/spark-2.2.1-bin-hadoop2.7/";
    public static void main(String[] args) {
        String logFile = SPARK_HOME + "README.md"; // Should be some file on your system

        /*
        SparkSession spark = SparkSession.builder().appName("Simple Application").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();

        long numAs = logData.filter(s -> s.contains("Spark")).count();
        long numBs = logData.filter(s -> s.contains("Scala")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
        */


        String appName = "SparkTest";
        String master = "local";

        SparkConf conf = new SparkConf().setAppName(appName).setMaster(master);
        JavaSparkContext sc = new JavaSparkContext(conf);


        JavaRDD<String> lines = sc.textFile(logFile);

        JavaRDD<Integer> lineLengths = lines.map(s -> s.length());

        int totalLength = lineLengths.reduce((a,b) -> a + b);


        System.out.println("totalLength:" + totalLength);

       // System.out.println("Total Length:" + totalLength);
        //long numAs = lines.filter(s -> s.contains("Spark")).count();
        //long numBs = lines.filter(s -> s.contains("Scala")).count();

       // System.out.println("Lines with Spark: " + numAs + ", lines with Scala: " + numBs);


        //Parallelized Collections
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        JavaRDD<Integer> distData = sc.parallelize(data);

        //Passing Functions to Spark
        JavaRDD<Integer> len = lines.map(new Function<String, Integer>() {
            @Override
            public Integer call(String s) throws Exception {
                return s.length();
            }
        });

        int tLen = len.reduce(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        System.out.println("tLen:" + tLen);



    }

}
