package pl.ryzykowskia.springmaven.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import pl.ryzykowskia.springmaven.model.Address;
import pl.ryzykowskia.springmaven.model.Packet;

@Component
public class CsvPacketDao implements PacketDao {
	
	@Value( "${csvFilename}" )
	private String csvFilename;
	
	@Value( "${encoding}" )
	private String encoding;
	
	@Value( "${separator}" )
	private String separator;

	public String getCsvFilename() {
		return csvFilename;
	}

	public void setCsvFilename(String csvFilename) {
		this.csvFilename = csvFilename;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	@Override
	public List<Packet> getAll() {
		List<Packet> results = new ArrayList<Packet>();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(csvFilename);
			InputStreamReader input = new InputStreamReader(fis, encoding);
	        BufferedReader br = new BufferedReader(input);
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(separator);
				String name = fields[0]; 
				String street = fields[1]; 
				String postCode = fields[2]; 
				String postCity = fields[3]; 
				String matrix = fields[5]; 
				
				Address address = new Address();
				address.setName(name);
				address.setStreet(street);
				address.setPostCode(postCode);
				address.setPostCity(postCity);

				Packet packet = new Packet();
				packet.setAddress(address);
				packet.setMatrix(matrix);
							
				results.add(packet);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return results;
	}

}
