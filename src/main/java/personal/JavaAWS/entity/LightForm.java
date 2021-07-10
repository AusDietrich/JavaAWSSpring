package personal.JavaAWS.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Component
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightForm {

	public String ledNum;
	public String red;
	public String green;
	public String blue;
}
