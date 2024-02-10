package com.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Entry {
	@Id
	@JsonProperty
	private String API;
	@JsonProperty
	private String Description;
	@JsonProperty
	private String Auth;
	@JsonProperty
	private boolean HTTPS;
	@JsonProperty
	private String Cors;
	@JsonProperty
	private String Link;
	@JsonProperty
	private String Category;	
}
