import java.util.*;


public class Restaurant {

	private Table[] tables;
	private String[] customers;

	//Finds most suitable table for customer
	public int getEmptyTable(int pax) {

		int i;
		int tableId = -1; //store return value
		int tempSize = pax-1; //to store most optimal size table available
		int tempCapacity = 10000; //to store table[i].getSeatingCapacity() for better readability

		//if no. of guest 0, no table offered
		if (pax == 0){
			return tableId;
		}
		else if (pax%2 == 1){
			pax += 1;
		}

		for (i=0; i<tables.length;i++){
			if (tables[i].availability() == true){
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

		return tableId;
	}

	//function to assign table, used by setReservation() and setOrder()
	public int assignTable(int pax, boolean isReservation) {

		int i;
		int tableId = -1;

		tableId = getEmptyTable(pax);

		if (tableId != -1){
			for (i=0; i<tables.length;i++){
				if (tables[i].getTableId() == tableId){
					if (isReservation){
						tables[i].setIsReserved(true);
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
		Order order;

		tableId = assignTable(pax, false);

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
				if (tables[i].getReservation().getCust() == custName) {
					tables[i].setIsReserved(false);
				}
			}
		}
	}

	private void addOrder(int tableId, int staffId) {
		// TODO - implement restaurant.addOrder
		int i;
		boolean isMember = false;
		Menu menu = new Menu();
		String custName;

		for (i=0; i<table.length;i++){
			if (tables[i].getTableId() == tableId){
				if (tables[i].getIsReserved() == false){ //if table not reserved, wrong input
					System.out.println("Invalid Table");
					break;
				}
				else {
					custName = tables[i].getReservation().getCustName();
					for (i=0;i<customers.length;i++){ //check member array for membership status
						if (customers[i].getName() == custName){
							if (customers[i].getMember()==true){
								isMember = true;
							}
						}
					}
					tables[i].setIsReserved(false); //remove reservation
					tables[i].setIsTaken(true); //add order
					order = tables[i].getOrder();
					order.setTime(time);
					order.setStaff(staffId);
					menu.showItems();
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

	public void addCustomer(custName){
		int i;
		int insertion = 0;
		for (i=0; i<customers.length; i++){
			if (customers[i] == null){
				customers[i] = custName;
				insertion = 1;
				System.out.prinln("New member added!");
				break;
			}
		}
		if (insertion == 0){
			System.out.println("Member List Full, failed to add customer.")
		}
	}

	public void revenueReport(Date start, Date end) {
		// TODO - implement restaurant.RevenueReport
		throw new UnsupportedOperationException();
	}

	public Restaurant(custArray)
	{
		int i;
		tables = new Table[20];
		for (int i = 0; i < numOfTables; i++){
			tables[i] = new Table(i);
		}
		customers = new String[50];
	}
}