package com.mitchell.automobileservice.dto;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"make",
"model",
"year"
})
public class VehicleDTO {

	@JsonProperty("id")
	private String id;
	@JsonProperty("make")
	private String make;
	@JsonProperty("model")
	private String model;
	@JsonProperty("year")
	private Integer year;

	@JsonProperty("id")
	public String getId() {
	return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
	this.id = id;
	}

	@JsonProperty("make")
	public String getMake() {
	return make;
	}

	@JsonProperty("make")
	public void setMake(String make) {
	this.make = make;
	}

	@JsonProperty("model")
	public String getModel() {
	return model;
	}

	@JsonProperty("model")
	public void setModel(String model) {
	this.model = model;
	}

	@JsonProperty("year")
	public Integer getYear() {
	return year;
	}

	@JsonProperty("year")
	public void setYear(Integer year) {
	this.year = year;
	}

	@Override
	public String toString() {
	return new ToStringBuilder(this).append("id", id).append("make", make).append("model", model).append("year", year).toString();
	}

	@Override
	public int hashCode() {
	return new HashCodeBuilder().append(model).append(id).append(make).append(year).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
	if (other == this) {
		return true;
	}
	if ((other instanceof VehicleDTO) == false) {
	return false;
	}
	VehicleDTO rhs = (VehicleDTO) other;
	return new EqualsBuilder().append(model, rhs.model).append(id, rhs.id).append(make, rhs.make).append(year, rhs.year).isEquals();
	}

	}
