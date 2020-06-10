package cn.edu.cqut.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CustomerService extends Model<CustomerService> {
	private static final long serialVersionUID=1L;

    @ApiModelProperty("编号")
    @TableId("id")
    private Integer id;
    
    @ApiModelProperty("客户编号")
    @TableId("customer_id")
    private String customerId;

    @ApiModelProperty("服务内容")
    @TableId("service_content")
    private String serviceContent;
    
    @ApiModelProperty("服务类型")
    @TableId("service_type")
    private String serviceType;
    
    @ApiModelProperty("创建人")
    @TableId("builder")
    private String builder;
    
    @ApiModelProperty("创建时间")
    @TableId("create_time")
    private Date createTime;

    @ApiModelProperty("服务状态")
    @TableId("service_status")
    private String serviceStatus;
    
    @ApiModelProperty("分配者")
    @TableId("allocator")
    private String allocator;
    
    @ApiModelProperty("分配时间")
    @TableId("allocate_time")
    private Date allocateTime;
    
    @ApiModelProperty("处理方法")
    @TableId("handle_method")
    private String handleMethod;
    
    @ApiModelProperty("处理人")
    @TableId("handler")
    private String handler;
    
    @ApiModelProperty("处理时间")
    @TableId("handle_time")
    private Date handleTime;
    
    @ApiModelProperty("处理结果")
    @TableId("handle_result")
    private String handleResult;
    
    @ApiModelProperty("满意度")
    @TableId("satisfaction")
    private Integer satisfaction;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getAllocator() {
		return allocator;
	}

	public void setAllocator(String allocator) {
		this.allocator = allocator;
	}

	public Date getAllocateTime() {
		return allocateTime;
	}

	public void setAllocateTime(Date allocateTime) {
		this.allocateTime = allocateTime;
	}

	public String getHandleMethod() {
		return handleMethod;
	}

	public void setHandleMethod(String handleMethod) {
		this.handleMethod = handleMethod;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public Integer getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(Integer satisfaction) {
		this.satisfaction = satisfaction;
	}
}
