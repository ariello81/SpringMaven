package pl.ryzykowskia.springmaven.model;

public class Address {
	private String name;
    private String street;
    private String postCode;
    private String postCity;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostCity() {
		return postCity;
	}
	public void setPostCity(String postCity) {
		this.postCity = postCity;
	}
	@Override
	public String toString() {
		return "Address [name=" + name + ", street=" + street + ", postCode=" + postCode + ", postCity=" + postCity
				+ "]";
	}
    
    
}
