package cz.metait.lundegaard.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "request_type")
public class RequestType extends BaseEntity {

  @Column(name = "name")
  private String name;
}
