package ecomm.itechhornet.sahana.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(name = "img_name")
	String imgName;
	
	@Column(name = "img_path", nullable = false)
	String imgPath;
	
	@Column(name = "priority")
	String priority;
	
	@Column(name = "thumbnail_img")
	String thumbnail_img;
	
	//@NotNull
	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Product product;
	
	@ManyToOne
	@JoinColumn(name="color_id", updatable = false, insertable = false)
	private Color color;
	
	
	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getThumbnail_img() {
		return thumbnail_img;
	}


	public void setThumbnail_img(String thumbnail_img) {
		this.thumbnail_img = thumbnail_img;
	}

/*
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
*/

	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

	public Long getId() {
		return id;
	}	
}
