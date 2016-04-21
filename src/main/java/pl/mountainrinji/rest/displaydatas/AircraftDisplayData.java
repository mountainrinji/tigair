package pl.mountainrinji.rest.displaydatas;

import pl.mountainrinji.db.entities.Aircraft;

public class AircraftDisplayData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Aircraft root;

	public AircraftDisplayData(Aircraft root) {
		super();
		this.root = root;
	}

	public Aircraft getRoot() {
		return root;
	}

	public void setRoot(Aircraft root) {
		this.root = root;
	}
	
	

}
