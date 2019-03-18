package cz.metait.lundegaard.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@MappedSuperclass
@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
public class BaseEntity implements Serializable {

  @Id
  @GeneratedValue(generator="hibernate_sequence")
  protected Long id;
}
