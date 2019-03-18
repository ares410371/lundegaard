package cz.metait.lundegaard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Log4j2
@Setter
@Getter
@Entity
@Table(name = "request_type")
public class RequestType extends BaseEntity {

  @Column(name = "name")
  private String name;
}
