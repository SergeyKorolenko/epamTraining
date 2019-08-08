package by.epam.task4.validator;

public class DataValidator {

    public boolean isCargoAircraft(String[] data) {
        try {
            String producer = data[1];
            String model = data[2];
            int cruisingSpeed = Integer.parseInt(data[3]);
            int maxHeight = Integer.parseInt(data[4]);
            int flightRange = Integer.parseInt(data[5]);
            double fuelConsumption = Double.parseDouble(data[6]);
            double loadCapacity = Double.parseDouble(data[7]);
            if(cruisingSpeed <= 0 || maxHeight <= 0 || flightRange <= 0 ||
                    fuelConsumption <= 0.0 || loadCapacity <= 0.0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public boolean isPassengerAircraft(String[] data) {
        try {
            String producer = data[1];
            String model = data[2];
            int cruisingSpeed = Integer.parseInt(data[3]);
            int maxHeight = Integer.parseInt(data[4]);
            int flightRange = Integer.parseInt(data[5]);
            double fuelConsumption = Double.parseDouble(data[6]);
            int capacity = Integer.parseInt(data[7]);
            if(cruisingSpeed <= 0 || maxHeight <= 0 || flightRange <= 0 || fuelConsumption <= 0.0 || capacity <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
}
