package com.nari.slsd.gglck.util;

/**
 * 操作类型的枚举
 * 
 * @author fenghuiyang
 * 
 */
public enum OperationType
{
	//REGISTE("过闸登记", 1);
	LOCKFEE("缴纳过闸费用",1),
	FEECHECK("缴纳查补费用",2),
	FEEVIP("缴纳提放费用",3),
	CANCELVIP("缴费窗口取消提放",4),
	CANCELCHECKREFUND("缴费窗口取消查补退费",5),
	CHECHREFUND("退查补费 ",6),
	LOCKREFUND("退过闸费",7),
	VIPREFUND("退提放费",8),
	LOCKAGE("过闸确认",9),
	REGISTEROFF("未缴费船舶注销申请",10),
	CANCELREGISTERADD("船舶销号申请",11),
	CANCELREGISTERUPDATE("船舶销号修改",12),
	CANCELREGISTERAUDITTHROUGH("船舶销号审核通过",13),
	CANCELREGISTEROVERRULE("船舶销号审核不通过",14),
	VESSELLOCKEDADD("添加船舶锁定信息",15),
	VESSELLOCKEDUPDATE("修改船舶锁定信息",16),
	VESSELLOCKEDUNLOCK("解除船舶锁定",17),
	REGISTER("船舶登记",18),	//fa-desktop
	DISPATCH("船舶预调",19),
	ARRIVALPORT("船舶到港确认",20),
	/**提放申请*/
	VIPAPPLY("提放申请",21),
	/**提放修改*/
	VIPUPDATE("提放修改",22),
	/**提放审核*/
	VIPREVIEW("提放审核",23),
	/**免征申请*/
	EXEMPTAPPLY("免征申请",24),
	/**免征修改*/
	EXEMPTUPDATE("免征修改",25),
	/**免征审核*/
	EXEMPTREVIEW("免征审核",26),
	/**查补申请*/
	CHECKAPPLY("查补申请",27),
	/**查补修改*/
	CHECKUPDATE("查补修改",28),
	/**查补审核*/
	CHECKREVIEW("查补审核",29),
	/**船舶补调*/
	SUPPLEMENT("船舶补调",30),
	/**船舶转库操作*/
	STOCKTRANSFER("船舶转库操作",31),
	/**撤回系统自动注销*/
	REVOKECANCELREGISTER("手动撤回系统自动注销",32),
	/**缴费成功,撤回系统自动注销*/
	FEEREVOKECANCELREGISTER("缴费成功,自动撤回系统自动注销",33),
	/**提放审批*/
	VIPAPPROVAL("提放审批",34),
	
	CANCELREGISTERAPPROVAL("船舶销号审批通过",35),
	
	CHECKAPPROVAL("查补审批",36),
	
	CHECKREVOKE("撤销查补",37);
	
	private int code;
	private String describe;

	private OperationType(String describe, int code)
	{
		this.describe = describe;
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}

	public static OperationType codeOf(int code)
	{
		for(OperationType type : values())
		{
			if(type.getCode() == code)
			{
				return type;
			}
		}
		return null;
	}

	@Override
	public String toString()
	{
		return describe;
	}

	public static void main(String[] args)
	{
		System.out.println(OperationType.valueOf("LOCKFEE").getCode());
		System.out.println(OperationType.codeOf(1));
	}
}
