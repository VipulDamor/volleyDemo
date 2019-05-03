package autocompletedemo.vips.com.myapplication.json_response;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("reservedAmount")
	private int reservedAmount;

	@SerializedName("balance")
	private int balance;

	@SerializedName("formattedCreditLimit")
	private String formattedCreditLimit;

	@SerializedName("formattedAvailableBalance")
	private String formattedAvailableBalance;

	@SerializedName("creditLimit")
	private int creditLimit;

	@SerializedName("formattedBalance")
	private String formattedBalance;

	@SerializedName("formattedReservedAmount")
	private String formattedReservedAmount;

	@SerializedName("availableBalance")
	private int availableBalance;

	public void setReservedAmount(int reservedAmount){
		this.reservedAmount = reservedAmount;
	}

	public int getReservedAmount(){
		return reservedAmount;
	}

	public void setBalance(int balance){
		this.balance = balance;
	}

	public int getBalance(){
		return balance;
	}

	public void setFormattedCreditLimit(String formattedCreditLimit){
		this.formattedCreditLimit = formattedCreditLimit;
	}

	public String getFormattedCreditLimit(){
		return formattedCreditLimit;
	}

	public void setFormattedAvailableBalance(String formattedAvailableBalance){
		this.formattedAvailableBalance = formattedAvailableBalance;
	}

	public String getFormattedAvailableBalance(){
		return formattedAvailableBalance;
	}

	public void setCreditLimit(int creditLimit){
		this.creditLimit = creditLimit;
	}

	public int getCreditLimit(){
		return creditLimit;
	}

	public void setFormattedBalance(String formattedBalance){
		this.formattedBalance = formattedBalance;
	}

	public String getFormattedBalance(){
		return formattedBalance;
	}

	public void setFormattedReservedAmount(String formattedReservedAmount){
		this.formattedReservedAmount = formattedReservedAmount;
	}

	public String getFormattedReservedAmount(){
		return formattedReservedAmount;
	}

	public void setAvailableBalance(int availableBalance){
		this.availableBalance = availableBalance;
	}

	public int getAvailableBalance(){
		return availableBalance;
	}

	@Override
 	public String toString(){
		return 
			"Status{" + 
			"reservedAmount = '" + reservedAmount + '\'' + 
			",balance = '" + balance + '\'' + 
			",formattedCreditLimit = '" + formattedCreditLimit + '\'' + 
			",formattedAvailableBalance = '" + formattedAvailableBalance + '\'' + 
			",creditLimit = '" + creditLimit + '\'' + 
			",formattedBalance = '" + formattedBalance + '\'' + 
			",formattedReservedAmount = '" + formattedReservedAmount + '\'' + 
			",availableBalance = '" + availableBalance + '\'' + 
			"}";
		}
}