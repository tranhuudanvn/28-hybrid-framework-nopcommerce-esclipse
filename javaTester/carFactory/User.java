package carFactory;

public class User {

	public static void main(String[] args) {
		getCar("Honda").viewCar();
		getCar("Honda").driveCar();
		getCar("Honda").bookCar();
	}
	
	public static Car getCar(String carName) {
		Car car;
		if (carName.equalsIgnoreCase("Ford")) {
			car = new Ford();
		} else if (carName.equalsIgnoreCase("Honda")) {
			car = new Honda();
		} else if (carName.equalsIgnoreCase("Huyndai")) {
			car = new Huyndai();
		} else if (carName.equalsIgnoreCase("Mercedes")) {
			car = new Mercedes();
		} else if (carName.equalsIgnoreCase("Toyota")) { 
			car = new Toyota();
		} else {
			throw new RuntimeException("Car name is not valid");
		}
		
		return car;
	}

}
