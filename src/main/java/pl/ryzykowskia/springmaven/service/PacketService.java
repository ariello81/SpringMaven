package pl.ryzykowskia.springmaven.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import pl.ryzykowskia.springmaven.dao.PacketDao;
import pl.ryzykowskia.springmaven.model.Packet;

@Component
public class PacketService {
	
	@Autowired
	private PacketDao packetDao;
	
	@Value( "${startSeq}" )
	private String startSeq;
	
	public PacketDao getPacketDao() {
		return packetDao;
	}
	
	public void setPacketDao(PacketDao packetDao) {
		this.packetDao = packetDao;
	}	
	
	public String getStartSeq() {
		return startSeq;
	}

	public void setStartSeq(String startSeq) {
		this.startSeq = startSeq;
	}

	public List<Packet> getPacketsFromPostCodeFamily(){
		List<Packet> allPackets = packetDao.getAll();
		List<Packet> foundedPackets = new ArrayList<Packet>();
		for (Packet packet : allPackets) {
			if (packet.getAddress().getPostCode().startsWith(startSeq)) {
				foundedPackets.add(packet);
			}
		}
		return foundedPackets;
	}

}
