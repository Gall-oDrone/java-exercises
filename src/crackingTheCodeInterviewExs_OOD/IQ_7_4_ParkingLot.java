package crackingTheCodeInterviewExs_OOD;

import java.util.ArrayList;

public class IQ_7_4_ParkingLot {

	public enum VehicleSize { Motorcycle, Compact, Large }
	
	public abstract class Vehicle {
		protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
		protected String licensePlate;
		protected int spotsNeeded;
		protected VehicleSize size;
		
		public int getSpotsNeeded() { return spotsNeeded; }
		public VehicleSize getSize() { return size; }
		
		/* Park vehicle in this spot (among others, potentially) */
		public void parkInSpot(ParkingSpot s) { parkingSpots.add(s); }
		
		/* Remove car from spot, and notify spot that it's gone */
		public void clearSpots() { }
		
		/* Checks if the spot is big enough for the vehicle (and is avilable). This
		 * compares the SIZE only. IT does not check if it has enough spots. */
		public abstract boolean canFitInSpot(ParkingSpot spot);
	}
	
	public class Bus extends Vehicle {
		public Bus() {
			spotsNeeded = 5;
			size = VehicleSize.Large;
		}
		
		/*  Check if the spot is a Large. Doesn't check num of spots */
		public boolean canFitInSpot(ParkingSpot spot) {
			return spot == this.size;
		}
		
		public class Car extends Vehicle {
			public Car() {
				spotsNeeded = 1;
				size = VehicleSize.Compact;
			}
			
			/* Checks if the spot is a Compact or a Large. */
			public boolean canFitInSpot(ParkingSpot spot) {
				return spot == VehicleSize.Compact || spot == VehicleSize.Large;
			}
		}
		
		public class Motorcycle extends Vehicle {
			public Motorcycle() {
				spotsNeeded = 1;
				size = VehicleSize.Motorcycle;
			}
			
			public boolean canFitInSpot(ParkingSpot spot) {
				return spot == VehicleSize.Motorcycle;
			}
		}
	}
	
	public class ParkingLot {
		private Level[] levels;
		private final int NUM_LEVELS = 5;
		
		public ParkingLot(Level[] levels) {
			super();
			this.levels = levels;
		}

		public ParkingLot() {
			super();
		}

		/* Park the vehicle in a spot (or multiple spots). Return false it failed */
		public boolean parkVehicle(Vehicle vehicle) {}
	}
	
	public class Level {
		private int floor;
		private ParkingSpot[] spots;
		private int availableSpots = 0; // number of free spots
		private static final int SPOT_PER_ROW = 10;
		
		pubic Level(int flr, int numberSpots) {}
		
		public int availableSpots() { return availableSpots; }
		
		/* Find a place to park this vehicle. Return false if failed. */
		public boolean parkVehicle(Vehicle vehicle) {}
		
		/* Park a vehicle starting at the spot spotNumber, and continuing until 
		 * vehicle.spotNeeded. */
		private boolean parkStartingAtSpot(int num, Vehicle v ) {}
		
		/* Find a spot to park this vehicle. Return index of spot, or -1 on failure. */
		private int findAvailableSpots(Vehicle vehicle) {}
		
		public void spotFreed() { availableSpots++; }
	}
	
	public class ParkingSpot {
		private Vehicle vehicle;
		private VehicleSize spotSize;
		private int row;
		private int spotNumber;
		private Level Level;
		
		public ParkingSpot(Vehicle vehicle, VehicleSize spotSize, int row, int spotNumber,
				Level level) {
			super();
			this.vehicle = vehicle;
			this.spotSize = spotSize;
			this.row = row;
			this.spotNumber = spotNumber;
			Level = level;
		}
		
		public boolean isAvailable() { return vehicle == null; }
	}
}
