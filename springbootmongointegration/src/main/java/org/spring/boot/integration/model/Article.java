package org.spring.boot.integration.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Entity Class to hold all the table information
 * 
 * @author visakh
 *
 */
@Entity
@Table(name = "springboot")
@DynamicInsert(value = true)
@SelectBeforeUpdate(value = true)
@Document(collection = "springboot")
public class Article extends ArticleBase implements Serializable
{

	private static final long serialVersionUID = -3947365492881641252L;

	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "article_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Article_Gen")
	@TableGenerator(name = "Article_Gen", table = "SpringArticleId_Table", pkColumnName = "article_id_key", valueColumnName = "article_id_next_key", pkColumnValue = "article_id", initialValue = 1, allocationSize = 1)
	private int articleID;

	@Column(name = "\"MFR ID\"", nullable = true)
	private int mfrID;

	@Column(name = "\"CONTACT ID\"", nullable = true)
	private int contactID;

	@Column(name = "GEO_LOCATION", nullable = true)
	private String geo_Location;

	@Column(name = "\"Part's Generic No\"", nullable = true)
	private String partsGenericNo;

	@Column(name = "Technology", nullable = true)
	private String technology;

	@NotEmpty(message = "Article Description is required")
	@NotNull(message = "Article Description is required")
	@Column(name = "Description", nullable = false)
	@Lob
	private String description;

	@Column(name = "Application", nullable = true)
	private String application;

	@Column(name = "Available", nullable = true)
	private String available;

	@Column(name = "\"Product ID\"", nullable = true)
	private int productId;

	@Column(name = "\"Information Source\"", nullable = true)
	private String informationSource;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"Date of Publication\"", nullable = true)
	private Date dateOfPublication;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"Entered Date\"", nullable = true)
	private Date eneteredDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"Date of esol_publishing\"", nullable = true)
	private Date esolPublishing;

	@Column(name = "\"full name of the product\"", nullable = true)
	private String productFullName;

	@NotEmpty(message = "Article Title is required")
	@NotNull(message = "Article Title is required")
	@Column(name = "\"Article Title\"", nullable = false)
	private String articleTitle;

	@Column(name = "\"Edited article\"", nullable = true)
	private String editedArticle;

	@Column(name = "np_code", nullable = true)
	private String npCode;

	@Column(name = "Rating", nullable = true)
	private String rating;

	@Column(name = "EMITTSOL_CLASS", nullable = true)
	private String emittsolClass;

	@Column(name = "Speciality", nullable = true)
	private String speciality;

	@Column(name = "News", nullable = true)
	private String news;

	@Column(name = "\"Source url\"", nullable = true)
	private String sourceURL;

	@Column(name = "\"Image url\"", nullable = true)
	private String imageURL;

	@Column(name = "Image", nullable = true)
	@Lob
	private Blob image;

	@Column(name = "\"First Sentence\"", nullable = true)
	@Lob
	private Blob firstSentence;

	@Version
	@Column(name = "version")
	private Long version = 1L;

	@Transient
	private String articleStatus;

	public int getArticleID()
	{
		return articleID;
	}

	public void setArticleID(int articleID)
	{
		this.articleID = articleID;
	}

	public int getMfrID()
	{
		return mfrID;
	}

	public void setMfrID(int mfrID)
	{
		this.mfrID = mfrID;
	}

	public int getContactID()
	{
		return contactID;
	}

	public void setContactID(int contactID)
	{
		this.contactID = contactID;
	}

	public String getGeo_Location()
	{
		return geo_Location;
	}

	public void setGeo_Location(String geo_Location)
	{
		this.geo_Location = geo_Location;
	}

	public String getPartsGenericNo()
	{
		return partsGenericNo;
	}

	public void setPartsGenericNo(String partsGenericNo)
	{
		this.partsGenericNo = partsGenericNo;
	}

	public String getTechnology()
	{
		return technology;
	}

	public void setTechnology(String technology)
	{
		this.technology = technology;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getApplication()
	{
		return application;
	}

	public void setApplication(String application)
	{
		this.application = application;
	}

	public String getAvailable()
	{
		return available;
	}

	public void setAvailable(String available)
	{
		this.available = available;
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId)
	{
		this.productId = productId;
	}

	public String getInformationSource()
	{
		return informationSource;
	}

	public void setInformationSource(String informationSource)
	{
		this.informationSource = informationSource;
	}

	public Date getDateOfPublication()
	{
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication)
	{
		this.dateOfPublication = dateOfPublication;
	}

	public Date getEneteredDate()
	{
		return eneteredDate;
	}

	public void setEneteredDate(Date eneteredDate)
	{
		this.eneteredDate = eneteredDate;
	}

	public Date getEsolPublishing()
	{
		return esolPublishing;
	}

	public void setEsolPublishing(Date esolPublishing)
	{
		this.esolPublishing = esolPublishing;
	}

	public String getProductFullName()
	{
		return productFullName;
	}

	public void setProductFullName(String productFullName)
	{
		this.productFullName = productFullName;
	}

	public String getArticleTitle()
	{
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle)
	{
		this.articleTitle = articleTitle;
	}

	public String getEditedArticle()
	{
		return editedArticle;
	}

	public void setEditedArticle(String editedArticle)
	{
		this.editedArticle = editedArticle;
	}

	public String getNpCode()
	{
		return npCode;
	}

	public void setNpCode(String npCode)
	{
		this.npCode = npCode;
	}

	public String getRating()
	{
		return rating;
	}

	public void setRating(String rating)
	{
		this.rating = rating;
	}

	public String getEmittsolClass()
	{
		return emittsolClass;
	}

	public void setEmittsolClass(String emittsolClass)
	{
		this.emittsolClass = emittsolClass;
	}

	public String getSpeciality()
	{
		return speciality;
	}

	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}

	public String getNews()
	{
		return news;
	}

	public void setNews(String news)
	{
		this.news = news;
	}

	public String getSourceURL()
	{
		return sourceURL;
	}

	public void setSourceURL(String sourceURL)
	{
		this.sourceURL = sourceURL;
	}

	public String getImageURL()
	{
		return imageURL;
	}

	public void setImageURL(String imageURL)
	{
		this.imageURL = imageURL;
	}

	public Blob getImage()
	{
		return image;
	}

	public void setImage(Blob image)
	{
		this.image = image;
	}

	public Blob getFirstSentence()
	{
		return firstSentence;
	}

	public void setFirstSentence(Blob firstSentence)
	{
		this.firstSentence = firstSentence;
	}

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	@Transient
	public String getArticleStatus()
	{
		return articleStatus;
	}

	public void setArticleStatus(String articleStatus)
	{
		this.articleStatus = articleStatus;
	}

}
