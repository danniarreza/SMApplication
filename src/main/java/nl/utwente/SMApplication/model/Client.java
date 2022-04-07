package nl.utwente.SMApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;
    private String companyName;
    private String branchAddress;

    public Client(){}

    public Client(String companyName, int branchId, String branchAddress) {
        this.companyName = companyName;
        this.branchId = branchId;
        this.branchAddress = branchAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
