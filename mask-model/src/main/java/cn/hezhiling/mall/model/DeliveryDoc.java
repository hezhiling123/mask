package cn.hezhiling.mall.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DeliveryDoc implements Serializable{
    private static final long serialVersionUID = -302821580099291347L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.order_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Long orderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.order_sn
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String orderSn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.user_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.admin_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String adminId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.consignee
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String consignee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.zipcode
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String zipcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.mobile
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.country
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer country;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.province
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.city
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.district
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer district;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.address
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.shipping_code
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String shippingCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.shipping_name
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String shippingName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.shipping_price
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private BigDecimal shippingPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.invoice_no
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String invoiceNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.tel
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.best_time
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer bestTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.create_time
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Integer createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.is_del
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private Boolean isDel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tp_delivery_doc.note
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    private String note;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.id
     *
     * @return the value of tp_delivery_doc.id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.id
     *
     * @param id the value for tp_delivery_doc.id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.order_id
     *
     * @return the value of tp_delivery_doc.order_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.order_id
     *
     * @param orderId the value for tp_delivery_doc.order_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.order_sn
     *
     * @return the value of tp_delivery_doc.order_sn
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.order_sn
     *
     * @param orderSn the value for tp_delivery_doc.order_sn
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.user_id
     *
     * @return the value of tp_delivery_doc.user_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.user_id
     *
     * @param userId the value for tp_delivery_doc.user_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.admin_id
     *
     * @return the value of tp_delivery_doc.admin_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getAdminId() {
        return adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.admin_id
     *
     * @param adminId the value for tp_delivery_doc.admin_id
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.consignee
     *
     * @return the value of tp_delivery_doc.consignee
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.consignee
     *
     * @param consignee the value for tp_delivery_doc.consignee
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.zipcode
     *
     * @return the value of tp_delivery_doc.zipcode
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.zipcode
     *
     * @param zipcode the value for tp_delivery_doc.zipcode
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.mobile
     *
     * @return the value of tp_delivery_doc.mobile
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.mobile
     *
     * @param mobile the value for tp_delivery_doc.mobile
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.country
     *
     * @return the value of tp_delivery_doc.country
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.country
     *
     * @param country the value for tp_delivery_doc.country
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setCountry(Integer country) {
        this.country = country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.province
     *
     * @return the value of tp_delivery_doc.province
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.province
     *
     * @param province the value for tp_delivery_doc.province
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.city
     *
     * @return the value of tp_delivery_doc.city
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.city
     *
     * @param city the value for tp_delivery_doc.city
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.district
     *
     * @return the value of tp_delivery_doc.district
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getDistrict() {
        return district;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.district
     *
     * @param district the value for tp_delivery_doc.district
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setDistrict(Integer district) {
        this.district = district;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.address
     *
     * @return the value of tp_delivery_doc.address
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.address
     *
     * @param address the value for tp_delivery_doc.address
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.shipping_code
     *
     * @return the value of tp_delivery_doc.shipping_code
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getShippingCode() {
        return shippingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.shipping_code
     *
     * @param shippingCode the value for tp_delivery_doc.shipping_code
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.shipping_name
     *
     * @return the value of tp_delivery_doc.shipping_name
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.shipping_name
     *
     * @param shippingName the value for tp_delivery_doc.shipping_name
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.shipping_price
     *
     * @return the value of tp_delivery_doc.shipping_price
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.shipping_price
     *
     * @param shippingPrice the value for tp_delivery_doc.shipping_price
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.invoice_no
     *
     * @return the value of tp_delivery_doc.invoice_no
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.invoice_no
     *
     * @param invoiceNo the value for tp_delivery_doc.invoice_no
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.tel
     *
     * @return the value of tp_delivery_doc.tel
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.tel
     *
     * @param tel the value for tp_delivery_doc.tel
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.best_time
     *
     * @return the value of tp_delivery_doc.best_time
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getBestTime() {
        return bestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.best_time
     *
     * @param bestTime the value for tp_delivery_doc.best_time
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setBestTime(Integer bestTime) {
        this.bestTime = bestTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.create_time
     *
     * @return the value of tp_delivery_doc.create_time
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.create_time
     *
     * @param createTime the value for tp_delivery_doc.create_time
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.is_del
     *
     * @return the value of tp_delivery_doc.is_del
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.is_del
     *
     * @param isDel the value for tp_delivery_doc.is_del
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tp_delivery_doc.note
     *
     * @return the value of tp_delivery_doc.note
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tp_delivery_doc.note
     *
     * @param note the value for tp_delivery_doc.note
     *
     * @mbg.generated Thu Mar 22 10:05:15 CST 2018
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}