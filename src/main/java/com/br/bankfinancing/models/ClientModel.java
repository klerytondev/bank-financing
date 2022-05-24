package com.br.bankfinancing.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.bankfinancing.models.enums.StatusClient;

@Entity
@Table(name = "TB_CLIENT")
public class ClientModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String name;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private StatusClient status;
	@Column(nullable = false)
	private Date dateCreation;
	@Column(nullable = false)
	private Date updateDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "fk_financing"))
	private Set<FinancingModel> financingModels;
	
	

	public ClientModel(String name, String email, StatusClient status, Date dateCreation, Date updateDate) {
		this.name = name;
		this.email = email;
		this.status = status;
		this.dateCreation = dateCreation;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StatusClient getStatus() {
		return status;
	}

	public void setStatus(StatusClient status) {
		this.status = status;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Set<FinancingModel> getFinancingModels() {
		return financingModels;
	}
	public void setFinancingModels(FinancingModel financingModels) {
		this.financingModels.add(financingModels);
	}

}
