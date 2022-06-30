public class Table {
    private boolean occupied;
    private Person seated;

    public boolean isOccupied() {
        return occupied;
    }

    private void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void seatCustomer(Person seated)
    {
        setOccupied(true);
        this.seated = seated;
        System.out.println(seated.fName + " " + seated.lName + " has been seated.");
    }
    public void removeCustomer()
    {
        setOccupied(false);
        System.out.println(seated.fName + " " + seated.lName + " has left the table.");
        this.seated = null;

    }
}
