package Model;

import java.util.List;

import Model.JsonBody;

public class Response {

	int status;
	Headers headers;
	List<JsonBody> jsonBody;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	public List<JsonBody> getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(List<JsonBody> jsonBody) {
		this.jsonBody = jsonBody;
	}

}
