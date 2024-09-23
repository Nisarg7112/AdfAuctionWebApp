package model.entity;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Sep 22 16:39:09 IST 2024
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class G4AuctionEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        Auctionid,
        Itemname,
        Buyerid,
        Auctionstate,
        Creatorid,
        Categoryid,
        Starttime,
        Endtime,
        Createdon,
        Image,
        Startprice,
        Currentprice,
        Description,
        Column1,
        Column2,
        Column3,
        Column4,
        Column5,
        Column6,
        Column7,
        G4BidEO,
        G4UsersEO,
        G4UsersEO1,
        G4AucstatesEO,
        G4CategoryEO;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int AUCTIONID = AttributesEnum.Auctionid.index();
    public static final int ITEMNAME = AttributesEnum.Itemname.index();
    public static final int BUYERID = AttributesEnum.Buyerid.index();
    public static final int AUCTIONSTATE = AttributesEnum.Auctionstate.index();
    public static final int CREATORID = AttributesEnum.Creatorid.index();
    public static final int CATEGORYID = AttributesEnum.Categoryid.index();
    public static final int STARTTIME = AttributesEnum.Starttime.index();
    public static final int ENDTIME = AttributesEnum.Endtime.index();
    public static final int CREATEDON = AttributesEnum.Createdon.index();
    public static final int IMAGE = AttributesEnum.Image.index();
    public static final int STARTPRICE = AttributesEnum.Startprice.index();
    public static final int CURRENTPRICE = AttributesEnum.Currentprice.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int COLUMN1 = AttributesEnum.Column1.index();
    public static final int COLUMN2 = AttributesEnum.Column2.index();
    public static final int COLUMN3 = AttributesEnum.Column3.index();
    public static final int COLUMN4 = AttributesEnum.Column4.index();
    public static final int COLUMN5 = AttributesEnum.Column5.index();
    public static final int COLUMN6 = AttributesEnum.Column6.index();
    public static final int COLUMN7 = AttributesEnum.Column7.index();
    public static final int G4BIDEO = AttributesEnum.G4BidEO.index();
    public static final int G4USERSEO = AttributesEnum.G4UsersEO.index();
    public static final int G4USERSEO1 = AttributesEnum.G4UsersEO1.index();
    public static final int G4AUCSTATESEO = AttributesEnum.G4AucstatesEO.index();
    public static final int G4CATEGORYEO = AttributesEnum.G4CategoryEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public G4AuctionEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.entity.G4AuctionEO");
    }


    /**
     * Gets the attribute value for Auctionid, using the alias name Auctionid.
     * @return the value of Auctionid
     */
    public BigDecimal getAuctionid() {
        return (BigDecimal) getAttributeInternal(AUCTIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Auctionid.
     * @param value value to set the Auctionid
     */
    public void setAuctionid(BigDecimal value) {
        setAttributeInternal(AUCTIONID, value);
    }

    /**
     * Gets the attribute value for Itemname, using the alias name Itemname.
     * @return the value of Itemname
     */
    public String getItemname() {
        return (String) getAttributeInternal(ITEMNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Itemname.
     * @param value value to set the Itemname
     */
    public void setItemname(String value) {
        setAttributeInternal(ITEMNAME, value);
    }

    /**
     * Gets the attribute value for Buyerid, using the alias name Buyerid.
     * @return the value of Buyerid
     */
    public BigDecimal getBuyerid() {
        return (BigDecimal) getAttributeInternal(BUYERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Buyerid.
     * @param value value to set the Buyerid
     */
    public void setBuyerid(BigDecimal value) {
        setAttributeInternal(BUYERID, value);
    }

    /**
     * Gets the attribute value for Auctionstate, using the alias name Auctionstate.
     * @return the value of Auctionstate
     */
    public BigDecimal getAuctionstate() {
        return (BigDecimal) getAttributeInternal(AUCTIONSTATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Auctionstate.
     * @param value value to set the Auctionstate
     */
    public void setAuctionstate(BigDecimal value) {
        setAttributeInternal(AUCTIONSTATE, value);
    }

    /**
     * Gets the attribute value for Creatorid, using the alias name Creatorid.
     * @return the value of Creatorid
     */
    public BigDecimal getCreatorid() {
        return (BigDecimal) getAttributeInternal(CREATORID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Creatorid.
     * @param value value to set the Creatorid
     */
    public void setCreatorid(BigDecimal value) {
        setAttributeInternal(CREATORID, value);
    }

    /**
     * Gets the attribute value for Categoryid, using the alias name Categoryid.
     * @return the value of Categoryid
     */
    public BigDecimal getCategoryid() {
        return (BigDecimal) getAttributeInternal(CATEGORYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Categoryid.
     * @param value value to set the Categoryid
     */
    public void setCategoryid(BigDecimal value) {
        setAttributeInternal(CATEGORYID, value);
    }

    /**
     * Gets the attribute value for Starttime, using the alias name Starttime.
     * @return the value of Starttime
     */
    public Timestamp getStarttime() {
        return (Timestamp) getAttributeInternal(STARTTIME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Starttime.
     * @param value value to set the Starttime
     */
    public void setStarttime(Timestamp value) {
        setAttributeInternal(STARTTIME, value);
    }

    /**
     * Gets the attribute value for Endtime, using the alias name Endtime.
     * @return the value of Endtime
     */
    public Timestamp getEndtime() {
        return (Timestamp) getAttributeInternal(ENDTIME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Endtime.
     * @param value value to set the Endtime
     */
    public void setEndtime(Timestamp value) {
        setAttributeInternal(ENDTIME, value);
    }

    /**
     * Gets the attribute value for Createdon, using the alias name Createdon.
     * @return the value of Createdon
     */
    public Timestamp getCreatedon() {
        return (Timestamp) getAttributeInternal(CREATEDON);
    }

    /**
     * Sets <code>value</code> as the attribute value for Createdon.
     * @param value value to set the Createdon
     */
    public void setCreatedon(Timestamp value) {
        setAttributeInternal(CREATEDON, value);
    }

    /**
     * Gets the attribute value for Image, using the alias name Image.
     * @return the value of Image
     */
    public BlobDomain getImage() {
        return (BlobDomain) getAttributeInternal(IMAGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Image.
     * @param value value to set the Image
     */
    public void setImage(BlobDomain value) {
        setAttributeInternal(IMAGE, value);
    }

    /**
     * Gets the attribute value for Startprice, using the alias name Startprice.
     * @return the value of Startprice
     */
    public BigDecimal getStartprice() {
        return (BigDecimal) getAttributeInternal(STARTPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Startprice.
     * @param value value to set the Startprice
     */
    public void setStartprice(BigDecimal value) {
        setAttributeInternal(STARTPRICE, value);
    }

    /**
     * Gets the attribute value for Currentprice, using the alias name Currentprice.
     * @return the value of Currentprice
     */
    public BigDecimal getCurrentprice() {
        return (BigDecimal) getAttributeInternal(CURRENTPRICE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Currentprice.
     * @param value value to set the Currentprice
     */
    public void setCurrentprice(BigDecimal value) {
        setAttributeInternal(CURRENTPRICE, value);
    }

    /**
     * Gets the attribute value for Description, using the alias name Description.
     * @return the value of Description
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Description.
     * @param value value to set the Description
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for Column1, using the alias name Column1.
     * @return the value of Column1
     */
    public String getColumn1() {
        return (String) getAttributeInternal(COLUMN1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column1.
     * @param value value to set the Column1
     */
    public void setColumn1(String value) {
        setAttributeInternal(COLUMN1, value);
    }

    /**
     * Gets the attribute value for Column2, using the alias name Column2.
     * @return the value of Column2
     */
    public String getColumn2() {
        return (String) getAttributeInternal(COLUMN2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column2.
     * @param value value to set the Column2
     */
    public void setColumn2(String value) {
        setAttributeInternal(COLUMN2, value);
    }

    /**
     * Gets the attribute value for Column3, using the alias name Column3.
     * @return the value of Column3
     */
    public BigDecimal getColumn3() {
        return (BigDecimal) getAttributeInternal(COLUMN3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column3.
     * @param value value to set the Column3
     */
    public void setColumn3(BigDecimal value) {
        setAttributeInternal(COLUMN3, value);
    }

    /**
     * Gets the attribute value for Column4, using the alias name Column4.
     * @return the value of Column4
     */
    public BigDecimal getColumn4() {
        return (BigDecimal) getAttributeInternal(COLUMN4);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column4.
     * @param value value to set the Column4
     */
    public void setColumn4(BigDecimal value) {
        setAttributeInternal(COLUMN4, value);
    }

    /**
     * Gets the attribute value for Column5, using the alias name Column5.
     * @return the value of Column5
     */
    public Timestamp getColumn5() {
        return (Timestamp) getAttributeInternal(COLUMN5);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column5.
     * @param value value to set the Column5
     */
    public void setColumn5(Timestamp value) {
        setAttributeInternal(COLUMN5, value);
    }

    /**
     * Gets the attribute value for Column6, using the alias name Column6.
     * @return the value of Column6
     */
    public Timestamp getColumn6() {
        return (Timestamp) getAttributeInternal(COLUMN6);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column6.
     * @param value value to set the Column6
     */
    public void setColumn6(Timestamp value) {
        setAttributeInternal(COLUMN6, value);
    }

    /**
     * Gets the attribute value for Column7, using the alias name Column7.
     * @return the value of Column7
     */
    public BlobDomain getColumn7() {
        return (BlobDomain) getAttributeInternal(COLUMN7);
    }

    /**
     * Sets <code>value</code> as the attribute value for Column7.
     * @param value value to set the Column7
     */
    public void setColumn7(BlobDomain value) {
        setAttributeInternal(COLUMN7, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getG4BidEO() {
        return (RowIterator) getAttributeInternal(G4BIDEO);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getG4UsersEO() {
        return (EntityImpl) getAttributeInternal(G4USERSEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setG4UsersEO(EntityImpl value) {
        setAttributeInternal(G4USERSEO, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getG4UsersEO1() {
        return (EntityImpl) getAttributeInternal(G4USERSEO1);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setG4UsersEO1(EntityImpl value) {
        setAttributeInternal(G4USERSEO1, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getG4AucstatesEO() {
        return (RowIterator) getAttributeInternal(G4AUCSTATESEO);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getG4CategoryEO() {
        return (EntityImpl) getAttributeInternal(G4CATEGORYEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setG4CategoryEO(EntityImpl value) {
        setAttributeInternal(G4CATEGORYEO, value);
    }


    /**
     * @param auctionid key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal auctionid) {
        return new Key(new Object[] { auctionid });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        setAuctionstate(BigDecimal.valueOf(1));
        setCreatorid(BigDecimal.valueOf(1));
        super.create(attributeList);
        
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}

