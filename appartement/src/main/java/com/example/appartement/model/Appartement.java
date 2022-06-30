/**
 * 
 */
package com.example.appartement.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * @author User
 *
 */
public class Appartement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	private Integer supperficie;
	private Integer numero;
	private String adresse;
	private String type;
	private Boolean meuble;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the supperficie
	 */
	public Integer getSupperficie() {
		return supperficie;
	}
	/**
	 * @param supperficie the supperficie to set
	 */
	public void setSupperficie(Integer supperficie) {
		this.supperficie = supperficie;
	}
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the meuble
	 */
	public Boolean getMeuble() {
		return meuble;
	}
	/**
	 * @param meuble the meuble to set
	 */
	public void setMeuble(Boolean meuble) {
		this.meuble = meuble;
	}
	
	
	

}
