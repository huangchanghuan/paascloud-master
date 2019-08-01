package com.paascloud.provider.model.domain;

import java.util.Date;

public class UacRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.version
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private Integer version;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.role_code
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private String roleCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.role_name
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.status
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.remark
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.creator
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.creator_id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private Long creatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.created_time
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.last_operator
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private String lastOperator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.last_operator_id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private Long lastOperatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pc_uac_role.update_time
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.id
     *
     * @return the value of pc_uac_role.id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.id
     *
     * @param id the value for pc_uac_role.id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.version
     *
     * @return the value of pc_uac_role.version
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.version
     *
     * @param version the value for pc_uac_role.version
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.role_code
     *
     * @return the value of pc_uac_role.role_code
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.role_code
     *
     * @param roleCode the value for pc_uac_role.role_code
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.role_name
     *
     * @return the value of pc_uac_role.role_name
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.role_name
     *
     * @param roleName the value for pc_uac_role.role_name
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.status
     *
     * @return the value of pc_uac_role.status
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.status
     *
     * @param status the value for pc_uac_role.status
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.remark
     *
     * @return the value of pc_uac_role.remark
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.remark
     *
     * @param remark the value for pc_uac_role.remark
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.creator
     *
     * @return the value of pc_uac_role.creator
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.creator
     *
     * @param creator the value for pc_uac_role.creator
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.creator_id
     *
     * @return the value of pc_uac_role.creator_id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.creator_id
     *
     * @param creatorId the value for pc_uac_role.creator_id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.created_time
     *
     * @return the value of pc_uac_role.created_time
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.created_time
     *
     * @param createdTime the value for pc_uac_role.created_time
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.last_operator
     *
     * @return the value of pc_uac_role.last_operator
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public String getLastOperator() {
        return lastOperator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.last_operator
     *
     * @param lastOperator the value for pc_uac_role.last_operator
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator == null ? null : lastOperator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.last_operator_id
     *
     * @return the value of pc_uac_role.last_operator_id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public Long getLastOperatorId() {
        return lastOperatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.last_operator_id
     *
     * @param lastOperatorId the value for pc_uac_role.last_operator_id
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setLastOperatorId(Long lastOperatorId) {
        this.lastOperatorId = lastOperatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pc_uac_role.update_time
     *
     * @return the value of pc_uac_role.update_time
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pc_uac_role.update_time
     *
     * @param updateTime the value for pc_uac_role.update_time
     *
     * @mbg.generated Tue Jul 02 15:11:41 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}