package cz.metait.lundegaard.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestTypeResponse {

  private String text;
  private String value;
}
