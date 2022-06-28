package com.traning.bugtracker.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author vinugurt
 * Bug is entity
 * 
 *
 */
@Entity(name = "Bug")
@Data
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Bug implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnoreProperties 
	private Long id;
	@JsonProperty("bugDescription")
	private String bugDescription;
	@JsonProperty("createdDate")
	private Date createdDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = "id")
	@JsonProperty("createdBy")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Employee createdBy;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = "id")
	@JsonProperty("status")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private BugStatus status;

}
