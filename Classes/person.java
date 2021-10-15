public class person {

	private string name;
	private string gender;
	
	public person(string name, string gender){
		this.name = name;
		this.gender = gender;
	}

	public string getName()
	{
		return this.name;
	}

	
	public void setName(string name)
	{
		this.name = name;
		return;
	}

	public string getGender() {
		return this.gender;
	}
	
	
	public void setGender(string gender) {
		this.gender = gender;
		return;
	}

}