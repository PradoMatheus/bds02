package com.devsuperior.dbs02.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tb_event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate date;
	private String url;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	public Event() {
	}

	public Event(Long id, String name, LocalDate date, String url, City city) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.url = url;
		this.city = city;
	}
}
