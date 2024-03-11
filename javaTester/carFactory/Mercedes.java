package carFactory;

public class Mercedes extends Car{

	@Override
	public void viewCar() {
		System.out.print("Viewing Mercedes Car");
	}

	@Override
	public void driveCar() {
		System.out.print("Driving Mercedes Car");
	}

}
