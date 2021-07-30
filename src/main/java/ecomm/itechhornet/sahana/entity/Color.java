package ecomm.itechhornet.sahana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "color_name", nullable = false)
	String colorName;
	
	@Column(name = "display_name")
	String displayName;
	
	@Column(name = "color_code", nullable = false)
	String colorCode;
	
	public Long getId() {
		return id;
	}
	
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", colorName=" + colorName + ", displayName=" + displayName + ", colorCode="
				+ colorCode + "]";
	}
	
}
