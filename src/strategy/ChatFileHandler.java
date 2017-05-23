/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import dao.DAOWordCount;
import dao.IDAO;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import learning.BayesClassifier;
import model.WordCount;

/**
 *
 * @author lucas
 */
public class ChatFileHandler implements IFileHandler {
    public String handle(String filename, String fileContent) {
        /*
        String[] words = fileContent.split(" ");
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        System.out.println("Counting words...");
        for(String word : words) {
            if (!word.trim().equals("")) {
                if(wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }
        System.out.println("Updating word count table...!");
        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            WordCount wordCount = new WordCount();
            IDAO<WordCount> dao = new DAOWordCount<WordCount>();
            
            wordCount.setWord(entry.getKey().trim());
            wordCount.setCount(entry.getValue());
            
            System.out.println("Current word -> " + entry.getKey() + ": " + entry.getValue());
            
            try {
                dao.insert(wordCount);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Word count updated!");
*/
        
        String filepath = "E:\\PASService\\Chatfiles\\" + filename;
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileContent.getBytes("UTF-8"));
            outputStream.close();
            
            BayesClassifier classifier = new BayesClassifier();
            return classifier.classify(filepath);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
