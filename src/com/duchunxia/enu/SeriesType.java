package com.duchunxia.enu;

public enum SeriesType {
BAR("BAR","bar"),PIE("PIE","pie");
String text;
String value;
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
private SeriesType(String text, String value) {
	this.text = text;
	this.value = value;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}

}
