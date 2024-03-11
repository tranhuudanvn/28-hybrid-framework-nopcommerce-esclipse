package carFactory;

public abstract class Car {
	
	public abstract void viewCar();
	
	public abstract void driveCar();
	
	public void bookCar() {
		System.out.print("Booking this Car");
	}
}
