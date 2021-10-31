import java.util.*;


public class Restaurant {

	
	private String[] customers;
	private int numOfTables = 10;
	private Table[] tables = new Table[numOfTables];

	//Finds most suitable table for customer
	public int getEmptyTable(int pax) {

		int i = 0;
		int tableId = -1; //store return value
		int tempSize = pax-1; //to store most optimal size table available
		int tempCapacity = 10000; //to store table[i].getSeatingCapacity() for better readability

		//System.out.println(tables[i].availability());

		//if no. of guest 0, no table offered
		if (pax == 0){
			return tableId;
		}
		else if (pax%2 == 1){
			pax += 1;
		}

		for (i=0; i<numOfTables;i++){
			if (this.tables[i].availability()){
				tempCapacity = tables[i].getSeatingCapacity();
				if (tempCapacity == pax){ //first instance of optimal table, end search
					tableId = tables[i].getTableId();
					return tableId;
				}
				else if (tempCapacity > pax && tempCapacity < tempSize){
					tempSize = tempCapacity;
					tableId = tables[i].getTableId();
				}
			}
		}
		System.out.println(tableId);
		return tableId;
	}

	//function to assign table, used by setReservation() and setOrder()
	public int assignTable(int pax, boolean isReservation) {

		int i;
		int tableId = -1;

		tableId = getEmptyTable(pax);

		System.out.println(tableId);

		if (tableId != -1){
			for (i=0; i<numOfTables;i++){
				if (tables[i].getTableId() == tableId){
					if (isReservation){
						tables[i].setIsReserved(true);
						tables[i].setIsTaken(true);
					}
					else{
						tables[i].setIsTaken(true);
					}
					break;
				}
			}
		}

		return tableId;
	}

	//Creating a reservation and selecting the appropriate table
	public void setReservation(Date date, int pax, String custName, String contact) {

		int i;
		int tableId;
		Reservation reservation;

		tableId = assignTable(pax, true);

		if (tableId == -1){
			System.out.println("Reservation failed, no table available.");
		}
		else {
			for (i=0; i<tables.length;i++){
				if (tables[i].getTableId() == tableId){
					reservation = tables[i].getReservation();
					reservation.setReserveTime(); //Should it be current time?
					reservation.setPax(pax);
					reservation.setCustName(custName);
					break;
				}
			}
		}
	}

	//Creating an order without an existing table ie. Walk-in customers
	public void setOrder(Date date, int pax, Staff staff, String custName) {

		int i, j;
		int tableId;
		boolean isMember = false;
		

		tableId = assignTable(pax, false);
		Order order = tables[tableId].getOrder();
		//if -1 is returned, no table assigned
		if (tableId == -1){
			System.out.println("Order failed, no table available.");
		}
		else {
			for (i=0;i<customers.length;i++){ //check member array for membership status
				if (customers[i] == custName){
						isMember = true;
				}
			}
			for (i=0; i<tables.length;i++) {
				if (tables[i].getTableId() == tableId) {
					order = tables[i].getOrder();
					order.setIsMember(isMember);
					order.setDate(date);
					order.addStaff(staff); 
					ItemMenu.showItems();
					PackageMenu.showPackage();
					System.out.println("Enter the number of items you would like to order:");
					Scanner sc = new Scanner(System.in);
					int itemCount = sc.nextInt();
					while (itemCount != 0){
						order.addItem();
						itemCount--;
					}
					break;
				}
			}
		}
	}

	public void removeReservation(String custName) {

		int i;

		for (i=0; i<tables.length; i++) {
			if (tables[i].getIsReserved() == true) {
				if (tables[i].getReservation().getCustName() == custName) {
					tables[i].setIsReserved(false);
				}
			}
		}
	}

	private void addOrder(int tableId, int staffId) {
		// TODO - implement restaurant.addOrder
		int i;
		boolean isMember = false;
		String custName;

		for (i=0; i<tables.length;i++){
			if (tables[i].getTableId() == tableId){
				if (tables[i].getIsReserved() == false){ //if table not reserved, wrong input
					System.out.println("Invalid Table");
					break;
				}
				else {
					custName = tables[i].getReservation().getCustName();
					for (i=0;i<customers.length;i++){ //check member array for membership status
						if (customers[i] == custName){
							
								isMember = true;
							
						}
					}
					tables[i].setIsReserved(false); //remove reservation
					tables[i].setIsTaken(true); //add order
					Order order = tables[i].getOrder();
					//order.setTime();
					//order.addStaff(staffId);
					PackageMenu.showPackage();
					ItemMenu.showItems();
					System.out.println("Enter the number of items you would like to order:");
					Scanner sc = new Scanner(System.in);
					int itemCount = sc.nextInt();
					while (itemCount != 0){
						order.addItem();
						itemCount--;
					}
					break;
				}
			}
		}
	}

	public void addCustomer(String custName){
		int i;
		int insertion = 0;
		for (i=0; i<customers.length; i++){
			if (customers[i] == null){
				customers[i] = custName;
				insertion = 1;
				System.out.println("New member added!");
				break;
			}
		}
		if (insertion == 0){
			System.out.println("Member List Full, failed to add customer.");
		}
	}

	public void revenueReport(Date start, Date end) {
		// TODO - implement restaurant.RevenueReport
		throw new UnsupportedOperationException();
	}

	public Restaurant(String[] custArray)
	{
		int i;int j;
		for (i = 0; i < numOfTables/2; i++){
			this.tables[i] = new Table(i, 2);
		}
		
		for ( j=i ; j<numOfTables;j++)
		{
			this.tables[j] = new Table(j, 4);
		}
		customers = new String[50];
		for (i=0; i<custArray.length;i++)
		{
			customers[i] = custArray[i];
		}

	}
}