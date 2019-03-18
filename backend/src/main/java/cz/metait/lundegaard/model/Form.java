package cz.metait.lundegaard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Log4j2
@Getter
@Setter
@Entity
@Table(name = "form")
public class Form extends BaseEntity {

  @Column(name = "policyNumber")
  private String policyNumber;
  @Column(name = "name")
  private String name;
  @Column(name = "surname")
  private String surname;
  @Column(name = "request")
  private String request;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "requestType")
  private RequestType requestType;
}
