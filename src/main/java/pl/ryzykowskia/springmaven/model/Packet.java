package pl.ryzykowskia.springmaven.model;

public class Packet {

	private String matrix;
	private Address address;
	
	public String getMatrix() {
		return matrix;
	}
	public void setMatrix(String matrix) {
		this.matrix = matrix;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Packet [matrix=" + matrix + ", address=" + address + "]";
	}
	
	
	
}
