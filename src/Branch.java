import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;
    
    
    public String getName() {
        return name;
    }

    
    /**
     * @return the customers
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }



    public Branch(String name) {
        this.name = name;
        this.customers=new ArrayList<Customer>();
    }
    
    public boolean newCustomer(String customerName,double initialAmount){
        if(findCustomer(customerName)==null){
            this.customers.add(new Customer(customerName,initialAmount));
            return true;
        }
        return false;
    }
    public boolean addCustomerTransaction(String customerName,double amount){
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer!=null){
        existingCustomer.addTransactions(amount);
         return true;
        }
        return false;
    }

    private Customer findCustomer(String customerName){
        for (int index = 0; index < customers.size(); index++) {
            Customer checkedCustomer = this.customers.get(index);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}
