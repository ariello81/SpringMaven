package pl.ryzykowskia.springmaven.dao;

import java.util.List;

import pl.ryzykowskia.springmaven.model.Packet;

public interface PacketDao {
	public List<Packet> getAll();
}
