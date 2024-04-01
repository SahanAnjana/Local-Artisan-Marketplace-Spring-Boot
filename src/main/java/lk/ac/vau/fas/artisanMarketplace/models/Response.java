package lk.ac.vau.fas.artisanMarketplace.models;

import org.springframework.stereotype.Component;

@Component
public class Response {
	private String code;
    private String message;
    private Object content;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String code, String message, Object content) {
		super();
		this.code = code;
		this.message = message;
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
    
}
