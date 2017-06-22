/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pas.classifier;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pas.dao.DAOMessage;
import com.pas.dao.DAOMessageClassification;
import com.pas.domain.Message;
import com.pas.domain.MessageClassification;

import weka.classifiers.bayes.NaiveBayesMultinomialText;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
/**
 *
 * @author lucas
 */
public class BayesClassifier {
    public ArrayList<MessageClassification> classify(ArrayList<Message> messages) {
    	ArrayList<MessageClassification> messagesClassifications = new ArrayList<>();
    	
        try {
            DataSource ds = new DataSource("E:\\tmp\\training_file.arff");
            Instances ins = ds.getDataSet();
            ins.setClassIndex(1);
            NaiveBayesMultinomialText bayes = new NaiveBayesMultinomialText();
            bayes.buildClassifier(ins);
            
            Instance novo = new DenseInstance(2);
            novo.setDataset(ins);
            
            for(Message message : messages) {
            	MessageClassification messageClassification = new MessageClassification();
            	messageClassification.setMessage(message);
            	
            	novo.setValue(0, message.getMessageContent());
            	double prob[] = bayes.distributionForInstance(novo);
            	
            	if (prob[0] > prob[1]) {
            		messageClassification.setClassification("no");
            		messageClassification.setAccuracy(prob[0]);
                } else {
                	messageClassification.setClassification("no");
            		messageClassification.setAccuracy(prob[1]);
                }
            	
            	messagesClassifications.add(messageClassification);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(BayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return messagesClassifications;
    }
}
