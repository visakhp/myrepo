package org.spring.boot.consumer.service.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

/**
 * Entity Class to hold all the table information
 * 
 * @author visakh
 *
 */
public class Article extends ArticleBase implements Serializable
{

	private static final long serialVersionUID = -3947365492881641252L;

	private int articleID;

	private int mfrID;

	private int contactID;

	private String geo_Location;

	private String partsGenericNo;

	private String technology;

	private String description;

	private String application;

	private String available;

	private int productId;

	private String informationSource;

	private Date dateOfPublication;

	private Date eneteredDate;

	private Date esolPublishing;

	private String productFullName;

	private String articleTitle;

	private String editedArticle;

	private String npCode;

	private String rating;

	private String emittsolClass;

	private String speciality;

	private String news;

	private String sourceURL;

	private String imageURL;

	private Blob image;

	private Blob firstSentence;

	private Long version = 1L;

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

	public String getArticleStatus()
	{
		return articleStatus;
	}

	public void setArticleStatus(String articleStatus)
	{
		this.articleStatus = articleStatus;
	}

}
