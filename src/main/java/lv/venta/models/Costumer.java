package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Table(name = "product_table") //DB pusē izveidosies tabula
@Entity
public class Costumer {
	
	@Column(name = "Idc")  //DB pusē būs kolona "id" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idc;
	
	@Column(name = "Name") //DB pusē kolonna "Title"
	@NotNull
	@Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+")
	private String name;
	
	@Column(name = "surname") //DB pusē kolonna "Title"
	@NotNull
	@Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+")
	private String surname;
	
	@OneToMany(mappedBy = "costumer") //sasaista ar mainīgo no otras puses
	private Collection<Product> allProducts;

}
