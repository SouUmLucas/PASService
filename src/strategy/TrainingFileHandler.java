/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import dao.DAOTrainingFileReference;
import dao.IDAO;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import javax.xml.ws.WebServiceException;
import model.TrainingFileReference;

/**
 *
 * @author lucas
 */
public class TrainingFileHandler implements IFileHandler {
    
    public String handle(String filename, String fileContent) {
        //String filepath = "E:\\PASService\\Uploads\\" + filename;
        String filepath = "E:\\PASService\\Uploads\\training.arff";
        try {
            FileOutputStream fos = new FileOutputStream(filepath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileContent.getBytes("UTF-8"));
            outputStream.close();

            // Save the file reference into database
            TrainingFileReference trainingFile = new TrainingFileReference();
            trainingFile.setFilename(filename);
            trainingFile.setFilepath(filepath);

            System.out.println("Saving file reference into database");
            IDAO<TrainingFileReference> dao = new DAOTrainingFileReference<TrainingFileReference>();
            dao.insert(trainingFile);

            System.out.println("Received file: " + filepath);

        } catch (IOException e) {
            System.err.println(e);
            throw new WebServiceException();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }
        return "";
    }
    
}
