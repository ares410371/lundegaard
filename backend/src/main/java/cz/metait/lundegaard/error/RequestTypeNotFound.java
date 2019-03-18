package cz.metait.lundegaard.error;

public class RequestTypeNotFound extends RuntimeException {

  public RequestTypeNotFound(String type) {
    super("Request type {" + type + "} not found.");
  }
}
