package personal.JavaAWS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity (name = "Colors")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorsEntity {

	@Id
	@Column(name="id")
	public int id;
	@Column(name="colors")
	public String colors;
	@Column(name="price")
	public double price;
	@Column(name="description")
	public String description;
}
