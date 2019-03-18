package cz.metait.lundegaard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "form")
public class Form extends BaseEntity {

  @Pattern(regexp = "^[A-Za-z0-9]+$")
  @Column(name = "policyNumber")
  private String policyNumber;
  @Pattern(regexp = "^[A-Za-z]+$")
  @Column(name = "name")
  private String name;
  @Pattern(regexp = "^[A-Za-z]+$")
  @Column(name = "surname")
  private String surname;
  @Max(value = 2000)
  @Column(name = "request")
  private String request;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "requestType")
  private RequestType requestType;
}
