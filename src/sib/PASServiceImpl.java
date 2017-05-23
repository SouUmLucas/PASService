package sib;

import model.ChatClassification;
import sei.IPASServiceSEI;
import javax.jws.WebService;
import strategy.ChatFileHandler;
import strategy.IFileHandler;
import strategy.TrainingFileHandler;

@WebService(endpointInterface = "sei.IPASServiceSEI")
public class PASServiceImpl implements IPASServiceSEI {
    IFileHandler fileHandler;

    @Override
    public String uploadTrainingFile(String filename, String fileContent) {
        fileHandler = new TrainingFileHandler();
        fileHandler.handle(filename, fileContent);
        
        return "sucesso";
    }
	
    @Override
    public String uploadChatFile(String filename, String fileContent) {
        fileHandler = new ChatFileHandler();
        return fileHandler.handle(filename, fileContent);
    }

    @Override
    public byte[] download(String filename) {
        System.out.println(filename);
        return null;
    }

    @Override
    public String createTree() {
        return "Criando árvore";
    }

    @Override
    public String classify(String filename) {
        // receber o arquivo que será classificado
        // instanciar o objeto de classificador
        // classificar
        // salvar cada mensagem no banco de dados juntamente com sua classificação
        // retornar um objeto String com todas as frase, juntamente com sua classificação
        return null;
    }

    @Override
    public byte[] getClassification(String filename) {
        // TODO Auto-generated method stub
        return null;
    }
}
