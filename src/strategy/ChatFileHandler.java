/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import dao.*;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import learning.BayesClassifier;

import model.ChatFileReference;
import model.Chat;
import model.Message;
import model.WordCount;
import sun.misc.resources.Messages_es;

/**
 *
 * @author lucas
 */
public class ChatFileHandler implements IFileHandler {
    public String handle(String filename, String fileContent) {
        String filepath = "Uploads\\Chatfiles\\" + filename;
        try {
            countWords(fileContent);
            // saves chat and each message into database
            saveChatfile(filename, fileContent, filepath);

            BayesClassifier classifier = new BayesClassifier();
            return classifier.classify(filepath);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void saveChatfile(String filename, String fileContent, String filepath) throws IOException, SQLException {
        // saves the file into chatfile folder
        FileOutputStream fos = new FileOutputStream(filepath);
        BufferedOutputStream outputStream = new BufferedOutputStream(fos);
        outputStream.write(fileContent.getBytes("UTF-8"));
        outputStream.close();

        ChatFileReference chatFileReference = new ChatFileReference();
        chatFileReference.setFilename(filename);
        chatFileReference.setFilepath(filepath);

        System.out.println("Saving file reference into database");
        IDAO<ChatFileReference> chatFileReferenceIDAO = new DAOChatFileReference<ChatFileReference>();

        Chat chat = new Chat();
        chat.setAlias(filename);
        chat.setChatFileReference((ChatFileReference) chatFileReferenceIDAO.insert(chatFileReference));

        IDAO<Chat> chatIDAO = new DAOChat<Chat>();
        saveMessages((Chat) chatIDAO.insert(chat), fileContent);
    }

    public void saveMessages(Chat chat, String fileContent) throws IOException, SQLException {
        ArrayList<String> messagesStr = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new StringReader(fileContent))) {
            String message = reader.readLine();
            while (message != null) {
                messagesStr.add(message);
                message = reader.readLine();
            }
        }

        ArrayList<Message> messages = new ArrayList<>();

        for(String messageStr : messagesStr) {
            Message message = new Message(chat, messageStr);
            messages.add(message);
        }

        DAOMessage daoMessage = new DAOMessage();
        daoMessage.insert(messages);
    }

    public void countWords(String fileContent) throws SQLException {
        String[] words = fileContent.split(" ");

        DAOWordCount daoWordCount = new DAOWordCount();
        HashMap<String, Integer> wordCountMap = new HashMap<>();

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
            DAOWordCount dao = new DAOWordCount();

            wordCount.setWord(entry.getKey().trim());
            wordCount.setCount(entry.getValue());

            System.out.println("Current word ->" + entry.getKey() + ": " + entry.getValue());

            try {
                dao.insert(wordCount);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Word count updated!");
    }
}
