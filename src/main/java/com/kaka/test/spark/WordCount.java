package com.kaka.test.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.catalyst.expressions.IntegerLiteral;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by sundaoping on 2018/2/24.
 */
public class WordCount {

    private static final String SPARK_HOME = "/Users/sundaoping/dev-env/spark/spark-2.2.1-bin-hadoop2.7/";

    private static final Pattern SPACE = Pattern.compile(" ");


    public static void main(String[] args) {

        String logFile = SPARK_HOME + "README.md"; // Should be some file on your system


        /**
         * 第1步：创建Spark的配置对象SparkConf，设置Spark程序的运行时的配置信息，
         * 例如说通过setMaster来设置程序要链接的Spark集群的Master的URL,如果设置
         * 为local，则代表Spark程序在本地运行，特别适合于机器配置条件非常差（例如 只有1G的内存）的初学者 *
         */
        SparkConf conf = new SparkConf().setAppName("Spark WordCount written by Java").setMaster("local");
        /**
         * 第2步：创建SparkContext对象
         * SparkContext是Spark程序所有功能的唯一入口，无论是采用Scala、Java、Python
         * 、R等都必须有一个SparkContext(不同的语言具体的类名称不同，如果是Java的话则为JavaSparkContext)
         * SparkContext核心作用：初始化Spark应用程序运行所需要的核心组件，包括DAGScheduler、TaskScheduler、
         * SchedulerBackend 同时还会负责Spark程序往Master注册程序等
         * SparkContext是整个Spark应用程序中最为至关重要的一个对象
         */
        JavaSparkContext sc = new JavaSparkContext(conf); // 其底层实际上就是Scala的SparkContext
        /**
         * 第3步：根据具体的数据来源（HDFS、HBase、Local FS、DB、S3等）通过JavaSparkContext来创建JavaRDD
         * JavaRDD的创建基本有三种方式：根据外部的数据来源（例如HDFS）、根据Scala集合、由其它的RDD操作
         * 数据会被RDD划分成为一系列的Partitions，分配到每个Partition的数据属于一个Task的处理范畴
         * 注意：文件路径不能直接用Windows路径中的反斜扛\，要改成Linux下的斜扛/
         */
        JavaRDD<String> lines = sc
                .textFile(logFile);
        /**
         * 第4步：对初始的JavaRDD进行Transformation级别的处理，例如map、filter等高阶函数等的编程，来进行具体的数据计算
         * 第4.1步：讲每一行的字符串拆分成单个的单词
         */
        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .filter(word -> !word.isEmpty());
        /*
        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                String[] ws=s.split(" ");
                //return new ArrayList<String>(ws);

                Iterator<String> its = Arrays.asList(ws).iterator();
                return its;
            }
        });*/

        /*JavaRDD<String> words = lines
                .flatMap(new FlatMapFunction<String, String>() { // 如果是Scala，由于SAM转换，所以可以写成val
                    // words =
                    // lines.flatMap
                    // { line =>
                    // line.split(" ")}
                    @Override
                    public Iterator<String> call(String line) throws Exception {
                        return Arrays.asList(line.split(" "));
                    }
                });
                */
        /**
         * 第4步：对初始的JavaRDD进行Transformation级别的处理，例如map、filter等高阶函数等的编程，来进行具体的数据计算
         * 第4.2步：在单词拆分的基础上对每个单词实例计数为1，也就是word => (word, 1)
         */
        JavaPairRDD<String, Integer> pairs = words
                .mapToPair(word -> new Tuple2<String, Integer>(word,1));

       /*
        JavaPairRDD<String, Integer> pairs = words
                .mapToPair(new PairFunction<String, String, Integer>() {
                    public Tuple2<String, Integer> call(String word)
                            throws Exception {
                        return new Tuple2<String, Integer>(word, 1);
                    }
                });
                */
        /**
         * 第4步：对初始的RDD进行Transformation级别的处理，例如map、filter等高阶函数等的编程，来进行具体的数据计算
         * 第4.3步：在每个单词实例计数为1基础之上统计每个单词在文件中出现的总次数
         */
        JavaPairRDD<String, Integer> wordsCount = pairs.reduceByKey(
                (v1, v2) -> v1 + v2
        );
        /*JavaPairRDD<String, Integer> wordsCount = pairs
                .reduceByKey(new Function2<Integer, Integer, Integer>() { // 对相同的Key，进行Value的累计（包括Local和Reducer级别同时Reduce）
                    public Integer call(Integer v1, Integer v2)
                            throws Exception {
                        return v1 + v2;
                    }
                });*/

        //JavaPairRDD<String, Integer> wc2 = wordsCount.sortByKey();

        /**
         * 为了实现按word排序,把key和value倒置,返回新的RDD
         */
        JavaPairRDD<Integer, String> keyValueConvertPairRDD = wordsCount.mapToPair(
                tuple2 -> new Tuple2<Integer, String>(tuple2._2, tuple2._1)
        );
        /*
        JavaPairRDD<Integer, String> keyValueConvertPairRDD = wordsCount.mapToPair(
                new PairFunction<Tuple2<String, Integer>, Integer, String>() {
            public Tuple2<Integer, String> call(Tuple2<String, Integer> stringIntegerTuple2) throws Exception {
                return new Tuple2<Integer, String>(stringIntegerTuple2._2,stringIntegerTuple2._1);
            }
        });*/

        /**
         * 按key倒叙排(降序)
         */
        JavaPairRDD<Integer, String> wc2 = keyValueConvertPairRDD.sortByKey(false);


        wc2.foreach(tuple2 -> System.out.println(tuple2._1 + ":::" +tuple2._2));
        /*
        wordsCount.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            public void call(Tuple2<String, Integer> pairs) throws Exception {
                System.out.println(pairs._1 + " : " + pairs._2);
            }
        });*/
        sc.close();
    }
}
