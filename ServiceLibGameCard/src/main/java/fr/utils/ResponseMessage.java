package fr.utils;

public class ResponseMessage<T> {
    private T response;
    private String Message = "";
    private int responseCode = 0;

    public ResponseMessage(T response) {
        this.response = response;
    }

    public ResponseMessage() {
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isSuccess()
    {
        return getResponseCode() == ResponseCode.SUCCESS;
    }

    public <M> ResponseMessage<M> toType(M data) {
        ResponseMessage<M> responseMessage = new ResponseMessage<>(data);
        responseMessage.setMessage(this.getMessage());
        responseMessage.setResponseCode(this.getResponseCode());
        return responseMessage;
    }

    public <M> ResponseMessage<M> toNull() {
        ResponseMessage<M> responseMessage = new ResponseMessage<>(null);
        responseMessage.setMessage(this.getMessage());
        responseMessage.setResponseCode(this.getResponseCode());
        return responseMessage;
    }
}