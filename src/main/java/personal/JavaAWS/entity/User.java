package personal.JavaAWS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity (name = "User")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
}
