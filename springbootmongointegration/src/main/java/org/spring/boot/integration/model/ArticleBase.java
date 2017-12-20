package org.spring.boot.integration.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author visakh
 *
 */
@MappedSuperclass
public class ArticleBase implements Serializable
{

	private static final long serialVersionUID = -3947365492881641252L;

	@Column(name = "\"Product's top feature1\"", nullable = true)
	private String topFeature1;

	@Column(name = "\"Product's top feature2\"", nullable = true)
	private String topFeature2;

	@Column(name = "\"Product's top feature3\"", nullable = true)
	private String topFeature3;

	@Column(name = "Speed", nullable = true)
	private String speed;

	@Column(name = "Integration", nullable = true)
	private String integration;

	@Column(name = "Size", nullable = true)
	private String size;

	@Column(name = "Material", nullable = true)
	private String material;

	@Column(name = "Standards", nullable = true)
	private String standards;

	@Column(name = "Environment", nullable = true)
	private String environment;

	@Column(name = "Applications", nullable = true)
	private String applications;

	@Column(name = "\"Product Name\"", nullable = true)
	private String productName;

	@Column(name = "Popularity", nullable = true)
	private String popularity;

	@Column(name = "Reliability", nullable = true)
	private String reliability;

	@Column(name = "Comments1", nullable = true, length = 100000)
	@Lob
	private String comments1;

	@Column(name = "Comments2", nullable = true, length = 100000)
	@Lob
	private String comments2;

	@Column(name = "Comments3", nullable = true, length = 100000)
	@Lob
	private String comments3;

	@Column(name = "Product_interface", nullable = true)
	private String productInterface;

	@Column(name = "Package", nullable = true)
	private String pack;

	@Column(name = "Availability", nullable = true)
	private String availability;

	@Column(name = "\"RoHS/Lead-Free\"", nullable = true)
	private String rohsLeadFree;

	@Column(name = "\"Listed Price\"", nullable = true)
	private String listedPrice;

	@Column(name = "Other_Specs_features", nullable = true, length = 100000)
	@Lob
	private String otherSpecsFeatures;

	@Column(name = "tstring21", nullable = true)
	private String tstring21;

	@Column(name = "Product_Rating", nullable = true)
	private String productRating;

	@Column(name = "Market_Research", nullable = true, length = 100000)
	@Lob
	private String marketResearch;

	@Column(name = "Other_products_in_the_market", nullable = true, length = 100000)
	@Lob
	private String otherProducts;

	@Column(name = "tstring25", nullable = true)
	private String tstring25;

	@Column(name = "QA", nullable = true, columnDefinition = "boolean default false")
	private boolean QA;

	@Column(name = "Published", nullable = true, columnDefinition = "boolean default false")
	private boolean published;

	@Column(name = "Editor", nullable = true)
	private String editor;

	@Column(name = "Edited", nullable = true, columnDefinition = "boolean default false")
	private boolean edited;

	@Column(name = "HTML", nullable = true, columnDefinition = "boolean default false")
	private boolean html;

	@Column(name = "\"Text Separator\"", nullable = true)
	private String textSeparator;

	@Column(name = "\"HTML code\"", nullable = true)
	private String htmlCode;

	@Column(name = "NPNWID", nullable = true)
	private String NPNWID;

	@Column(name = "print_word", nullable = true, columnDefinition = "boolean default false")
	private boolean print_Word;

	@Column(name = "Prelim_edit", nullable = true, columnDefinition = "boolean default false")
	private boolean prelim_Edit;

	@Column(name = "cleaned", nullable = true, columnDefinition = "boolean default false")
	private boolean cleaned;

	@Column(name = "ssarticle", nullable = true, columnDefinition = "boolean default false")
	private boolean ssarticle;

	@Column(name = "Keyword1", nullable = true)
	private String keyword1;

	@Column(name = "Keyword2", nullable = true)
	private String keyword2;

	@Column(name = "filter", nullable = true, columnDefinition = "boolean default false")
	private boolean filter;

	@Column(name = "mcu", nullable = true, columnDefinition = "boolean default false")
	private boolean mcu;

	@Column(name = "star", nullable = true, columnDefinition = "boolean default false")
	private boolean star;

	@Column(name = "\"repeat\"", nullable = true, columnDefinition = "boolean default false")
	private boolean repeat;

	@Column(name = "processor", nullable = true, columnDefinition = "boolean default false")
	private boolean processor;

	@Column(name = "memory", nullable = true, columnDefinition = "boolean default false")
	private boolean memory;

	@Column(name = "analog", nullable = true, columnDefinition = "boolean default false")
	private boolean analog;

	@Column(name = "logic", nullable = true, columnDefinition = "boolean default false")
	private boolean logic;

	@Column(name = "pld", nullable = true, columnDefinition = "boolean default false")
	private boolean pld;

	@Column(name = "powersupply", nullable = true, columnDefinition = "boolean default false")
	private boolean powersupply;

	@Column(name = "automotive", nullable = true, columnDefinition = "boolean default false")
	private boolean automotive;

	@Column(name = "cellphone", nullable = true, columnDefinition = "boolean default false")
	private boolean cellphone;

	@Column(name = "consumer", nullable = true, columnDefinition = "boolean default false")
	private boolean consumer;

	@Column(name = "computer", nullable = true, columnDefinition = "boolean default false")
	private boolean computer;

	@Column(name = "communication", nullable = true, columnDefinition = "boolean default false")
	private boolean communication;

	@Column(name = "rf", nullable = true, columnDefinition = "boolean default false")
	private boolean rf;

	@Column(name = "subsys", nullable = true, columnDefinition = "boolean default false")
	private boolean subsys;

	@Column(name = "refdesign", nullable = true, columnDefinition = "boolean default false")
	private boolean refdesign;

	@Column(name = "software", nullable = true, columnDefinition = "boolean default false")
	private boolean software;

	@Column(name = "test", nullable = true, columnDefinition = "boolean default false")
	private boolean test;

	@Column(name = "discrete", nullable = true, columnDefinition = "boolean default false")
	private boolean discrete;

	@Column(name = "opto", nullable = true, columnDefinition = "boolean default false")
	private boolean opto;

	@Column(name = "passive", nullable = true, columnDefinition = "boolean default false")
	private boolean passive;

	@Column(name = "interconnect", nullable = true, columnDefinition = "boolean default false")
	private boolean interconnect;

	@Column(name = "sensors", nullable = true, columnDefinition = "boolean default false")
	private boolean sensors;

	@Column(name = "battery", nullable = true, columnDefinition = "boolean default false")
	private boolean battery;

	@Column(name = "India", nullable = true, columnDefinition = "boolean default false")
	private boolean india;

	@Column(name = "student", nullable = true, columnDefinition = "boolean default false")
	private boolean student;

	@Column(name = "medical", nullable = true, columnDefinition = "boolean default false")
	private boolean medical;

	@Column(name = "security", nullable = true, columnDefinition = "boolean default false")
	private boolean security;

	@Column(name = "aerospace", nullable = true, columnDefinition = "boolean default false")
	private boolean aerospace;

	@Column(name = "solar", nullable = true, columnDefinition = "boolean default false")
	private boolean solar;

	@Column(name = "market", nullable = true, columnDefinition = "boolean default false")
	private boolean market;

	@Column(name = "dcdcconverter", nullable = true, columnDefinition = "boolean default false")
	private boolean dcdcconverter;

	@Column(name = "Indiasemiconductor", nullable = true, columnDefinition = "boolean default false")
	private boolean indiaSemiConductor;

	@Column(name = "embeddedcomputer", nullable = true, columnDefinition = "boolean default false")
	private boolean embeddedcomputer;

	public String getTopFeature1()
	{
		return topFeature1;
	}

	public void setTopFeature1(String topFeature1)
	{
		this.topFeature1 = topFeature1;
	}

	public String getTopFeature2()
	{
		return topFeature2;
	}

	public void setTopFeature2(String topFeature2)
	{
		this.topFeature2 = topFeature2;
	}

	public String getTopFeature3()
	{
		return topFeature3;
	}

	public void setTopFeature3(String topFeature3)
	{
		this.topFeature3 = topFeature3;
	}

	public String getSpeed()
	{
		return speed;
	}

	public void setSpeed(String speed)
	{
		this.speed = speed;
	}

	public String getIntegration()
	{
		return integration;
	}

	public void setIntegration(String integration)
	{
		this.integration = integration;
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public String getMaterial()
	{
		return material;
	}

	public void setMaterial(String material)
	{
		this.material = material;
	}

	public String getStandards()
	{
		return standards;
	}

	public void setStandards(String standards)
	{
		this.standards = standards;
	}

	public String getEnvironment()
	{
		return environment;
	}

	public void setEnvironment(String environment)
	{
		this.environment = environment;
	}

	public String getApplications()
	{
		return applications;
	}

	public void setApplications(String applications)
	{
		this.applications = applications;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getPopularity()
	{
		return popularity;
	}

	public void setPopularity(String popularity)
	{
		this.popularity = popularity;
	}

	public String getReliability()
	{
		return reliability;
	}

	public void setReliability(String reliability)
	{
		this.reliability = reliability;
	}

	public String getComments1()
	{
		return comments1;
	}

	public void setComments1(String comments1)
	{
		this.comments1 = comments1;
	}

	public String getComments2()
	{
		return comments2;
	}

	public void setComments2(String comments2)
	{
		this.comments2 = comments2;
	}

	public String getComments3()
	{
		return comments3;
	}

	public void setComments3(String comments3)
	{
		this.comments3 = comments3;
	}

	public String getProductInterface()
	{
		return productInterface;
	}

	public void setProductInterface(String productInterface)
	{
		this.productInterface = productInterface;
	}

	public String getPack()
	{
		return pack;
	}

	public void setPack(String pack)
	{
		this.pack = pack;
	}

	public String getAvailability()
	{
		return availability;
	}

	public void setAvailability(String availability)
	{
		this.availability = availability;
	}

	public String getRohsLeadFree()
	{
		return rohsLeadFree;
	}

	public void setRohsLeadFree(String rohsLeadFree)
	{
		this.rohsLeadFree = rohsLeadFree;
	}

	public String getListedPrice()
	{
		return listedPrice;
	}

	public void setListedPrice(String listedPrice)
	{
		this.listedPrice = listedPrice;
	}

	public String getOtherSpecsFeatures()
	{
		return otherSpecsFeatures;
	}

	public void setOtherSpecsFeatures(String otherSpecsFeatures)
	{
		this.otherSpecsFeatures = otherSpecsFeatures;
	}

	public String getTstring21()
	{
		return tstring21;
	}

	public void setTstring21(String tstring21)
	{
		this.tstring21 = tstring21;
	}

	public String getProductRating()
	{
		return productRating;
	}

	public void setProductRating(String productRating)
	{
		this.productRating = productRating;
	}

	public String getMarketResearch()
	{
		return marketResearch;
	}

	public void setMarketResearch(String marketResearch)
	{
		this.marketResearch = marketResearch;
	}

	public String getOtherProducts()
	{
		return otherProducts;
	}

	public void setOtherProducts(String otherProducts)
	{
		this.otherProducts = otherProducts;
	}

	public String getTstring25()
	{
		return tstring25;
	}

	public void setTstring25(String tstring25)
	{
		this.tstring25 = tstring25;
	}

	public boolean isQA()
	{
		return QA;
	}

	public void setQA(boolean qA)
	{
		QA = qA;
	}

	public boolean isPublished()
	{
		return published;
	}

	public void setPublished(boolean published)
	{
		this.published = published;
	}

	public String getEditor()
	{
		return editor;
	}

	public void setEditor(String editor)
	{
		this.editor = editor;
	}

	public boolean isEdited()
	{
		return edited;
	}

	public void setEdited(boolean edited)
	{
		this.edited = edited;
	}

	public boolean isHtml()
	{
		return html;
	}

	public void setHtml(boolean html)
	{
		this.html = html;
	}

	public String getTextSeparator()
	{
		return textSeparator;
	}

	public void setTextSeparator(String textSeparator)
	{
		this.textSeparator = textSeparator;
	}

	public String getHtmlCode()
	{
		return htmlCode;
	}

	public void setHtmlCode(String htmlCode)
	{
		this.htmlCode = htmlCode;
	}

	public String getNPNWID()
	{
		return NPNWID;
	}

	public void setNPNWID(String nPNWID)
	{
		NPNWID = nPNWID;
	}

	public boolean isPrint_Word()
	{
		return print_Word;
	}

	public void setPrint_Word(boolean print_Word)
	{
		this.print_Word = print_Word;
	}

	public boolean isPrelim_Edit()
	{
		return prelim_Edit;
	}

	public void setPrelim_Edit(boolean prelim_Edit)
	{
		this.prelim_Edit = prelim_Edit;
	}

	public boolean isCleaned()
	{
		return cleaned;
	}

	public void setCleaned(boolean cleaned)
	{
		this.cleaned = cleaned;
	}

	public boolean isSsarticle()
	{
		return ssarticle;
	}

	public void setSsarticle(boolean ssarticle)
	{
		this.ssarticle = ssarticle;
	}

	public String getKeyword1()
	{
		return keyword1;
	}

	public void setKeyword1(String keyword1)
	{
		this.keyword1 = keyword1;
	}

	public String getKeyword2()
	{
		return keyword2;
	}

	public void setKeyword2(String keyword2)
	{
		this.keyword2 = keyword2;
	}

	public boolean isFilter()
	{
		return filter;
	}

	public void setFilter(boolean filter)
	{
		this.filter = filter;
	}

	public boolean isMcu()
	{
		return mcu;
	}

	public void setMcu(boolean mcu)
	{
		this.mcu = mcu;
	}

	public boolean isStar()
	{
		return star;
	}

	public void setStar(boolean star)
	{
		this.star = star;
	}

	public boolean isRepeat()
	{
		return repeat;
	}

	public void setRepeat(boolean repeat)
	{
		this.repeat = repeat;
	}

	public boolean isProcessor()
	{
		return processor;
	}

	public void setProcessor(boolean processor)
	{
		this.processor = processor;
	}

	public boolean isMemory()
	{
		return memory;
	}

	public void setMemory(boolean memory)
	{
		this.memory = memory;
	}

	public boolean isAnalog()
	{
		return analog;
	}

	public void setAnalog(boolean analog)
	{
		this.analog = analog;
	}

	public boolean isLogic()
	{
		return logic;
	}

	public void setLogic(boolean logic)
	{
		this.logic = logic;
	}

	public boolean isPld()
	{
		return pld;
	}

	public void setPld(boolean pld)
	{
		this.pld = pld;
	}

	public boolean isPowersupply()
	{
		return powersupply;
	}

	public void setPowersupply(boolean powersupply)
	{
		this.powersupply = powersupply;
	}

	public boolean isAutomotive()
	{
		return automotive;
	}

	public void setAutomotive(boolean automotive)
	{
		this.automotive = automotive;
	}

	public boolean isCellphone()
	{
		return cellphone;
	}

	public void setCellphone(boolean cellphone)
	{
		this.cellphone = cellphone;
	}

	public boolean isConsumer()
	{
		return consumer;
	}

	public void setConsumer(boolean consumer)
	{
		this.consumer = consumer;
	}

	public boolean isComputer()
	{
		return computer;
	}

	public void setComputer(boolean computer)
	{
		this.computer = computer;
	}

	public boolean isCommunication()
	{
		return communication;
	}

	public void setCommunication(boolean communication)
	{
		this.communication = communication;
	}

	public boolean isRf()
	{
		return rf;
	}

	public void setRf(boolean rf)
	{
		this.rf = rf;
	}

	public boolean isSubsys()
	{
		return subsys;
	}

	public void setSubsys(boolean subsys)
	{
		this.subsys = subsys;
	}

	public boolean isRefdesign()
	{
		return refdesign;
	}

	public void setRefdesign(boolean refdesign)
	{
		this.refdesign = refdesign;
	}

	public boolean isSoftware()
	{
		return software;
	}

	public void setSoftware(boolean software)
	{
		this.software = software;
	}

	public boolean isTest()
	{
		return test;
	}

	public void setTest(boolean test)
	{
		this.test = test;
	}

	public boolean isDiscrete()
	{
		return discrete;
	}

	public void setDiscrete(boolean discrete)
	{
		this.discrete = discrete;
	}

	public boolean isOpto()
	{
		return opto;
	}

	public void setOpto(boolean opto)
	{
		this.opto = opto;
	}

	public boolean isPassive()
	{
		return passive;
	}

	public void setPassive(boolean passive)
	{
		this.passive = passive;
	}

	public boolean isInterconnect()
	{
		return interconnect;
	}

	public void setInterconnect(boolean interconnect)
	{
		this.interconnect = interconnect;
	}

	public boolean isSensors()
	{
		return sensors;
	}

	public void setSensors(boolean sensors)
	{
		this.sensors = sensors;
	}

	public boolean isBattery()
	{
		return battery;
	}

	public void setBattery(boolean battery)
	{
		this.battery = battery;
	}

	public boolean isIndia()
	{
		return india;
	}

	public void setIndia(boolean india)
	{
		this.india = india;
	}

	public boolean isStudent()
	{
		return student;
	}

	public void setStudent(boolean student)
	{
		this.student = student;
	}

	public boolean isMedical()
	{
		return medical;
	}

	public void setMedical(boolean medical)
	{
		this.medical = medical;
	}

	public boolean isSecurity()
	{
		return security;
	}

	public void setSecurity(boolean security)
	{
		this.security = security;
	}

	public boolean isAerospace()
	{
		return aerospace;
	}

	public void setAerospace(boolean aerospace)
	{
		this.aerospace = aerospace;
	}

	public boolean isSolar()
	{
		return solar;
	}

	public void setSolar(boolean solar)
	{
		this.solar = solar;
	}

	public boolean isMarket()
	{
		return market;
	}

	public void setMarket(boolean market)
	{
		this.market = market;
	}

	public boolean isDcdcconverter()
	{
		return dcdcconverter;
	}

	public void setDcdcconverter(boolean dcdcconverter)
	{
		this.dcdcconverter = dcdcconverter;
	}

	public boolean isIndiaSemiConductor()
	{
		return indiaSemiConductor;
	}

	public void setIndiaSemiConductor(boolean indiaSemiConductor)
	{
		this.indiaSemiConductor = indiaSemiConductor;
	}

	public boolean isEmbeddedcomputer()
	{
		return embeddedcomputer;
	}

	public void setEmbeddedcomputer(boolean embeddedcomputer)
	{
		this.embeddedcomputer = embeddedcomputer;
	}

}
