package com.kaka.test.nlp;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.junit.Test;

/**
 * Created by sundaoping on 2018/3/15.
 */
public class TFIDFTest {
    /*public static void main(String []args) {
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        System.out.println(ToAnalysis.parse(str));
    }*/


    @Test
    public void test() {
        /* input_url.txt
        http://baijiahao.baidu.com/builder/preview/s?id=1594780436227181087
        http://baijiahao.baidu.com/builder/preview/s?id=1594794281292760905
        http://baijiahao.baidu.com/builder/preview/s?id=1594815923050663760
        http://baijiahao.baidu.com/builder/preview/s?id=1594799027360713053
        http://baijiahao.baidu.com/builder/preview/s?id=1594802409374599535
        http://baijiahao.baidu.com/builder/preview/s?id=1594752958094390195
        http://baijiahao.baidu.com/builder/preview/s?id=1594792818860640517
        http://baijiahao.baidu.com/builder/preview/s?id=1594788515962759554
        http://baijiahao.baidu.com/builder/preview/s?id=1594803349657564274

        */

        TFIDF tfidfAlgorithm = new TFIDF();
        String filePath = "/Users/sundaoping/code/github/java-demo/src/main/resources/input_url.txt";
        String url = "http://baike.baidu.com/item/Java/85979";
        String word = "java";
        List<Term> terms = tfidfAlgorithm.parse(tfidfAlgorithm.getTextFromUrl(url));
        System.out.println("[【" + word + "】词频 ] " + tfidfAlgorithm.computeTF(word, terms));
        System.out.println("[【" + word + "】逆文档频率 ] " + tfidfAlgorithm.computeIDF(filePath, word));
        System.out.println("[【" + word + "】词频-逆文档频率 ] "+tfidfAlgorithm.computeTFIDF(filePath,terms,word));

    }
}
