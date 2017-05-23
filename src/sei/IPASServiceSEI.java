package sei;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface IPASServiceSEI {
	@WebMethod
	public String uploadTrainingFile(String filename, String fileContent);
	
	@WebMethod
	public byte[] download(String filename);
	
	@WebMethod
	public String uploadChatFile(String filename, String fileContent);
	
	@WebMethod
	public String createTree();
	
	@WebMethod
	public String classify(String filename);
	
	@WebMethod
	public byte[] getClassification(String filename);
}
