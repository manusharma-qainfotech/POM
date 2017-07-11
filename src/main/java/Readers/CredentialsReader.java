package Readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.omg.CORBA.portable.InputStream;
import org.yaml.snakeyaml.Yaml;

import model.Credential;

public class CredentialsReader {
	String urlAddress;
	Map<String, List<Object>> map;
	List<Credential> listCredential;

	public CredentialsReader() throws FileNotFoundException {
        String path=  System.getProperty("user.dir");
        FileReader reader = new FileReader(path+"\\src\\main\\resources\\Credentials.yaml");
		Yaml yaml = new Yaml();
		map = (Map<String, List<Object>>) yaml.load(reader);

		ArrayList<Credential> credential = (ArrayList) map.get("credentials");
		listCredential = new ArrayList<Credential>();
		for (int i = 0; i < credential.size(); i++) {
			Map<String, Object> map1 = (Map<String, Object>) credential.get(i);
			Credential obj = new Credential(map1);

			listCredential.add(obj);
		}
		urlAddress = (String) ((Map) map.get("Urls").get(0)).get("url");
	}

	public List<Credential> credentials() throws FileNotFoundException {
		return listCredential;
	}

	public String url() {

		return urlAddress;
	}
}
