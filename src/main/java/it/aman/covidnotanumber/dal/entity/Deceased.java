package it.aman.covidnotanumber.dal.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the deceased database table.
 * 
 */
@Entity
@NamedQuery(name="Deceased.findAll", query="SELECT d FROM Deceased d")
public class Deceased implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deceased_id_seq_gen")
    @SequenceGenerator(name="deceased_id_seq_gen", sequenceName = "deceased_id_seq", allocationSize=1)
	private Integer id;

	private Integer age;

	private String city;

	private String email;

	private String gender;

	private String history;

	@Column(name="inserted_at")
	private OffsetDateTime insertedAt;

	private String name;

	private String occupation;

	private String photo;

	public Deceased() {
	    //
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHistory() {
		return this.history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OffsetDateTime getInsertedAt() {
		return this.insertedAt;
	}

	public void setInsertedAt(OffsetDateTime insertedAt) {
		this.insertedAt = insertedAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}