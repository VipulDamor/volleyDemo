package autocompletedemo.vips.com.myapplication.json_response;

import com.google.gson.annotations.SerializedName;

public class Account{

	@SerializedName("default")
	private boolean jsonMemberDefault;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private Type type;

	public void setJsonMemberDefault(boolean jsonMemberDefault){
		this.jsonMemberDefault = jsonMemberDefault;
	}

	public boolean isJsonMemberDefault(){
		return jsonMemberDefault;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(Type type){
		this.type = type;
	}

	public Type getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Account{" + 
			"default = '" + jsonMemberDefault + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}