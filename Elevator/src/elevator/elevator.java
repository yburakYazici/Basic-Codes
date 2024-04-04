package elevator;

import java.util.Scanner;


public class elevator {
	private static int person=0;
	private static int totalWeights=500;
	private static int currentFloor;
	private static int weights=0;
	static Scanner scanner = new Scanner(System.in);
	private static int personWeights;
	public static void weight() {
		System.out.println("How many people are there ?");
		person = scanner.nextInt();
		if(person==0) {
			System.out.println("Number of people inside : "+person);
			System.exit(0);
			}
		for (int i = 0; i<person; i++) {
			System.out.println("Enter"+(i+1)+".person weight");
			personWeights=scanner.nextInt();
			weights=weights+personWeights;
			
		}
		if(weights>totalWeights) {
			System.out.println("You have exceeded the weight limit");
			System.out.println("Total Weights are "+weights+"(Must be under 500)");
			weights=0;
			weight();
		}
		else if(weights<=totalWeights){
			
			System.out.println("Total weights are "+weights+"(must be under 500)");
			System.out.println("You can choose the floor you wil go.");
			
		  }
		}
		public static void ascend() {
		System.out.println("How many people are getting on the elevator?("+person+")");
		int ascend=scanner.nextInt();
		person=person+ascend;
		System.out.println("Number of people inside:"+person);
		if(person==0) {
			System.out.println("Elevator closed");
			System.exit(0);
			
			
		}
		for(int i=0;i<person;i++) {
			System.out.println("Enter"+(i+1)+".person weight");
			personWeights=scanner.nextInt();
			weights=weights+totalWeights;
		}
		if(weights<=totalWeights) {
		
		}
		else {
		System.out.println("You have exceeded the weight limit!");
		weights=0;
		weight();
		}
		
	}
		public static void descend() {
			weights=0;
			System.out.println("How many people are getting off the elevator ? Current("+person+")");
			int descend=scanner.nextInt();
			person=person-descend;
			System.out.println("Number of people inside : "+person);
			ascend();
			
			
		}
		
		public static void run() {
			if(weights<=totalWeights) {
				System.out.println("Chose a floor (0-9) where 0 = garage:");
				int destinationFloor=scanner.nextInt();
				if(destinationFloor<0||destinationFloor>9){
					System.out.println("Valid floor number");					
				}
				move(destinationFloor);
				System.out.println("Leave the elevator");
			}
			else {
				System.out.println("You have exceeded the weight limit");
				weights=0;
				weight();
			}
			descend();
		}
		public static void call() {
			currentFloor=1+((int)(Math.random()*5));
			System.out.println("The elevator is now on floor"+currentFloor);
			System.out.println("Choose a floor (0-9) where 0 =garage:");
			int personFloor=scanner.nextInt();
			System.out.println("Elevator is coming");
			move(personFloor);
			System.out.println("Enter the elevator");
			weight();
		}
		public static void move (int destinationFloor) {
			if(destinationFloor==currentFloor) {
				
			}else if(destinationFloor>currentFloor) {
				Up(destinationFloor);
			}else {
				Down(destinationFloor);
			}
		}
	
		public static void Up(int destinationFloor) {
			System.out.println("The elevator is on it way up ...");
			while(currentFloor<destinationFloor) {
				currentFloor++;
				System.out.println(currentFloor);
			}
			System.out.println("The elevator has arrived");
		}
	
		public static void Down(int destinationFloor) {
			System.out.println("The elevator is on its way down");
			while(currentFloor>destinationFloor) {
				currentFloor--;
				System.out.println(currentFloor);
			}
			System.out.println("The elevator has arrived");
		}
	
		public static void runElevator() {
			call();
			run();			
			}
		
	public static void main(String[] args) {
		runElevator();

	}
}
