package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom {
	@Id
    Integer id;
	
	@NotEmpty
	@Length(min = 3, max = 50)
	@Column(name = "name")
    String name;
    
	@NotEmpty
	@PositiveOrZero
	@Column(name = "size")
    double size;
    
    @NotEmpty
    @Column(name = "secure")
    boolean secure;
    
    @JoinColumn(name = "room_type_id")
    @ManyToOne(optional = false)
    RecoveryRoomType roomType;
}
