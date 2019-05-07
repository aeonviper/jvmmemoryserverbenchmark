package nonheapbuster;

public class Sample {	
	private Integer id;
	private String value;	
	public String toString() {
		return "Hi there ! I am " + value + " of " + id;
	}	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
}
