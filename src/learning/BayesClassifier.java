package learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.bayes.NaiveBayesMultinomialText;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class BayesClassifier {
    
    public String classify(String filepath) {
        try {
            DataSource ds = new DataSource("E:\\PASService\\Uploads\\training.arff");
            Instances ins = ds.getDataSet();
            //System.out.println(ins.toString());
            ins.setClassIndex(1);
            NaiveBayesMultinomialText bayes = new NaiveBayesMultinomialText();
            bayes.buildClassifier(ins);
            
            Instance novo = new DenseInstance(2);
            novo.setDataset(ins);
            StringBuilder result;
            result = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = br.readLine()) != null) {
                   novo.setValue(0, line);
                   double prob[] = bayes.distributionForInstance(novo);
                   result.append("[\"" + line + "\", \"" + prob[0] + "\", \"" + prob[1] + "\"],\n");
                }
            }
            String res = result.toString();
            return res;
            
        } catch (Exception ex) {
            Logger.getLogger(BayesClassifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
