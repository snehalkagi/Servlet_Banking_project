package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class BankAccount 
{
	@Id
	@GeneratedValue(generator = "acno")
	@SequenceGenerator(initialValue = 1214567891,allocationSize = 1,sequenceName = "acno",name = "acno")
	long acno;
	String type;
	double amount;
	boolean status;
	double aclimit;
	
	@ManyToOne
	Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    List<banktransaction> banktransactions;

	public long getAcno() {
		return acno;
	}

	public void setAcno(long acno) {
		this.acno = acno;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public double getAclimit() {
		return aclimit;
	}

	public void setAclimit(double aclimit) {
		this.aclimit = aclimit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<banktransaction> getBanktransactions() {
		return banktransactions;
	}

	public void setBanktransactions(List<banktransaction> banktransactions) {
		this.banktransactions = banktransactions;
	}
    

}