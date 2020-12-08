public class Receipt {
    String custname;
    double cost;
    private ArrayList<Customer> customerorders = new ArrayList<Customer>();

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }
    public ArrayList<Customer> getCustomerorders() {
        return customerorders;
    }

    public void setCustomerorders(ArrayList<Customer> customerorders) {
        this.customerorders = customerorders;
    }

    public void addCustomerorders(Customer order) {
        customerorders.add(order);
    }
}
