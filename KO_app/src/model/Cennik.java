package model;



public class Cennik  {
private int idCennik;
private String pizza;
private String dodatkiPizza;
private String danie;
private String dodatkiDanie;
private String zupy;
private String napoje;
private String uwagi;
private String koszt;




public Cennik(String pizza, String dodatkiPizza, String danie, String dodatkiDanie, String zupy, String napoje,
		String uwagi, String koszt) {

	this.pizza = pizza;
	this.dodatkiPizza = dodatkiPizza;
	this.danie = danie;
	this.dodatkiDanie = dodatkiDanie;
	this.zupy = zupy;
	this.napoje = napoje;
	this.uwagi = uwagi;
	this.koszt = koszt;
}
public Cennik(int idCennik, String pizza, String dodatkiPizza, String danie, String dodatkiDanie, String zupy,
		String napoje, String uwagi, String koszt) {
	
	this.idCennik = idCennik;
	this.pizza = pizza;
	this.dodatkiPizza = dodatkiPizza;
	this.danie = danie;
	this.dodatkiDanie = dodatkiDanie;
	this.zupy = zupy;
	this.napoje = napoje;
	this.uwagi = uwagi;
	this.koszt = koszt;
}
public int getIdCennik() {
	return idCennik;
}
public void setIdCennik(int idCennik) {
	this.idCennik = idCennik;
}
public String getPizza() {
	return pizza;
}
public void setPizza(String pizza) {
	this.pizza = pizza;
}
public String getDodatkiPizza() {
	return dodatkiPizza;
}
public void setDodatkiPizza(String dodatkiPizza) {
	this.dodatkiPizza = dodatkiPizza;
}
public String getDanie() {
	return danie;
}
public void setDanie(String danie) {
	this.danie = danie;
}
public String getDodatkiDanie() {
	return dodatkiDanie;
}
public void setDodatkiDanie(String dodatkiDanie) {
	this.dodatkiDanie = dodatkiDanie;
}
public String getZupy() {
	return zupy;
}
public void setZupy(String zupy) {
	this.zupy = zupy;
}
public String getNapoje() {
	return napoje;
}
public void setNapoje(String napoje) {
	this.napoje = napoje;
}
public String getUwagi() {
	return uwagi;
}
public void setUwagi(String uwagi) {
	this.uwagi = uwagi;
}
public String getKoszt() {
	return koszt;
}
public void setKoszt(String koszt) {
	this.koszt = koszt;
}

}

