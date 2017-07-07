package com.bean;



public class Country {


	/**
	 * Default country code for the country.
	 */
	private String iso3166;
	/**
	 * Default country code for the telephone numbers
	 */
	private String phoneCode;
	/**
	 * Default language for the country
	 */
	private String lang;
	/**
	 * GMT value for the country
	 */
	private String GMT;
	/**
	 * Name of the country
	 */
	private String name;
	/**
	 * Status of the country
	 */
	private Integer valid;
	/**
	 * Currency of the country
	 */
	private String currency;
	
	/**
	 * smsNumber
	 */
	private String smsNumber;

	/**
	 * smsNumber
	 */
	private String mobileConnector;

	/**
     * Check whether the country is valid
     */
    public static final int COUNTRY_VALID = 1;
	/**
	 * 
	 * @return String
	 */
	public String getIso3166() {
		return iso3166;
	}
	/**
	 * 
	 * @param iso3166
	 */
	public void setIso3166(String iso3166) {
		this.iso3166 = iso3166;
	}
	/**
	 * 
	 * @return String
	 */
	public String getPhoneCode() {
		return phoneCode;
	}
	/**
	 * 
	 * @param phoneCode
	 */
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	/**
	 * 
	 * @return String
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * 
	 * @param lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/**
	 * 
	 * @return String
	 */
	public String getGMT() {
		return GMT;
	}
	/**
	 * 
	 * @param GMT
	 */
	public void setGMT(String GMT) {
		this.GMT = GMT;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return valid
	 */
	public Integer getValid() {
		return valid;
	}
	/**
	 * 
	 * @param valid
	 */
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	/**
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * 
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
		
	/**
	 * @return the smsNumber
	 */
	public String getSmsNumber() {
		return smsNumber;
	}
	/**
	 * @param smsNumber the smsNumber to set
	 */
	public void setSmsNumber(String smsNumber) {
		this.smsNumber = smsNumber;
	}
	/**
	 * @return the mobileConnector
	 */
	public String getMobileConnector() {
		return mobileConnector;
	}
	/**
	 * @param mobileConnector the mobileConnector to set
	 */
	public void setMobileConnector(String mobileConnector) {
		this.mobileConnector = mobileConnector;
	}

}