package com.jackRev.springdemo.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favLanguage;
	private String[] operatingSystems;

	private LinkedHashMap<String, String> operatingSystemOptions;

	private LinkedHashMap<String, String> favoriteLanguageOptions;

	private LinkedHashMap<String, String> countryOptions;

	public Student() {

		// populate country options : used ISO country code

		countryOptions = new LinkedHashMap<String, String>();

		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "United States");

		favoriteLanguageOptions = new LinkedHashMap<>();

		// parameter order: value, display label
		//
		favoriteLanguageOptions.put("Java", "Java");
		favoriteLanguageOptions.put("C#", "C#");
		favoriteLanguageOptions.put("PHP", "PHP");
		favoriteLanguageOptions.put("Ruby", "Ruby");

		operatingSystemOptions = new LinkedHashMap<String, String>();

		operatingSystemOptions.put("Linux", "Linux");
		operatingSystemOptions.put("Windows", "Windows");
		operatingSystemOptions.put("Mac OS", "Mac OS");

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavLanguage() {
		return favLanguage;
	}

	public void setFavLanguage(String favLanguage) {
		this.favLanguage = favLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getOperatingSystemOptions() {
		return operatingSystemOptions;
	}

}
