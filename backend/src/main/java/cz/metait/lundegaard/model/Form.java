package cz.metait.lundegaard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "form")
public class Form extends BaseEntity {

  @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Allowed only alphanumeric characters")
  @Column(name = "policyNumber")
  private String policyNumber;
  @Pattern(regexp = "^[A-Za-z]+$", message = "Allowed only alphabetic characters")
  @Column(name = "name")
  private String name;
  @Pattern(regexp = "^[A-Za-z]+$", message = "Allowed only alphabetic characters")
  @Column(name = "surname")
  private String surname;
  @Size(max = 2000, message = "Max lenght is 2000 characters")
  @Column(name = "request")
  private String request;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "requestType")
  private RequestType requestType;
}
