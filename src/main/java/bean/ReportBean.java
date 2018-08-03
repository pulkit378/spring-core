package bean;

import java.io.Serializable;

public class ReportBean implements Serializable {

	
	String cfname;
	String clname;
	Double total; 
	
	
	public String getCfname() {
		return cfname;
	}
	public void setCfname(String cfname) {
		this.cfname = cfname;
	}
	public String getClname() {
		return clname;
	}
	public void setClname(String clname) {
		this.clname = clname;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "ReportBean [cfname=" + cfname + ", clname=" + clname + ", total=" + total + "]";
	}

	
	
	
}
