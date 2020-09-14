package com.grokonez.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="datetimemodel")
public class DateTimeModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateTime;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Paris")
	private Date dateTimeWithZone;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTimeDefaultFormat;

	public DateTimeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateTimeModel(Date date, Date dateTime, Date dateTimeWithZone, Date dateTimeDefaultFormat) {
		super();
		this.date = date;
		this.dateTime = dateTime;
		this.dateTimeWithZone = dateTimeWithZone;
		this.dateTimeDefaultFormat = dateTimeDefaultFormat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Date getDateTimeWithZone() {
		return dateTimeWithZone;
	}

	public void setDateTimeWithZone(Date dateTimeWithZone) {
		this.dateTimeWithZone = dateTimeWithZone;
	}

	public Date getDateTimeDefaultFormat() {
		return dateTimeDefaultFormat;
	}

	public void setDateTimeDefaultFormat(Date dateTimeDefaultFormat) {
		this.dateTimeDefaultFormat = dateTimeDefaultFormat;
	}
	
	
	
}
