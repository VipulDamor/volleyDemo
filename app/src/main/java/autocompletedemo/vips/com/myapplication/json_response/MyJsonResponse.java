package autocompletedemo.vips.com.myapplication.json_response;

import com.google.gson.annotations.SerializedName;

public class MyJsonResponse{

	@SerializedName("account")
	private Account account;

	@SerializedName("status")
	private Status status;

	public void setAccount(Account account){
		this.account = account;
	}

	public Account getAccount(){
		return account;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"MyJsonResponse{" + 
			"account = '" + account + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}