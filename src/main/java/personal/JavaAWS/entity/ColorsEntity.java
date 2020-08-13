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
	@Column(name="colorimg")
	public String colorImg;
	@Column(name="title")
	public String title;
	@Column(name="price")
	public Double price;
	@Column(name="description")
	public String description;
}
