package ecomm.itechhornet.sahana.dto;

public class DataPair {
	
	Long id;
	String name;
	
	public DataPair(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
