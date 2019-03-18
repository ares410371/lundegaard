package cz.metait.lundegaard.request;

import lombok.Data;

@Data
public class FormRequest {

  private String policyNumber;
  private String name;
  private String surname;
  private String request;
  private String requestType;
}
