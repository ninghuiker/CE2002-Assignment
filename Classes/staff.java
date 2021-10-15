public class staff extends person {

	private int employeeId;
	private string jobTitle;
	
	public staff(string name, string gender, int employeeId, string jobtitle )
	{
		super(name, gender);
		this.employeeId = employeeId;
		this.jobTitle = jobtitle;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return;
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
		return;
	}

}