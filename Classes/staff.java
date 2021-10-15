public class staff extends person {

	private int employeeId;
	private string jobTitle;

	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public string getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * 
	 * @param jobTitle
	 */
	public void setJobTitle(string jobTitle) {
		this.jobTitle = jobTitle;
	}

}