package pl.mountainrinji.rest.displaydatas;

import pl.mountainrinji.db.entities.Aircraft;

public class AircraftDisplayData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Integer DEFAULT_COLSPAN = 17;
	
	private Aircraft root;

	private Integer colspan;
	
	public AircraftDisplayData() {
		
	}
	
	public AircraftDisplayData(Aircraft root) {
		super();
		this.root = root;
		calculateColspan();
	}

	
	
	private void calculateColspan() {
		colspan = DEFAULT_COLSPAN;
		if (root.getShowDescription()) {
			colspan++;
		}
		if (root.getShowMaintenanceInstruction()) {
			colspan++;
		}
		if (root.getShowMaintenanceReference()) {
			colspan++;
		}
		if (root.getShowSource()) {
			colspan++;
		}
	}



	public Integer getColspan() {
		return colspan;
	}



	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}



	public Aircraft getRoot() {
		return root;
	}

	public void setRoot(Aircraft root) {
		this.root = root;
	}
	
	

}
