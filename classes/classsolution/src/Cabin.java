public class Cabin {
    private int cabinNumber;
    private int passengersCount;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    public Cabin(){
        setCabinNumber(0);
        setPassengersCount(0);
        setPassenger1(new Passenger());
        setPassenger2(new Passenger());
        setPassenger3(new Passenger());
    }

    public Cabin(int cabinNumber, int passengersCount) {
        this.setCabinNumber(cabinNumber);
        this.setPassengersCount(passengersCount);
        this.setPassenger1(new Passenger());
        this.setPassenger2(new Passenger());
        this.setPassenger3(new Passenger());
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public Passenger getPassenger1() {
        return passenger1;
    }

    public void setPassenger1(Passenger passenger1) {
        this.passenger1 = passenger1;
    }

    public Passenger getPassenger2() {
        return passenger2;
    }

    public void setPassenger2(Passenger passenger2) {
        this.passenger2 = passenger2;
    }

    public Passenger getPassenger3() {
        return passenger3;
    }

    public void setPassenger3(Passenger passenger3) {
        this.passenger3 = passenger3;
    }
}
