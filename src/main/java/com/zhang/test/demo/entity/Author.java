package com.zhang.test.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable{
    
	private static final long serialVersionUID = -2458355897647481921L;

	private Integer authorId;					//作者id
    private String userId;						//作者id
    private Integer userType;					//用户自媒体类型（1：写手2：后台管理员3：超管)
    private String authorName;					//作者真实姓名
    private String authorMediaName;				//作者名称
    private String authorTel;					//作者联系方式
    private String authorCity;					//作者所在城市
    private String authorTag;					//作者标签
    private Integer authorStatus;				//作者状态（1：正常  2：冻结）
    private String authorIntroduction;			//作者介绍
    private String authorPhotoUrl;				//作者头像URL
    private Date updateDate;					//作者修改资料时间
    private String authorApply;					//作者平台权限（a:fzx b:mtmy c:blln）
    private Integer delFlag;					//删除标识
    private Date authorIntroductionUpdateDate;	//介绍最后一次修改时间
    private Integer fileIsComplete;				// 资料是否完善（1：是 2：否）
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorMediaName() {
		return authorMediaName;
	}
	public void setAuthorMediaName(String authorMediaName) {
		this.authorMediaName = authorMediaName;
	}
	public String getAuthorTel() {
		return authorTel;
	}
	public void setAuthorTel(String authorTel) {
		this.authorTel = authorTel;
	}
	public String getAuthorCity() {
		return authorCity;
	}
	public void setAuthorCity(String authorCity) {
		this.authorCity = authorCity;
	}
	public String getAuthorTag() {
		return authorTag;
	}
	public void setAuthorTag(String authorTag) {
		this.authorTag = authorTag;
	}
	public Integer getAuthorStatus() {
		return authorStatus;
	}
	public void setAuthorStatus(Integer authorStatus) {
		this.authorStatus = authorStatus;
	}
	public String getAuthorIntroduction() {
		return authorIntroduction;
	}
	public void setAuthorIntroduction(String authorIntroduction) {
		this.authorIntroduction = authorIntroduction;
	}
	public String getAuthorPhotoUrl() {
		return authorPhotoUrl;
	}
	public void setAuthorPhotoUrl(String authorPhotoUrl) {
		this.authorPhotoUrl = authorPhotoUrl;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getAuthorApply() {
		return authorApply;
	}
	public void setAuthorApply(String authorApply) {
		this.authorApply = authorApply;
	}
	public Integer getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	public Date getAuthorIntroductionUpdateDate() {
		return authorIntroductionUpdateDate;
	}
	public void setAuthorIntroductionUpdateDate(Date authorIntroductionUpdateDate) {
		this.authorIntroductionUpdateDate = authorIntroductionUpdateDate;
	}
	public Integer getFileIsComplete() {
		return fileIsComplete;
	}
	public void setFileIsComplete(Integer fileIsComplete) {
		this.fileIsComplete = fileIsComplete;
	}
}